package ch.cyberduck.core.brick;

/*
 * Copyright (c) 2002-2021 iterate GmbH. All rights reserved.
 * https://cyberduck.io/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

import ch.cyberduck.core.AttributedList;
import ch.cyberduck.core.ListProgressListener;
import ch.cyberduck.core.ListService;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.brick.io.swagger.client.ApiException;
import ch.cyberduck.core.brick.io.swagger.client.api.FoldersApi;
import ch.cyberduck.core.brick.io.swagger.client.model.FileEntity;
import ch.cyberduck.core.exception.BackgroundException;
import ch.cyberduck.core.preferences.PreferencesFactory;

import java.util.EnumSet;
import java.util.List;

public class BrickListService implements ListService {

    private final BrickSession session;
    private BrickAttributesFinderFeature attributes;

    public BrickListService(final BrickSession session) {
        this.session = session;
        this.attributes = new BrickAttributesFinderFeature(session);
    }

    @Override
    public AttributedList<Path> list(final Path directory, final ListProgressListener listener) throws BackgroundException {
        try {
            final AttributedList<Path> children = new AttributedList<>();
            String cursor = null;
            List<FileEntity> response;
            do {
                response = new FoldersApi(session.getClient()).foldersListForPath(directory.getAbsolute(), cursor,
                    PreferencesFactory.get().getInteger("brick.listing.chunksize"),
                    null, null, null, null, null, null);
                for(FileEntity entity : response) {
                    children.add(new Path(entity.getPath(), EnumSet.of("directory".equals(entity.getType()) ? Path.Type.directory : Path.Type.file),
                        attributes.toAttributes(entity)));
                }
//                final Optional<String> header = response.getHeaders().get("X-Files-Cursor").stream().findFirst();
//                if(header.isPresent()) {
//                    cursor = header.get();
//                }
                listener.chunk(directory, children);
            }
            while(cursor != null);
            return children;
        }
        catch(ApiException e) {
            throw new BrickExceptionMappingService().map("Listing directory {0} failed", e, directory);
        }
    }
}
