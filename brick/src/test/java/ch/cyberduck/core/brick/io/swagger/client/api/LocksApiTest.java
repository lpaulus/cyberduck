/*
 * Files.com API
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 0.0.1
 * Contact: support@files.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package ch.cyberduck.core.brick.io.swagger.client.api;

import ch.cyberduck.core.brick.io.swagger.client.ApiException;
import ch.cyberduck.core.brick.io.swagger.client.model.LockEntity;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for LocksApi
 */
@Ignore
public class LocksApiTest {

    private final LocksApi api = new LocksApi();

    
    /**
     * Delete Lock
     *
     * Delete Lock
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteLocksPathTest() throws ApiException {
        String path = null;
        String token = null;
        api.deleteLocksPath(path, token);

        // TODO: test validations
    }
    
    /**
     * List Locks by path
     *
     * List Locks by path
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void listForPathTest() throws ApiException {
        String path = null;
        String cursor = null;
        Integer perPage = null;
        Boolean includeChildren = null;
        List<LockEntity> response = api.listForPath(path, cursor, perPage, includeChildren);

        // TODO: test validations
    }
    
    /**
     * Create Lock
     *
     * Create Lock
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void postLocksPathTest() throws ApiException {
        String path = null;
        Integer timeout = null;
        LockEntity response = api.postLocksPath(path, timeout);

        // TODO: test validations
    }
    
}
