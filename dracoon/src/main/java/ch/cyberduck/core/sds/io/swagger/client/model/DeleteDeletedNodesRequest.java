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
import java.util.ArrayList;
import java.util.List;

/**
 * DeleteDeletedNodesRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-03T10:55:56.129+02:00")
public class DeleteDeletedNodesRequest {
  @JsonProperty("deletedNodeIds")
  private List<Long> deletedNodeIds = new ArrayList<Long>();

  public DeleteDeletedNodesRequest deletedNodeIds(List<Long> deletedNodeIds) {
    this.deletedNodeIds = deletedNodeIds;
    return this;
  }

  public DeleteDeletedNodesRequest addDeletedNodeIdsItem(Long deletedNodeIdsItem) {
    this.deletedNodeIds.add(deletedNodeIdsItem);
    return this;
  }

   /**
   * Get deletedNodeIds
   * @return deletedNodeIds
  **/
  @ApiModelProperty(required = true, value = "")
  public List<Long> getDeletedNodeIds() {
    return deletedNodeIds;
  }

  public void setDeletedNodeIds(List<Long> deletedNodeIds) {
    this.deletedNodeIds = deletedNodeIds;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeleteDeletedNodesRequest deleteDeletedNodesRequest = (DeleteDeletedNodesRequest) o;
    return Objects.equals(this.deletedNodeIds, deleteDeletedNodesRequest.deletedNodeIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(deletedNodeIds);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeleteDeletedNodesRequest {\n");
    
    sb.append("    deletedNodeIds: ").append(toIndentedString(deletedNodeIds)).append("\n");
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

