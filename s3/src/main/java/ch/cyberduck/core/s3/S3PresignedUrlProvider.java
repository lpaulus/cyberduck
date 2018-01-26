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

import ch.cyberduck.core.Host;

import org.apache.commons.lang3.StringUtils;
import org.jets3t.service.impl.rest.httpclient.RestS3Service;
import org.jets3t.service.security.AWSCredentials;

public class S3PresignedUrlProvider {
    /**
     * Generates a signed URL string that will grant access to an S3 resource (bucket or object)
     * to whoever uses the URL up until the time specified.
     *
     * @param host   Hostname
     * @param bucket the name of the bucket to include in the URL, must be a valid bucket name.
     * @param key    the name of the object to include in the URL, if null only the bucket name is used.
     * @param expiry Milliseconds
     * @return a URL signed in such a way as to grant access to an S3 resource to whoever uses it.
     */
    public String create(final Host host, final String user, final String secret,
                         final String bucket, final String region, final String key,
                         final long expiry) {
        return new RestS3Service(new AWSCredentials(StringUtils.strip(user), StringUtils.strip(secret))) {
            @Override
            public String getEndpoint() {
                return host.getHostname();
            }
        }.createSignedUrlUsingSignatureVersion(
            S3Protocol.AuthenticationHeaderSignatureVersion.valueOf(host.getProtocol().getAuthorization()).toString(),
            region, "GET", bucket, key, null, null, expiry / 1000, false, true, false);
    }
}
