/*
 * DRACOON
 * Version 4.4.0 - built at: 2017-12-04 04:14:43, API server: https://demo.dracoon.com/api/v4
 *
 * OpenAPI spec version: 4.4.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package ch.cyberduck.core.sds.io.swagger.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * DownloadTokenGenerateResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-03T10:55:56.129+02:00")
public class DownloadTokenGenerateResponse {
  @JsonProperty("token")
  private String token = null;

  @JsonProperty("downloadUrl")
  private String downloadUrl = null;

  public DownloadTokenGenerateResponse token(String token) {
    this.token = token;
    return this;
  }

   /**
   * Download token &lt;b style&#x3D;&#39;color: red;&#39;&gt; DEPRECATED&lt;/b&gt;
   * @return token
  **/
  @ApiModelProperty(required = true, value = "Download token <b style='color: red;'> DEPRECATED</b>")
  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public DownloadTokenGenerateResponse downloadUrl(String downloadUrl) {
    this.downloadUrl = downloadUrl;
    return this;
  }

   /**
   * Download URL
   * @return downloadUrl
  **/
  @ApiModelProperty(value = "Download URL")
  public String getDownloadUrl() {
    return downloadUrl;
  }

  public void setDownloadUrl(String downloadUrl) {
    this.downloadUrl = downloadUrl;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DownloadTokenGenerateResponse downloadTokenGenerateResponse = (DownloadTokenGenerateResponse) o;
    return Objects.equals(this.token, downloadTokenGenerateResponse.token) &&
        Objects.equals(this.downloadUrl, downloadTokenGenerateResponse.downloadUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(token, downloadUrl);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DownloadTokenGenerateResponse {\n");
    
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
    sb.append("    downloadUrl: ").append(toIndentedString(downloadUrl)).append("\n");
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

