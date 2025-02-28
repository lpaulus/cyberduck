package ch.cyberduck.core.vault.registry;

/*
 * Copyright (c) 2002-2016 iterate GmbH. All rights reserved.
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
import ch.cyberduck.core.ListProgressListener;
import ch.cyberduck.core.ListService;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.Session;
import ch.cyberduck.core.exception.BackgroundException;
import ch.cyberduck.core.features.Vault;
import ch.cyberduck.core.preferences.Preferences;
import ch.cyberduck.core.preferences.PreferencesFactory;
import ch.cyberduck.core.vault.VaultFinderListProgressListener;
import ch.cyberduck.core.vault.VaultFinderListService;
import ch.cyberduck.core.vault.VaultLookupListener;
import ch.cyberduck.core.vault.VaultRegistry;
import ch.cyberduck.core.vault.VaultUnlockCancelException;

import org.apache.log4j.Logger;

public class VaultRegistryListService implements ListService {
    private static final Logger log = Logger.getLogger(VaultRegistryListService.class);

    private final Preferences preferences = PreferencesFactory.get();

    private final VaultRegistry registry;
    private final VaultLookupListener lookup;
    private final Session<?> session;
    private final ListService proxy;

    private boolean autodetect = preferences.getBoolean("cryptomator.vault.autodetect")
        && preferences.getBoolean("cryptomator.enable");

    public VaultRegistryListService(final Session<?> session, final ListService proxy, final VaultRegistry registry, final VaultLookupListener lookup) {
        this.session = session;
        this.proxy = proxy;
        this.registry = registry;
        this.lookup = lookup;
    }

    @Override
    public AttributedList<Path> list(final Path directory, final ListProgressListener listener) throws BackgroundException {
        try {
            final Vault vault = registry.find(session, directory);
            if(vault.contains(directory)) {
                return vault.getFeature(session, ListService.class, proxy).list(directory, listener);
            }
            if(autodetect) {
                return new VaultFinderListService(session, proxy, new VaultFinderListProgressListener(session, lookup, listener)).list(directory, listener);
            }
            return proxy.list(directory, listener);
        }
        catch(VaultUnlockCancelException e) {
            log.warn(String.format("Canceled loading vault %s. %s", e.getVault(), e));
            return proxy.list(directory, listener);
        }
    }

    public VaultRegistryListService withAutodetect(final boolean autodetect) {
        this.autodetect = autodetect && preferences.getBoolean("cryptomator.enable");
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("VaultRegistryListService{");
        sb.append("proxy=").append(proxy);
        sb.append('}');
        return sb.toString();
    }
}
