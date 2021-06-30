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
import org.joda.time.DateTime;
import ch.cyberduck.core.brick.io.swagger.client.model.HistoryExportEntity;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for HistoryExportsApi
 */
@Ignore
public class HistoryExportsApiTest {

    private final HistoryExportsApi api = new HistoryExportsApi();

    
    /**
     * Show History Export
     *
     * Show History Export
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getHistoryExportsIdTest() throws ApiException {
        Integer id = null;
        HistoryExportEntity response = api.getHistoryExportsId(id);

        // TODO: test validations
    }
    
    /**
     * Create History Export
     *
     * Create History Export
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void postHistoryExportsTest() throws ApiException {
        Integer userId = null;
        DateTime startAt = null;
        DateTime endAt = null;
        String queryAction = null;
        String queryInterface = null;
        String queryUserId = null;
        String queryFileId = null;
        String queryParentId = null;
        String queryPath = null;
        String queryFolder = null;
        String querySrc = null;
        String queryDestination = null;
        String queryIp = null;
        String queryUsername = null;
        String queryFailureType = null;
        String queryTargetId = null;
        String queryTargetName = null;
        String queryTargetPermission = null;
        String queryTargetUserId = null;
        String queryTargetUsername = null;
        String queryTargetPlatform = null;
        String queryTargetPermissionSet = null;
        HistoryExportEntity response = api.postHistoryExports(userId, startAt, endAt, queryAction, queryInterface, queryUserId, queryFileId, queryParentId, queryPath, queryFolder, querySrc, queryDestination, queryIp, queryUsername, queryFailureType, queryTargetId, queryTargetName, queryTargetPermission, queryTargetUserId, queryTargetUsername, queryTargetPlatform, queryTargetPermissionSet);

        // TODO: test validations
    }
    
}
