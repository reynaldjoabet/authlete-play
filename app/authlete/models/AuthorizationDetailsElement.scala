/**
  * Authlete API Authlete API Document.
  *
  * The version of the OpenAPI document: 2.3.12 Contact: team@openapitools.org
  *
  * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
  * https://openapi-generator.tech Do not edit the class manually.
  */
package authlete
package models

import scala.collection.immutable.Seq

import com.github.plokhotnyuk.jsoniter_scala.core.JsonValueCodec
import com.github.plokhotnyuk.jsoniter_scala.macros.ConfiguredJsonValueCodec
import com.github.plokhotnyuk.jsoniter_scala.macros.JsonCodecMaker
import io.circe.{Decoder, Encoder, Json}
import io.circe.syntax.*

/**
  * @param `type`
  *   The type of this element. From _\"OAuth 2.0 Rich Authorization Requests\"_: _\"The type of
  *   authorization data as a string. This field MAY define which other elements are allowed in the
  *   request. This element is REQUIRED.\"_ This property is always NOT `null`.
  * @param locations
  *   The resources and/or resource servers. This property may be `null`. From _\"OAuth 2.0 Rich
  *   Authorization Requests\"_: _\"An array of strings representing the location of the resource or
  *   resource server. This is typically composed of URIs.\"_ This property may be `null`.
  * @param actions
  *   The actions. From _\"OAuth 2.0 Rich Authorization Requests\"_: _\"An array of strings
  *   representing the kinds of actions to be taken at the resource. The values of the strings are
  *   determined by the API being protected.\"_ This property may be `null`.
  * @param dataTypes
  *   From _\"OAuth 2.0 Rich Authorization Requests\"_: _\"An array of strings representing the
  *   kinds of data being requested from the resource.\"_ This property may be `null`.
  * @param identifier
  *   The identifier of a specific resource. From _\"OAuth 2.0 Rich Authorization Requests\"_: _\"A
  *   string identifier indicating a specific resource available at the API.\"_ This property may be
  *   `null`.
  * @param privileges
  *   The types or levels of privilege. From \"OAuth 2.0 Rich Authorization Requests\": _\"An array
  *   of strings representing the types or levels of privilege being requested at the resource.\"_
  *   This property may be `null`.
  * @param otherFields
  *   The RAR request in the JSON format excluding the pre-defined attributes such as `type` and
  *   `locations`. The content and semantics are specific to the deployment and the use case
  *   implemented.
  */
case class AuthorizationDetailsElement(
    `type`: String,
    locations: Option[Seq[String]] = None,
    actions: Option[Seq[String]] = None,
    dataTypes: Option[Seq[String]] = None,
    identifier: Option[String] = None,
    privileges: Option[Seq[String]] = None,
    otherFields: Option[String] = None
)

object AuthorizationDetailsElement {

  given jsonCodec: JsonValueCodec[AuthorizationDetailsElement] =
    JsonCodecMaker.make(codecMakerConfig)

  given encoderAuthorizationDetailsElement: Encoder[AuthorizationDetailsElement] =
    Encoder.instance { t =>
      Json.fromFields {
        Seq(
          Some("type" -> t.`type`.asJson),
          t.locations.map(v => "locations" -> v.asJson),
          t.actions.map(v => "actions" -> v.asJson),
          t.dataTypes.map(v => "dataTypes" -> v.asJson),
          t.identifier.map(v => "identifier" -> v.asJson),
          t.privileges.map(v => "privileges" -> v.asJson),
          t.otherFields.map(v => "otherFields" -> v.asJson)
        ).flatten
      }
    }

  given decoderAuthorizationDetailsElement: Decoder[AuthorizationDetailsElement] =
    Decoder.instance { c =>
      for {
        `type`      <- c.downField("type").as[String]
        locations   <- c.downField("locations").as[Option[Seq[String]]]
        actions     <- c.downField("actions").as[Option[Seq[String]]]
        dataTypes   <- c.downField("dataTypes").as[Option[Seq[String]]]
        identifier  <- c.downField("identifier").as[Option[String]]
        privileges  <- c.downField("privileges").as[Option[Seq[String]]]
        otherFields <- c.downField("otherFields").as[Option[String]]
      } yield AuthorizationDetailsElement(
        `type` = `type`,
        locations = locations,
        actions = actions,
        dataTypes = dataTypes,
        identifier = identifier,
        privileges = privileges,
        otherFields = otherFields
      )
    }

}
