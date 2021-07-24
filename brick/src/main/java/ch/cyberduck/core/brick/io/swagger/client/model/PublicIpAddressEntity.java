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
/**
 * List all possible public IP addresses
 */
@Schema(description = "List all possible public IP addresses")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-07-23T20:47:00.742522+02:00[Europe/Paris]")
public class PublicIpAddressEntity {
  @JsonProperty("ip_address")
  private String ipAddress = null;

  @JsonProperty("server_name")
  private String serverName = null;

  public PublicIpAddressEntity ipAddress(String ipAddress) {
    this.ipAddress = ipAddress;
    return this;
  }

   /**
   * The public IP address.
   * @return ipAddress
  **/
  @Schema(example = "1.1.1.1", description = "The public IP address.")
  public String getIpAddress() {
    return ipAddress;
  }

  public void setIpAddress(String ipAddress) {
    this.ipAddress = ipAddress;
  }

  public PublicIpAddressEntity serverName(String serverName) {
    this.serverName = serverName;
    return this;
  }

   /**
   * The name of the frontend server.
   * @return serverName
  **/
  @Schema(example = "server-1", description = "The name of the frontend server.")
  public String getServerName() {
    return serverName;
  }

  public void setServerName(String serverName) {
    this.serverName = serverName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PublicIpAddressEntity publicIpAddressEntity = (PublicIpAddressEntity) o;
    return Objects.equals(this.ipAddress, publicIpAddressEntity.ipAddress) &&
        Objects.equals(this.serverName, publicIpAddressEntity.serverName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ipAddress, serverName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PublicIpAddressEntity {\n");
    
    sb.append("    ipAddress: ").append(toIndentedString(ipAddress)).append("\n");
    sb.append("    serverName: ").append(toIndentedString(serverName)).append("\n");
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
