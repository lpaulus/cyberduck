package ch.cyberduck.core.brick.io.swagger.client.api;

import ch.cyberduck.core.brick.io.swagger.client.ApiException;
import ch.cyberduck.core.brick.io.swagger.client.ApiClient;
import ch.cyberduck.core.brick.io.swagger.client.ApiResponse;
import ch.cyberduck.core.brick.io.swagger.client.Configuration;
import ch.cyberduck.core.brick.io.swagger.client.Pair;

import javax.ws.rs.core.GenericType;

import ch.cyberduck.core.brick.io.swagger.client.model.BundleDownloadEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-06-30T21:29:25.490+02:00")
public class BundleDownloadsApi {
  private ApiClient apiClient;

  public BundleDownloadsApi() {
    this(Configuration.getDefaultApiClient());
  }

  public BundleDownloadsApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * List Bundle Downloads
   * List Bundle Downloads
   * @param cursor Used for pagination.  Send a cursor value to resume an existing list from the point at which you left off.  Get a cursor from an existing list via the X-Files-Cursor-Next header. (optional)
   * @param perPage Number of records to show per page.  (Max: 10,000, 1,000 or less is recommended). (optional)
   * @param sortBy If set, sort records by the specified field in either &#39;asc&#39; or &#39;desc&#39; direction (e.g. sort_by[last_login_at]&#x3D;desc). Valid fields are &#x60;created_at&#x60;. (optional)
   * @param filter If set, return records where the specifiied field is equal to the supplied value. Valid fields are &#x60;created_at&#x60;. (optional)
   * @param filterGt If set, return records where the specifiied field is greater than the supplied value. Valid fields are &#x60;created_at&#x60;. (optional)
   * @param filterGteq If set, return records where the specifiied field is greater than or equal to the supplied value. Valid fields are &#x60;created_at&#x60;. (optional)
   * @param filterLike If set, return records where the specifiied field is equal to the supplied value. Valid fields are &#x60;created_at&#x60;. (optional)
   * @param filterLt If set, return records where the specifiied field is less than the supplied value. Valid fields are &#x60;created_at&#x60;. (optional)
   * @param filterLteq If set, return records where the specifiied field is less than or equal to the supplied value. Valid fields are &#x60;created_at&#x60;. (optional)
   * @param bundleId Bundle ID (optional)
   * @param bundleRegistrationId BundleRegistration ID (optional)
   * @return List&lt;BundleDownloadEntity&gt;
   * @throws ApiException if fails to make API call
   */
  public List<BundleDownloadEntity> getBundleDownloads(String cursor, Integer perPage, Map<String, String> sortBy, Map<String, String> filter, Map<String, String> filterGt, Map<String, String> filterGteq, Map<String, String> filterLike, Map<String, String> filterLt, Map<String, String> filterLteq, Integer bundleId, Integer bundleRegistrationId) throws ApiException {
    return getBundleDownloadsWithHttpInfo(cursor, perPage, sortBy, filter, filterGt, filterGteq, filterLike, filterLt, filterLteq, bundleId, bundleRegistrationId).getData();
      }

  /**
   * List Bundle Downloads
   * List Bundle Downloads
   * @param cursor Used for pagination.  Send a cursor value to resume an existing list from the point at which you left off.  Get a cursor from an existing list via the X-Files-Cursor-Next header. (optional)
   * @param perPage Number of records to show per page.  (Max: 10,000, 1,000 or less is recommended). (optional)
   * @param sortBy If set, sort records by the specified field in either &#39;asc&#39; or &#39;desc&#39; direction (e.g. sort_by[last_login_at]&#x3D;desc). Valid fields are &#x60;created_at&#x60;. (optional)
   * @param filter If set, return records where the specifiied field is equal to the supplied value. Valid fields are &#x60;created_at&#x60;. (optional)
   * @param filterGt If set, return records where the specifiied field is greater than the supplied value. Valid fields are &#x60;created_at&#x60;. (optional)
   * @param filterGteq If set, return records where the specifiied field is greater than or equal to the supplied value. Valid fields are &#x60;created_at&#x60;. (optional)
   * @param filterLike If set, return records where the specifiied field is equal to the supplied value. Valid fields are &#x60;created_at&#x60;. (optional)
   * @param filterLt If set, return records where the specifiied field is less than the supplied value. Valid fields are &#x60;created_at&#x60;. (optional)
   * @param filterLteq If set, return records where the specifiied field is less than or equal to the supplied value. Valid fields are &#x60;created_at&#x60;. (optional)
   * @param bundleId Bundle ID (optional)
   * @param bundleRegistrationId BundleRegistration ID (optional)
   * @return ApiResponse&lt;List&lt;BundleDownloadEntity&gt;&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<List<BundleDownloadEntity>> getBundleDownloadsWithHttpInfo(String cursor, Integer perPage, Map<String, String> sortBy, Map<String, String> filter, Map<String, String> filterGt, Map<String, String> filterGteq, Map<String, String> filterLike, Map<String, String> filterLt, Map<String, String> filterLteq, Integer bundleId, Integer bundleRegistrationId) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/bundle_downloads";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "cursor", cursor));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "per_page", perPage));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sort_by", sortBy));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "filter", filter));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "filter_gt", filterGt));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "filter_gteq", filterGteq));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "filter_like", filterLike));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "filter_lt", filterLt));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "filter_lteq", filterLteq));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "bundle_id", bundleId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "bundle_registration_id", bundleRegistrationId));

    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<List<BundleDownloadEntity>> localVarReturnType = new GenericType<List<BundleDownloadEntity>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
