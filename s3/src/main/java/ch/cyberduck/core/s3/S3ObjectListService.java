package ch.cyberduck.core.s3;

/*
 * Copyright (c) 2002-2014 David Kocher. All rights reserved.
 * http://cyberduck.io/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * Bug fixes, suggestions and comments should be sent to:
 * feedback@cyberduck.io
 */

import ch.cyberduck.core.AttributedList;
import ch.cyberduck.core.ListProgressListener;
import ch.cyberduck.core.ListService;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.PathAttributes;
import ch.cyberduck.core.PathContainerService;
import ch.cyberduck.core.PathNormalizer;
import ch.cyberduck.core.URIEncoder;
import ch.cyberduck.core.exception.BackgroundException;
import ch.cyberduck.core.exception.NotfoundException;
import ch.cyberduck.core.preferences.Preferences;
import ch.cyberduck.core.preferences.PreferencesFactory;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.jets3t.service.ServiceException;
import org.jets3t.service.StorageObjectsChunk;
import org.jets3t.service.model.StorageObject;

import java.util.Arrays;
import java.util.EnumSet;

public class S3ObjectListService extends S3AbstractListService implements ListService {
    private static final Logger log = Logger.getLogger(S3ObjectListService.class);

    private final Preferences preferences
        = PreferencesFactory.get();

    private final PathContainerService containerService;
    private final S3Session session;
    private final S3AttributesFinderFeature attributes;

    public S3ObjectListService(final S3Session session) {
        super(session);
        this.session = session;
        this.attributes = new S3AttributesFinderFeature(session);
        this.containerService = session.getFeature(PathContainerService.class);
    }

    @Override
    public AttributedList<Path> list(final Path directory, final ListProgressListener listener) throws BackgroundException {
        return this.list(directory, listener, String.valueOf(Path.DELIMITER));
    }

    protected AttributedList<Path> list(final Path directory, final ListProgressListener listener, final String delimiter) throws BackgroundException {
        return this.list(directory, listener, delimiter, preferences.getInteger("s3.listing.chunksize"));
    }

    protected AttributedList<Path> list(final Path directory, final ListProgressListener listener, final String delimiter, final int chunksize) throws BackgroundException {
        try {
            final String prefix = this.createPrefix(directory);
            // If this optional, Unicode string parameter is included with your request,
            // then keys that contain the same string between the prefix and the first
            // occurrence of the delimiter will be rolled up into a single result
            // element in the CommonPrefixes collection. These rolled-up keys are
            // not returned elsewhere in the response.
            final Path bucket = containerService.getContainer(directory);
            final AttributedList<Path> children = new AttributedList<>();
            // Null if listing is complete
            String priorLastKey = null;
            boolean hasDirectoryPlaceholder = containerService.isContainer(directory);
            do {
                // Read directory listing in chunks. List results are always returned
                // in lexicographic (alphabetical) order.
                final StorageObjectsChunk chunk = session.getClient().listObjectsChunked(
                    bucket.isRoot() ? StringUtils.EMPTY : PathNormalizer.name(URIEncoder.encode(bucket.getName())), prefix, delimiter,
                    chunksize, priorLastKey, false);

                final StorageObject[] objects = chunk.getObjects();
                for(StorageObject object : objects) {
                    final String key = PathNormalizer.normalize(URIEncoder.decode(object.getKey()));
                    if(String.valueOf(Path.DELIMITER).equals(key)) {
                        log.warn(String.format("Skipping prefix %s", key));
                        continue;
                    }
                    if(new Path(bucket, key, EnumSet.of(Path.Type.directory)).equals(directory)) {
                        // Placeholder object, skip
                        hasDirectoryPlaceholder = true;
                        continue;
                    }
                    final EnumSet<Path.Type> types = object.getKey().endsWith(String.valueOf(Path.DELIMITER))
                        ? EnumSet.of(Path.Type.directory) : EnumSet.of(Path.Type.file);
                    final Path file;
                    final PathAttributes attr = attributes.toAttributes(object);
                    // Copy bucket location
                    attr.setRegion(bucket.attributes().getRegion());
                    if(null == delimiter) {
                        file = new Path(String.format("%s%s", bucket.getAbsolute(), key), types, attr);
                    }
                    else {
                        file = new Path(directory.isDirectory() ? directory : directory.getParent(), PathNormalizer.name(key), types, attr);
                    }
                    children.add(file);
                }
                final String[] prefixes = chunk.getCommonPrefixes();
                for(String common : prefixes) {
                    if(String.valueOf(Path.DELIMITER).equals(common)) {
                        log.warn(String.format("Skipping prefix %s", common));
                        continue;
                    }
                    final String key = PathNormalizer.normalize(URIEncoder.decode(common));
                    if(new Path(bucket, key, EnumSet.of(Path.Type.directory)).equals(directory)) {
                        continue;
                    }
                    final Path file;
                    final PathAttributes attributes = new PathAttributes();
                    if(null == delimiter) {
                        file = new Path(String.format("%s%s", bucket.getAbsolute(), key), EnumSet.of(Path.Type.directory, Path.Type.placeholder), attributes);
                    }
                    else {
                        file = new Path(directory.isDirectory() ? directory : directory.getParent(), PathNormalizer.name(key), EnumSet.of(Path.Type.directory, Path.Type.placeholder), attributes);
                    }
                    attributes.setRegion(bucket.attributes().getRegion());
                    children.add(file);
                }
                priorLastKey = null != chunk.getPriorLastKey() ? URIEncoder.decode(chunk.getPriorLastKey()) : null;
                listener.chunk(directory, children);
            }
            while(priorLastKey != null);
            if(!hasDirectoryPlaceholder && children.isEmpty()) {
                // Only for AWS
                if(S3Session.isAwsHostname(session.getHost().getHostname())) {
                    throw new NotfoundException(directory.getAbsolute());
                }
                // Handle missing prefix for directory placeholders in Minio
                final StorageObjectsChunk chunk = session.getClient().listObjectsChunked(
                    PathNormalizer.name(URIEncoder.encode(bucket.getName())), String.format("%s%s", this.createPrefix(directory.getParent()), directory.getName()), delimiter, 1, null);
                if(Arrays.stream(chunk.getCommonPrefixes()).map(URIEncoder::decode).noneMatch(common -> common.equals(prefix))) {
                    throw new NotfoundException(directory.getAbsolute());
                }
            }
            return children;
        }
        catch(ServiceException e) {
            throw new S3ExceptionMappingService().map("Listing directory {0} failed", e, directory);
        }
    }
}
