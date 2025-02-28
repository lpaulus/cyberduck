package ch.cyberduck.core.s3;

/*
 * Copyright (c) 2002-2013 David Kocher. All rights reserved.
 * http://cyberduck.ch/
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
 * Bug fixes, suggestions and comments should be sent to feedback@cyberduck.ch
 */

import ch.cyberduck.core.DescriptiveUrl;
import ch.cyberduck.core.DescriptiveUrlBag;
import ch.cyberduck.core.HostPasswordStore;
import ch.cyberduck.core.LocaleFactory;
import ch.cyberduck.core.PasswordStoreFactory;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.PathContainerService;
import ch.cyberduck.core.Scheme;
import ch.cyberduck.core.URIEncoder;
import ch.cyberduck.core.UrlProvider;
import ch.cyberduck.core.UserDateFormatterFactory;
import ch.cyberduck.core.WebUrlProvider;
import ch.cyberduck.core.preferences.PreferencesFactory;
import ch.cyberduck.core.shared.DefaultUrlProvider;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.jets3t.service.utils.ServiceUtils;

import java.net.URI;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class S3UrlProvider implements UrlProvider {
    private static final Logger log = Logger.getLogger(S3UrlProvider.class);

    private final PathContainerService containerService;
    private final HostPasswordStore store;
    private final S3Session session;

    public S3UrlProvider(final S3Session session) {
        this(session, PasswordStoreFactory.get());
    }

    public S3UrlProvider(final S3Session session, final HostPasswordStore store) {
        this.session = session;
        this.store = store;
        this.containerService = session.getFeature(PathContainerService.class);
    }

    @Override
    public DescriptiveUrlBag toUrl(final Path file) {
        final DescriptiveUrlBag list = new DescriptiveUrlBag();
        if(session.getClient().getConfiguration().getBoolProperty("s3service.disable-dns-buckets", false)) {
            list.addAll(new DefaultUrlProvider(session.getHost()).toUrl(file));
        }
        else {
            list.add(this.toUrl(file, session.getHost().getProtocol().getScheme(), session.getHost().getPort()));
            list.add(this.toUrl(file, Scheme.http, 80));
            list.addAll(new WebUrlProvider(session.getHost()).toUrl(file));
        }
        if(file.isFile()) {
            if(!session.getHost().getCredentials().isAnonymousLogin()) {
                // X-Amz-Expires must be less than a week (in seconds); that is, the given X-Amz-Expires must be less
                // than 604800 seconds
                // In one hour
                list.add(this.toSignedUrl(file, (int) TimeUnit.HOURS.toSeconds(1)));
                // Default signed URL expiring in 24 hours.
                list.add(this.toSignedUrl(file, (int) TimeUnit.SECONDS.toSeconds(PreferencesFactory.get().getInteger("s3.url.expire.seconds"))));
                // 1 Week
                list.add(this.toSignedUrl(file, (int) TimeUnit.DAYS.toSeconds(7)));
                switch(session.getSignatureVersion()) {
                    case AWS2:
                        // 1 Month
                        list.add(this.toSignedUrl(file, (int) TimeUnit.DAYS.toSeconds(30)));
                        // 1 Year
                        list.add(this.toSignedUrl(file, (int) TimeUnit.DAYS.toSeconds(365)));
                        break;
                    case AWS4HMACSHA256:
                        break;
                }
            }
        }
        list.add(new DescriptiveUrl(URI.create(String.format("s3://%s%s",
            containerService.getContainer(file).getName(),
            file.isRoot() ? Path.DELIMITER : containerService.isContainer(file) ? Path.DELIMITER : String.format("/%s", URIEncoder.encode(containerService.getKey(file))))),
            DescriptiveUrl.Type.provider,
            MessageFormat.format(LocaleFactory.localizedString("{0} URL"), "S3")));
        return list;
    }

    /**
     * Properly URI encode and prepend the bucket name.
     *
     * @param scheme Protocol
     * @return URL to be displayed in browser
     */
    protected DescriptiveUrl toUrl(final Path file, final Scheme scheme, final int port) {
        final StringBuilder url = new StringBuilder(scheme.name());
        url.append("://");
        if(file.isRoot()) {
            url.append(session.getHost().getHostname());
            if(port != scheme.getPort()) {
                url.append(":").append(port);
            }
        }
        else {
            final String hostname = this.getHostnameForContainer(containerService.getContainer(file));
            if(hostname.startsWith(containerService.getContainer(file).getName())) {
                url.append(hostname);
                if(port != scheme.getPort()) {
                    url.append(":").append(port);
                }
                if(!containerService.isContainer(file)) {
                    url.append(Path.DELIMITER);
                    url.append(URIEncoder.encode(containerService.getKey(file)));
                }
            }
            else {
                url.append(session.getHost().getHostname());
                if(port != scheme.getPort()) {
                    url.append(":").append(port);
                }
                url.append(URIEncoder.encode(file.getAbsolute()));
            }
        }
        return new DescriptiveUrl(URI.create(url.toString()), DescriptiveUrl.Type.http,
            MessageFormat.format(LocaleFactory.localizedString("{0} URL"), scheme.name().toUpperCase(Locale.ROOT)));
    }

    /**
     * Query string authentication. Query string authentication is useful for giving HTTP or browser access to resources
     * that would normally require authentication. The signature in the query string secures the request.
     *
     * @param seconds Expire in n seconds from now in default timezone
     * @return A signed URL with a limited validity over time.
     */
    protected DescriptiveUrl toSignedUrl(final Path file, final int seconds) {
        // Determine expiry time for URL
        final Calendar expiry = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        expiry.add(Calendar.SECOND, seconds);
        final String secret = store.findLoginPassword(session.getHost());
        if(StringUtils.isBlank(secret)) {
            log.warn("No secret found in password store required to sign temporary URL");
            return DescriptiveUrl.EMPTY;
        }
        String region = session.getHost().getRegion();
        if(session.isConnected()) {
            if(session.getClient().getRegionEndpointCache().containsRegionForBucketName(containerService.getContainer(file).getName())) {
                region = session.getClient().getRegionEndpointCache()
                    .getRegionForBucketName(containerService.getContainer(file).getName());
            }
        }
        return new DescriptiveUrl(URI.create(new S3PresignedUrlProvider(session).create(
            secret,
            containerService.getContainer(file).getName(), region, containerService.getKey(file),
            "GET", expiry.getTimeInMillis())), DescriptiveUrl.Type.signed,
            MessageFormat.format(LocaleFactory.localizedString("{0} URL"), LocaleFactory.localizedString("Pre-Signed", "S3"))
                + " (" + MessageFormat.format(LocaleFactory.localizedString("Expires {0}", "S3") + ")",
                UserDateFormatterFactory.get().getMediumFormat(expiry.getTimeInMillis()))
        );
    }

    private String getHostnameForContainer(final Path bucket) {
        if(!ServiceUtils.isBucketNameValidDNSName(containerService.getContainer(bucket).getName())) {
            return session.getHost().getHostname();
        }
        if(session.getHost().getHostname().equals(session.getHost().getProtocol().getDefaultHostname())) {
            return String.format("%s.%s", bucket.getName(), session.getHost().getHostname());
        }
        return session.getHost().getHostname();
    }
}

