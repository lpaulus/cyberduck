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
 * ClickwrapsBody
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-07-23T20:47:00.742522+02:00[Europe/Paris]")
public class ClickwrapsBody {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("body")
  private String body = null;

  /**
   * Use this Clickwrap for Bundles?
   */
  public enum UseWithBundlesEnum {
    NONE("none"),
    AVAILABLE("available"),
    REQUIRE("require");

    private String value;

    UseWithBundlesEnum(String value) {
      this.value = value;
    }
    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    @JsonCreator
    public static UseWithBundlesEnum fromValue(String text) {
      for (UseWithBundlesEnum b : UseWithBundlesEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("use_with_bundles")
  private UseWithBundlesEnum useWithBundles = null;

  /**
   * Use this Clickwrap for Inboxes?
   */
  public enum UseWithInboxesEnum {
    NONE("none"),
    AVAILABLE("available"),
    REQUIRE("require");

    private String value;

    UseWithInboxesEnum(String value) {
      this.value = value;
    }
    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    @JsonCreator
    public static UseWithInboxesEnum fromValue(String text) {
      for (UseWithInboxesEnum b : UseWithInboxesEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("use_with_inboxes")
  private UseWithInboxesEnum useWithInboxes = null;

  /**
   * Use this Clickwrap for User Registrations?  Note: This only applies to User Registrations where the User is invited to your Files.com site using an E-Mail invitation process where they then set their own password.
   */
  public enum UseWithUsersEnum {
    NONE("none"),
    REQUIRE("require");

    private String value;

    UseWithUsersEnum(String value) {
      this.value = value;
    }
    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    @JsonCreator
    public static UseWithUsersEnum fromValue(String text) {
      for (UseWithUsersEnum b : UseWithUsersEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("use_with_users")
  private UseWithUsersEnum useWithUsers = null;

  public ClickwrapsBody name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Name of the Clickwrap agreement (used when selecting from multiple Clickwrap agreements.)
   * @return name
  **/
  @Schema(example = "Example Site NDA for Files.com Use", description = "Name of the Clickwrap agreement (used when selecting from multiple Clickwrap agreements.)")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ClickwrapsBody body(String body) {
    this.body = body;
    return this;
  }

   /**
   * Body text of Clickwrap (supports Markdown formatting).
   * @return body
  **/
  @Schema(example = "[Legal body text]", description = "Body text of Clickwrap (supports Markdown formatting).")
  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public ClickwrapsBody useWithBundles(UseWithBundlesEnum useWithBundles) {
    this.useWithBundles = useWithBundles;
    return this;
  }

   /**
   * Use this Clickwrap for Bundles?
   * @return useWithBundles
  **/
  @Schema(description = "Use this Clickwrap for Bundles?")
  public UseWithBundlesEnum getUseWithBundles() {
    return useWithBundles;
  }

  public void setUseWithBundles(UseWithBundlesEnum useWithBundles) {
    this.useWithBundles = useWithBundles;
  }

  public ClickwrapsBody useWithInboxes(UseWithInboxesEnum useWithInboxes) {
    this.useWithInboxes = useWithInboxes;
    return this;
  }

   /**
   * Use this Clickwrap for Inboxes?
   * @return useWithInboxes
  **/
  @Schema(description = "Use this Clickwrap for Inboxes?")
  public UseWithInboxesEnum getUseWithInboxes() {
    return useWithInboxes;
  }

  public void setUseWithInboxes(UseWithInboxesEnum useWithInboxes) {
    this.useWithInboxes = useWithInboxes;
  }

  public ClickwrapsBody useWithUsers(UseWithUsersEnum useWithUsers) {
    this.useWithUsers = useWithUsers;
    return this;
  }

   /**
   * Use this Clickwrap for User Registrations?  Note: This only applies to User Registrations where the User is invited to your Files.com site using an E-Mail invitation process where they then set their own password.
   * @return useWithUsers
  **/
  @Schema(description = "Use this Clickwrap for User Registrations?  Note: This only applies to User Registrations where the User is invited to your Files.com site using an E-Mail invitation process where they then set their own password.")
  public UseWithUsersEnum getUseWithUsers() {
    return useWithUsers;
  }

  public void setUseWithUsers(UseWithUsersEnum useWithUsers) {
    this.useWithUsers = useWithUsers;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ClickwrapsBody clickwrapsBody = (ClickwrapsBody) o;
    return Objects.equals(this.name, clickwrapsBody.name) &&
        Objects.equals(this.body, clickwrapsBody.body) &&
        Objects.equals(this.useWithBundles, clickwrapsBody.useWithBundles) &&
        Objects.equals(this.useWithInboxes, clickwrapsBody.useWithInboxes) &&
        Objects.equals(this.useWithUsers, clickwrapsBody.useWithUsers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, body, useWithBundles, useWithInboxes, useWithUsers);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ClickwrapsBody {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
    sb.append("    useWithBundles: ").append(toIndentedString(useWithBundles)).append("\n");
    sb.append("    useWithInboxes: ").append(toIndentedString(useWithInboxes)).append("\n");
    sb.append("    useWithUsers: ").append(toIndentedString(useWithUsers)).append("\n");
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
