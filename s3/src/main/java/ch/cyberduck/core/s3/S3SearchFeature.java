package ch.cyberduck.core.s3;

/*
 * Copyright (c) 2002-2017 iterate GmbH. All rights reserved.
 * https://cyberduck.io/
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
 */

import ch.cyberduck.core.AttributedList;
import ch.cyberduck.core.Filter;
import ch.cyberduck.core.ListProgressListener;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.exception.BackgroundException;
import ch.cyberduck.core.exception.NotfoundException;
import ch.cyberduck.core.features.Search;

import java.util.HashSet;
import java.util.Set;

public class S3SearchFeature implements Search {

    private final S3Session session;

    public S3SearchFeature(final S3Session session) {
        this.session = session;
    }

    @Override
    public AttributedList<Path> search(final Path workdir, final Filter<Path> regex, final ListProgressListener listener) throws BackgroundException {
        final AttributedList<Path> objects;
        try {
            objects = new S3ObjectListService(session).list(workdir, listener, null);
        }
        catch(NotfoundException e) {
            return AttributedList.emptyList();
        }
        final Set<Path> removal = new HashSet<>();
        for(final Path f : objects) {
            if(!f.getName().contains(regex.toPattern().pattern())) {
                removal.add(f);
            }
        }
        objects.removeAll(removal);
        return objects;
    }

    @Override
    public boolean isRecursive() {
        return true;
    }

}
