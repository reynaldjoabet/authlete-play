package controllers

import scala.concurrent.Future

import authlete.apis.FederationEndpoints
import javax.inject.{Inject, Singleton}
import play.api.*
import play.api.mvc.*
import play.api.mvc.Action

/**
  * An implementation of the entity configuration endpoint.
  *
  * <p> An OpenID Provider that supports <a href=
  * "https://openid.net/specs/openid-federation-1_0.html">OpenID Federation 1.0</a> must provide an
  * endpoint that returns its <b>entity configuration</b> in the JWT format. The URI of the endpoint
  * is defined as follows: </p>
  *
  * <ol> <li>Entity ID + {@code /.well-known/openid-federation} <li>Host component of Entity ID +
  * {@code /.well-known/openid-federation} + Path component of Entity ID (The same rule in <a href=
  * "https://www.rfc-editor.org/rfc/rfc8414.html">RFC 8414</a>) </ol>
  *
  * <p> <b>Entity ID</b> is a URL that identifies an OpenID Provider (and other entities including
  * Relying Parties, Trust Anchors and Intermediate Authorities) in the context of OpenID Federation
  * 1.0. </p>
  *
  * <p> Note that OpenID Federation 1.0 is supported since Authlete 2.3. </p>
  *
  * @see
  *   <a href="https://openid.net/specs/openid-federation-1_0.html" >OpenID Federation 1.0</a>
  */

@Singleton
final class FederationConfigurationController @Inject() (
    controllerComponents: ControllerComponents,
    endpoint: FederationEndpoints[Future]
) extends AbstractController(controllerComponents) {

  /**
    * An implementation of the entity configuration endpoint.
    *
    * <p> An OpenID Provider that supports <a href=
    * "https://openid.net/specs/openid-federation-1_0.html">OpenID Federation 1.0</a> must provide
    * an endpoint that returns its <b>entity configuration</b> in the JWT format. The URI of the
    * endpoint is defined as follows: </p>
    *
    * <ol> <li>Entity ID + {@code /.well-known/openid-federation} <li>Host component of Entity ID +
    * {@code /.well-known/openid-federation} + Path component of Entity ID (The same rule in <a
    * href= "https://www.rfc-editor.org/rfc/rfc8414.html">RFC 8414</a>) </ol>
    *
    * <p> <b>Entity ID</b> is a URL that identifies an OpenID Provider (and other entities including
    * Relying Parties, Trust Anchors and Intermediate Authorities) in the context of OpenID
    * Federation 1.0. </p>
    *
    * <p> Note that OpenID Federation 1.0 is supported since Authlete 2.3. </p>
    *
    * @see
    *   <a href="https://openid.net/specs/openid-federation-1_0.html" >OpenID Federation 1.0</a>
    */

  def config = Action {
    Ok("")
  }

}
