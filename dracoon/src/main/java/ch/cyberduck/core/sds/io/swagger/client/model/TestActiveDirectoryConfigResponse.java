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
 * TestActiveDirectoryConfigResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-03T10:55:56.129+02:00")
public class TestActiveDirectoryConfigResponse {
  @JsonProperty("serverIp")
  private String serverIp = null;

  @JsonProperty("serverPort")
  private Integer serverPort = null;

  @JsonProperty("serverAdminName")
  private String serverAdminName = null;

  @JsonProperty("serverAdminPassword")
  private String serverAdminPassword = null;

  @JsonProperty("useLdaps")
  private Boolean useLdaps = null;

  @JsonProperty("sslFingerPrint")
  private String sslFingerPrint = null;

  public TestActiveDirectoryConfigResponse serverIp(String serverIp) {
    this.serverIp = serverIp;
    return this;
  }

   /**
   * IPv4 or IPv6 address or host name
   * @return serverIp
  **/
  @ApiModelProperty(required = true, value = "IPv4 or IPv6 address or host name")
  public String getServerIp() {
    return serverIp;
  }

  public void setServerIp(String serverIp) {
    this.serverIp = serverIp;
  }

  public TestActiveDirectoryConfigResponse serverPort(Integer serverPort) {
    this.serverPort = serverPort;
    return this;
  }

   /**
   * Port
   * @return serverPort
  **/
  @ApiModelProperty(required = true, value = "Port")
  public Integer getServerPort() {
    return serverPort;
  }

  public void setServerPort(Integer serverPort) {
    this.serverPort = serverPort;
  }

  public TestActiveDirectoryConfigResponse serverAdminName(String serverAdminName) {
    this.serverAdminName = serverAdminName;
    return this;
  }

   /**
   * DistinguishedName of Active Directory administrative account
   * @return serverAdminName
  **/
  @ApiModelProperty(required = true, value = "DistinguishedName of Active Directory administrative account")
  public String getServerAdminName() {
    return serverAdminName;
  }

  public void setServerAdminName(String serverAdminName) {
    this.serverAdminName = serverAdminName;
  }

  public TestActiveDirectoryConfigResponse serverAdminPassword(String serverAdminPassword) {
    this.serverAdminPassword = serverAdminPassword;
    return this;
  }

   /**
   * Password of Active Directory administrative account
   * @return serverAdminPassword
  **/
  @ApiModelProperty(required = true, value = "Password of Active Directory administrative account")
  public String getServerAdminPassword() {
    return serverAdminPassword;
  }

  public void setServerAdminPassword(String serverAdminPassword) {
    this.serverAdminPassword = serverAdminPassword;
  }

  public TestActiveDirectoryConfigResponse useLdaps(Boolean useLdaps) {
    this.useLdaps = useLdaps;
    return this;
  }

   /**
   * Determines whether LDAPS should be used instead of plain LDAP.
   * @return useLdaps
  **/
  @ApiModelProperty(required = true, value = "Determines whether LDAPS should be used instead of plain LDAP.")
  public Boolean getUseLdaps() {
    return useLdaps;
  }

  public void setUseLdaps(Boolean useLdaps) {
    this.useLdaps = useLdaps;
  }

  public TestActiveDirectoryConfigResponse sslFingerPrint(String sslFingerPrint) {
    this.sslFingerPrint = sslFingerPrint;
    return this;
  }

   /**
   * SSL finger print of Active Directory server. Format: Algorithm/FingerPrint
   * @return sslFingerPrint
  **/
  @ApiModelProperty(value = "SSL finger print of Active Directory server. Format: Algorithm/FingerPrint")
  public String getSslFingerPrint() {
    return sslFingerPrint;
  }

  public void setSslFingerPrint(String sslFingerPrint) {
    this.sslFingerPrint = sslFingerPrint;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TestActiveDirectoryConfigResponse testActiveDirectoryConfigResponse = (TestActiveDirectoryConfigResponse) o;
    return Objects.equals(this.serverIp, testActiveDirectoryConfigResponse.serverIp) &&
        Objects.equals(this.serverPort, testActiveDirectoryConfigResponse.serverPort) &&
        Objects.equals(this.serverAdminName, testActiveDirectoryConfigResponse.serverAdminName) &&
        Objects.equals(this.serverAdminPassword, testActiveDirectoryConfigResponse.serverAdminPassword) &&
        Objects.equals(this.useLdaps, testActiveDirectoryConfigResponse.useLdaps) &&
        Objects.equals(this.sslFingerPrint, testActiveDirectoryConfigResponse.sslFingerPrint);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serverIp, serverPort, serverAdminName, serverAdminPassword, useLdaps, sslFingerPrint);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TestActiveDirectoryConfigResponse {\n");
    
    sb.append("    serverIp: ").append(toIndentedString(serverIp)).append("\n");
    sb.append("    serverPort: ").append(toIndentedString(serverPort)).append("\n");
    sb.append("    serverAdminName: ").append(toIndentedString(serverAdminName)).append("\n");
    sb.append("    serverAdminPassword: ").append(toIndentedString(serverAdminPassword)).append("\n");
    sb.append("    useLdaps: ").append(toIndentedString(useLdaps)).append("\n");
    sb.append("    sslFingerPrint: ").append(toIndentedString(sslFingerPrint)).append("\n");
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

