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
 * UpdateActiveDirectoryConfigRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-03T10:55:56.129+02:00")
public class UpdateActiveDirectoryConfigRequest {
  @JsonProperty("alias")
  private String alias = null;

  @JsonProperty("serverIp")
  private String serverIp = null;

  @JsonProperty("serverPort")
  private Integer serverPort = null;

  @JsonProperty("serverAdminName")
  private String serverAdminName = null;

  @JsonProperty("serverAdminPassword")
  private String serverAdminPassword = null;

  @JsonProperty("ldapUsersDomain")
  private String ldapUsersDomain = null;

  @JsonProperty("userFilter")
  private String userFilter = null;

  @JsonProperty("userImport")
  private Boolean userImport = null;

  @JsonProperty("adExportGroup")
  private String adExportGroup = null;

  @JsonProperty("sdsImportGroup")
  private Long sdsImportGroup = null;

  @JsonProperty("createHomeFolder")
  private Boolean createHomeFolder = null;

  @JsonProperty("homeFolderParent")
  private Long homeFolderParent = null;

  @JsonProperty("useLdaps")
  private Boolean useLdaps = null;

  @JsonProperty("sslFingerPrint")
  private String sslFingerPrint = null;

  public UpdateActiveDirectoryConfigRequest alias(String alias) {
    this.alias = alias;
    return this;
  }

   /**
   * Alias string
   * @return alias
  **/
  @ApiModelProperty(value = "Alias string")
  public String getAlias() {
    return alias;
  }

  public void setAlias(String alias) {
    this.alias = alias;
  }

  public UpdateActiveDirectoryConfigRequest serverIp(String serverIp) {
    this.serverIp = serverIp;
    return this;
  }

   /**
   * IPv4 or IPv6 address or host name
   * @return serverIp
  **/
  @ApiModelProperty(value = "IPv4 or IPv6 address or host name")
  public String getServerIp() {
    return serverIp;
  }

  public void setServerIp(String serverIp) {
    this.serverIp = serverIp;
  }

  public UpdateActiveDirectoryConfigRequest serverPort(Integer serverPort) {
    this.serverPort = serverPort;
    return this;
  }

   /**
   * Port
   * @return serverPort
  **/
  @ApiModelProperty(value = "Port")
  public Integer getServerPort() {
    return serverPort;
  }

  public void setServerPort(Integer serverPort) {
    this.serverPort = serverPort;
  }

  public UpdateActiveDirectoryConfigRequest serverAdminName(String serverAdminName) {
    this.serverAdminName = serverAdminName;
    return this;
  }

   /**
   * DistinguishedName of Active Directory administrative account
   * @return serverAdminName
  **/
  @ApiModelProperty(value = "DistinguishedName of Active Directory administrative account")
  public String getServerAdminName() {
    return serverAdminName;
  }

  public void setServerAdminName(String serverAdminName) {
    this.serverAdminName = serverAdminName;
  }

  public UpdateActiveDirectoryConfigRequest serverAdminPassword(String serverAdminPassword) {
    this.serverAdminPassword = serverAdminPassword;
    return this;
  }

   /**
   * Password of Active Directory administrative account
   * @return serverAdminPassword
  **/
  @ApiModelProperty(value = "Password of Active Directory administrative account")
  public String getServerAdminPassword() {
    return serverAdminPassword;
  }

  public void setServerAdminPassword(String serverAdminPassword) {
    this.serverAdminPassword = serverAdminPassword;
  }

  public UpdateActiveDirectoryConfigRequest ldapUsersDomain(String ldapUsersDomain) {
    this.ldapUsersDomain = ldapUsersDomain;
    return this;
  }

   /**
   * Search scope of Active Directory; only users below this node can log on.
   * @return ldapUsersDomain
  **/
  @ApiModelProperty(value = "Search scope of Active Directory; only users below this node can log on.")
  public String getLdapUsersDomain() {
    return ldapUsersDomain;
  }

  public void setLdapUsersDomain(String ldapUsersDomain) {
    this.ldapUsersDomain = ldapUsersDomain;
  }

  public UpdateActiveDirectoryConfigRequest userFilter(String userFilter) {
    this.userFilter = userFilter;
    return this;
  }

   /**
   * Name of Active Directory attribute that is used as login name
   * @return userFilter
  **/
  @ApiModelProperty(value = "Name of Active Directory attribute that is used as login name")
  public String getUserFilter() {
    return userFilter;
  }

  public void setUserFilter(String userFilter) {
    this.userFilter = userFilter;
  }

  public UpdateActiveDirectoryConfigRequest userImport(Boolean userImport) {
    this.userImport = userImport;
    return this;
  }

   /**
   * Determines if an SDS account is automatically created for a new user who successfully logs on with his/her AD account,
   * @return userImport
  **/
  @ApiModelProperty(value = "Determines if an SDS account is automatically created for a new user who successfully logs on with his/her AD account,")
  public Boolean getUserImport() {
    return userImport;
  }

  public void setUserImport(Boolean userImport) {
    this.userImport = userImport;
  }

  public UpdateActiveDirectoryConfigRequest adExportGroup(String adExportGroup) {
    this.adExportGroup = adExportGroup;
    return this;
  }

   /**
   * If ad_userimport is set to true, a user must be member of this Active Directory group to receive a newly created SDS account.
   * @return adExportGroup
  **/
  @ApiModelProperty(value = "If ad_userimport is set to true, a user must be member of this Active Directory group to receive a newly created SDS account.")
  public String getAdExportGroup() {
    return adExportGroup;
  }

  public void setAdExportGroup(String adExportGroup) {
    this.adExportGroup = adExportGroup;
  }

  public UpdateActiveDirectoryConfigRequest sdsImportGroup(Long sdsImportGroup) {
    this.sdsImportGroup = sdsImportGroup;
    return this;
  }

   /**
   * User group that is assigned to users who are created by automatic import.
   * @return sdsImportGroup
  **/
  @ApiModelProperty(value = "User group that is assigned to users who are created by automatic import.")
  public Long getSdsImportGroup() {
    return sdsImportGroup;
  }

  public void setSdsImportGroup(Long sdsImportGroup) {
    this.sdsImportGroup = sdsImportGroup;
  }

  public UpdateActiveDirectoryConfigRequest createHomeFolder(Boolean createHomeFolder) {
    this.createHomeFolder = createHomeFolder;
    return this;
  }

   /**
   * Determines whether a room is created for each user that is created by automatic import (Like a home folder). The room&#39;s name will equal the user&#39;s login name.
   * @return createHomeFolder
  **/
  @ApiModelProperty(value = "Determines whether a room is created for each user that is created by automatic import (Like a home folder). The room's name will equal the user's login name.")
  public Boolean getCreateHomeFolder() {
    return createHomeFolder;
  }

  public void setCreateHomeFolder(Boolean createHomeFolder) {
    this.createHomeFolder = createHomeFolder;
  }

  public UpdateActiveDirectoryConfigRequest homeFolderParent(Long homeFolderParent) {
    this.homeFolderParent = homeFolderParent;
    return this;
  }

   /**
   * ID of the Data Room in which the individual rooms for users will be created (cf. &#39;ad_create_home_folder_on&#39;).
   * @return homeFolderParent
  **/
  @ApiModelProperty(value = "ID of the Data Room in which the individual rooms for users will be created (cf. 'ad_create_home_folder_on').")
  public Long getHomeFolderParent() {
    return homeFolderParent;
  }

  public void setHomeFolderParent(Long homeFolderParent) {
    this.homeFolderParent = homeFolderParent;
  }

  public UpdateActiveDirectoryConfigRequest useLdaps(Boolean useLdaps) {
    this.useLdaps = useLdaps;
    return this;
  }

   /**
   * Determines whether LDAPS should be used instead of plain LDAP.
   * @return useLdaps
  **/
  @ApiModelProperty(value = "Determines whether LDAPS should be used instead of plain LDAP.")
  public Boolean getUseLdaps() {
    return useLdaps;
  }

  public void setUseLdaps(Boolean useLdaps) {
    this.useLdaps = useLdaps;
  }

  public UpdateActiveDirectoryConfigRequest sslFingerPrint(String sslFingerPrint) {
    this.sslFingerPrint = sslFingerPrint;
    return this;
  }

   /**
   * SSL finger print of Active Directory server.  Mandatory for LDAPS connections. Format: &lt;Algorithm&gt;/&lt;FingerPrint&gt;
   * @return sslFingerPrint
  **/
  @ApiModelProperty(value = "SSL finger print of Active Directory server.  Mandatory for LDAPS connections. Format: <Algorithm>/<FingerPrint>")
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
    UpdateActiveDirectoryConfigRequest updateActiveDirectoryConfigRequest = (UpdateActiveDirectoryConfigRequest) o;
    return Objects.equals(this.alias, updateActiveDirectoryConfigRequest.alias) &&
        Objects.equals(this.serverIp, updateActiveDirectoryConfigRequest.serverIp) &&
        Objects.equals(this.serverPort, updateActiveDirectoryConfigRequest.serverPort) &&
        Objects.equals(this.serverAdminName, updateActiveDirectoryConfigRequest.serverAdminName) &&
        Objects.equals(this.serverAdminPassword, updateActiveDirectoryConfigRequest.serverAdminPassword) &&
        Objects.equals(this.ldapUsersDomain, updateActiveDirectoryConfigRequest.ldapUsersDomain) &&
        Objects.equals(this.userFilter, updateActiveDirectoryConfigRequest.userFilter) &&
        Objects.equals(this.userImport, updateActiveDirectoryConfigRequest.userImport) &&
        Objects.equals(this.adExportGroup, updateActiveDirectoryConfigRequest.adExportGroup) &&
        Objects.equals(this.sdsImportGroup, updateActiveDirectoryConfigRequest.sdsImportGroup) &&
        Objects.equals(this.createHomeFolder, updateActiveDirectoryConfigRequest.createHomeFolder) &&
        Objects.equals(this.homeFolderParent, updateActiveDirectoryConfigRequest.homeFolderParent) &&
        Objects.equals(this.useLdaps, updateActiveDirectoryConfigRequest.useLdaps) &&
        Objects.equals(this.sslFingerPrint, updateActiveDirectoryConfigRequest.sslFingerPrint);
  }

  @Override
  public int hashCode() {
    return Objects.hash(alias, serverIp, serverPort, serverAdminName, serverAdminPassword, ldapUsersDomain, userFilter, userImport, adExportGroup, sdsImportGroup, createHomeFolder, homeFolderParent, useLdaps, sslFingerPrint);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateActiveDirectoryConfigRequest {\n");
    
    sb.append("    alias: ").append(toIndentedString(alias)).append("\n");
    sb.append("    serverIp: ").append(toIndentedString(serverIp)).append("\n");
    sb.append("    serverPort: ").append(toIndentedString(serverPort)).append("\n");
    sb.append("    serverAdminName: ").append(toIndentedString(serverAdminName)).append("\n");
    sb.append("    serverAdminPassword: ").append(toIndentedString(serverAdminPassword)).append("\n");
    sb.append("    ldapUsersDomain: ").append(toIndentedString(ldapUsersDomain)).append("\n");
    sb.append("    userFilter: ").append(toIndentedString(userFilter)).append("\n");
    sb.append("    userImport: ").append(toIndentedString(userImport)).append("\n");
    sb.append("    adExportGroup: ").append(toIndentedString(adExportGroup)).append("\n");
    sb.append("    sdsImportGroup: ").append(toIndentedString(sdsImportGroup)).append("\n");
    sb.append("    createHomeFolder: ").append(toIndentedString(createHomeFolder)).append("\n");
    sb.append("    homeFolderParent: ").append(toIndentedString(homeFolderParent)).append("\n");
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

