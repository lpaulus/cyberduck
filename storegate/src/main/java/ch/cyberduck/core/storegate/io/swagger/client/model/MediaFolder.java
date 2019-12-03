/*
 * Storegate.Web
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: v4
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package ch.cyberduck.core.storegate.io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import ch.cyberduck.core.storegate.io.swagger.client.model.MediaItem;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.joda.time.DateTime;

/**
 * A media folder (or album).
 */
@ApiModel(description = "A media folder (or album).")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-12-02T20:20:31.369+01:00")
public class MediaFolder {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("isShared")
  private Boolean isShared = null;

  @JsonProperty("created")
  private DateTime created = null;

  @JsonProperty("modified")
  private DateTime modified = null;

  @JsonProperty("mediaItem")
  private MediaItem mediaItem = null;

  public MediaFolder id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The folder id.
   * @return id
  **/
  @ApiModelProperty(value = "The folder id.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public MediaFolder name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The folder name.
   * @return name
  **/
  @ApiModelProperty(value = "The folder name.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public MediaFolder description(String description) {
    this.description = description;
    return this;
  }

   /**
   * The folder description.
   * @return description
  **/
  @ApiModelProperty(value = "The folder description.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public MediaFolder isShared(Boolean isShared) {
    this.isShared = isShared;
    return this;
  }

   /**
   * Indicates if the folder is shared.
   * @return isShared
  **/
  @ApiModelProperty(value = "Indicates if the folder is shared.")
  public Boolean isIsShared() {
    return isShared;
  }

  public void setIsShared(Boolean isShared) {
    this.isShared = isShared;
  }

  public MediaFolder created(DateTime created) {
    this.created = created;
    return this;
  }

   /**
   * When the media folder was created.
   * @return created
  **/
  @ApiModelProperty(value = "When the media folder was created.")
  public DateTime getCreated() {
    return created;
  }

  public void setCreated(DateTime created) {
    this.created = created;
  }

  public MediaFolder modified(DateTime modified) {
    this.modified = modified;
    return this;
  }

   /**
   * When the media folder last was modified.
   * @return modified
  **/
  @ApiModelProperty(value = "When the media folder last was modified.")
  public DateTime getModified() {
    return modified;
  }

  public void setModified(DateTime modified) {
    this.modified = modified;
  }

  public MediaFolder mediaItem(MediaItem mediaItem) {
    this.mediaItem = mediaItem;
    return this;
  }

   /**
   * One image to represent the album
   * @return mediaItem
  **/
  @ApiModelProperty(value = "One image to represent the album")
  public MediaItem getMediaItem() {
    return mediaItem;
  }

  public void setMediaItem(MediaItem mediaItem) {
    this.mediaItem = mediaItem;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MediaFolder mediaFolder = (MediaFolder) o;
    return Objects.equals(this.id, mediaFolder.id) &&
        Objects.equals(this.name, mediaFolder.name) &&
        Objects.equals(this.description, mediaFolder.description) &&
        Objects.equals(this.isShared, mediaFolder.isShared) &&
        Objects.equals(this.created, mediaFolder.created) &&
        Objects.equals(this.modified, mediaFolder.modified) &&
        Objects.equals(this.mediaItem, mediaFolder.mediaItem);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description, isShared, created, modified, mediaItem);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MediaFolder {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    isShared: ").append(toIndentedString(isShared)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    modified: ").append(toIndentedString(modified)).append("\n");
    sb.append("    mediaItem: ").append(toIndentedString(mediaItem)).append("\n");
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

