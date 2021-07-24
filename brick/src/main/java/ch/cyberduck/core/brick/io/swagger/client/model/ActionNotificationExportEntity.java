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

package ch.cyberduck.core.brick.io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import org.joda.time.DateTime;
/**
 * Show Action Notification Export
 */
@Schema(description = "Show Action Notification Export")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-07-23T20:47:00.742522+02:00[Europe/Paris]")
public class ActionNotificationExportEntity {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("export_version")
  private String exportVersion = null;

  @JsonProperty("start_at")
  private DateTime startAt = null;

  @JsonProperty("end_at")
  private DateTime endAt = null;

  @JsonProperty("status")
  private String status = null;

  @JsonProperty("query_path")
  private String queryPath = null;

  @JsonProperty("query_folder")
  private String queryFolder = null;

  @JsonProperty("query_message")
  private String queryMessage = null;

  @JsonProperty("query_request_method")
  private String queryRequestMethod = null;

  @JsonProperty("query_request_url")
  private String queryRequestUrl = null;

  @JsonProperty("query_status")
  private String queryStatus = null;

  @JsonProperty("query_success")
  private Boolean querySuccess = null;

  @JsonProperty("results_url")
  private String resultsUrl = null;

  public ActionNotificationExportEntity id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * History Export ID
   * @return id
  **/
  @Schema(example = "1", description = "History Export ID")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public ActionNotificationExportEntity exportVersion(String exportVersion) {
    this.exportVersion = exportVersion;
    return this;
  }

   /**
   * Version of the underlying records for the export.
   * @return exportVersion
  **/
  @Schema(example = "20201213.2", description = "Version of the underlying records for the export.")
  public String getExportVersion() {
    return exportVersion;
  }

  public void setExportVersion(String exportVersion) {
    this.exportVersion = exportVersion;
  }

  public ActionNotificationExportEntity startAt(DateTime startAt) {
    this.startAt = startAt;
    return this;
  }

   /**
   * Start date/time of export range.
   * @return startAt
  **/
  @Schema(description = "Start date/time of export range.")
  public DateTime getStartAt() {
    return startAt;
  }

  public void setStartAt(DateTime startAt) {
    this.startAt = startAt;
  }

  public ActionNotificationExportEntity endAt(DateTime endAt) {
    this.endAt = endAt;
    return this;
  }

   /**
   * End date/time of export range.
   * @return endAt
  **/
  @Schema(description = "End date/time of export range.")
  public DateTime getEndAt() {
    return endAt;
  }

  public void setEndAt(DateTime endAt) {
    this.endAt = endAt;
  }

  public ActionNotificationExportEntity status(String status) {
    this.status = status;
    return this;
  }

   /**
   * Status of export.  Valid values: &#x60;building&#x60;, &#x60;ready&#x60;, or &#x60;failed&#x60;
   * @return status
  **/
  @Schema(example = "ready", description = "Status of export.  Valid values: `building`, `ready`, or `failed`")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public ActionNotificationExportEntity queryPath(String queryPath) {
    this.queryPath = queryPath;
    return this;
  }

   /**
   * Return notifications that were triggered by actions on this specific path.
   * @return queryPath
  **/
  @Schema(example = "MyFile.txt", description = "Return notifications that were triggered by actions on this specific path.")
  public String getQueryPath() {
    return queryPath;
  }

  public void setQueryPath(String queryPath) {
    this.queryPath = queryPath;
  }

  public ActionNotificationExportEntity queryFolder(String queryFolder) {
    this.queryFolder = queryFolder;
    return this;
  }

   /**
   * Return notifications that were triggered by actions in this folder.
   * @return queryFolder
  **/
  @Schema(example = "MyFolder", description = "Return notifications that were triggered by actions in this folder.")
  public String getQueryFolder() {
    return queryFolder;
  }

  public void setQueryFolder(String queryFolder) {
    this.queryFolder = queryFolder;
  }

  public ActionNotificationExportEntity queryMessage(String queryMessage) {
    this.queryMessage = queryMessage;
    return this;
  }

   /**
   * Error message associated with the request, if any.
   * @return queryMessage
  **/
  @Schema(example = "Connection Refused", description = "Error message associated with the request, if any.")
  public String getQueryMessage() {
    return queryMessage;
  }

  public void setQueryMessage(String queryMessage) {
    this.queryMessage = queryMessage;
  }

  public ActionNotificationExportEntity queryRequestMethod(String queryRequestMethod) {
    this.queryRequestMethod = queryRequestMethod;
    return this;
  }

   /**
   * The HTTP request method used by the webhook.
   * @return queryRequestMethod
  **/
  @Schema(example = "GET", description = "The HTTP request method used by the webhook.")
  public String getQueryRequestMethod() {
    return queryRequestMethod;
  }

  public void setQueryRequestMethod(String queryRequestMethod) {
    this.queryRequestMethod = queryRequestMethod;
  }

  public ActionNotificationExportEntity queryRequestUrl(String queryRequestUrl) {
    this.queryRequestUrl = queryRequestUrl;
    return this;
  }

   /**
   * The target webhook URL.
   * @return queryRequestUrl
  **/
  @Schema(example = "http://example.com/webhook", description = "The target webhook URL.")
  public String getQueryRequestUrl() {
    return queryRequestUrl;
  }

  public void setQueryRequestUrl(String queryRequestUrl) {
    this.queryRequestUrl = queryRequestUrl;
  }

  public ActionNotificationExportEntity queryStatus(String queryStatus) {
    this.queryStatus = queryStatus;
    return this;
  }

   /**
   * The HTTP status returned from the server in response to the webhook request.
   * @return queryStatus
  **/
  @Schema(example = "200", description = "The HTTP status returned from the server in response to the webhook request.")
  public String getQueryStatus() {
    return queryStatus;
  }

  public void setQueryStatus(String queryStatus) {
    this.queryStatus = queryStatus;
  }

  public ActionNotificationExportEntity querySuccess(Boolean querySuccess) {
    this.querySuccess = querySuccess;
    return this;
  }

   /**
   * true if the webhook request succeeded (i.e. returned a 200 or 204 response status). false otherwise.
   * @return querySuccess
  **/
  @Schema(example = "true", description = "true if the webhook request succeeded (i.e. returned a 200 or 204 response status). false otherwise.")
  public Boolean isQuerySuccess() {
    return querySuccess;
  }

  public void setQuerySuccess(Boolean querySuccess) {
    this.querySuccess = querySuccess;
  }

  public ActionNotificationExportEntity resultsUrl(String resultsUrl) {
    this.resultsUrl = resultsUrl;
    return this;
  }

   /**
   * If &#x60;status&#x60; is &#x60;ready&#x60;, this will be a URL where all the results can be downloaded at once as a CSV.
   * @return resultsUrl
  **/
  @Schema(example = "https://files.com/action_notification_results.csv", description = "If `status` is `ready`, this will be a URL where all the results can be downloaded at once as a CSV.")
  public String getResultsUrl() {
    return resultsUrl;
  }

  public void setResultsUrl(String resultsUrl) {
    this.resultsUrl = resultsUrl;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ActionNotificationExportEntity actionNotificationExportEntity = (ActionNotificationExportEntity) o;
    return Objects.equals(this.id, actionNotificationExportEntity.id) &&
        Objects.equals(this.exportVersion, actionNotificationExportEntity.exportVersion) &&
        Objects.equals(this.startAt, actionNotificationExportEntity.startAt) &&
        Objects.equals(this.endAt, actionNotificationExportEntity.endAt) &&
        Objects.equals(this.status, actionNotificationExportEntity.status) &&
        Objects.equals(this.queryPath, actionNotificationExportEntity.queryPath) &&
        Objects.equals(this.queryFolder, actionNotificationExportEntity.queryFolder) &&
        Objects.equals(this.queryMessage, actionNotificationExportEntity.queryMessage) &&
        Objects.equals(this.queryRequestMethod, actionNotificationExportEntity.queryRequestMethod) &&
        Objects.equals(this.queryRequestUrl, actionNotificationExportEntity.queryRequestUrl) &&
        Objects.equals(this.queryStatus, actionNotificationExportEntity.queryStatus) &&
        Objects.equals(this.querySuccess, actionNotificationExportEntity.querySuccess) &&
        Objects.equals(this.resultsUrl, actionNotificationExportEntity.resultsUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, exportVersion, startAt, endAt, status, queryPath, queryFolder, queryMessage, queryRequestMethod, queryRequestUrl, queryStatus, querySuccess, resultsUrl);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ActionNotificationExportEntity {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    exportVersion: ").append(toIndentedString(exportVersion)).append("\n");
    sb.append("    startAt: ").append(toIndentedString(startAt)).append("\n");
    sb.append("    endAt: ").append(toIndentedString(endAt)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    queryPath: ").append(toIndentedString(queryPath)).append("\n");
    sb.append("    queryFolder: ").append(toIndentedString(queryFolder)).append("\n");
    sb.append("    queryMessage: ").append(toIndentedString(queryMessage)).append("\n");
    sb.append("    queryRequestMethod: ").append(toIndentedString(queryRequestMethod)).append("\n");
    sb.append("    queryRequestUrl: ").append(toIndentedString(queryRequestUrl)).append("\n");
    sb.append("    queryStatus: ").append(toIndentedString(queryStatus)).append("\n");
    sb.append("    querySuccess: ").append(toIndentedString(querySuccess)).append("\n");
    sb.append("    resultsUrl: ").append(toIndentedString(resultsUrl)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
