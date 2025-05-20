package controllers

import scala.concurrent.Future

import authlete.apis.JWKSetEndpoints
import javax.inject.{Inject, Singleton}
import play.api.*
import play.api.mvc.*
import play.api.mvc.Action

/**
  * An implementation of an endpoint to expose a JSON Web Key Set document (<a
  * href="https://tools.ietf.org/html/rfc7517">RFC 7517</a>).
  *
  * <p> An OpenID Provider (OP) is required to expose its JSON Web Key Set document (JWK Set) so
  * that client applications can (1) verify signatures by the OP and (2) encrypt their requests to
  * the OP. The URI of a JWK Set endpoint can be found as the value of <b>{@code jwks_uri}</b> in <a
  * href= "http://openid.net/specs/openid-connect-discovery-1_0.html#ProviderMetadata" >OpenID
  * Provider Metadata</a> if the OP supports <a href=
  * "http://openid.net/specs/openid-connect-discovery-1_0.html">OpenID Connect Discovery 1.0</a>.
  * </p>
  *
  * @see
  *   <a href="http://tools.ietf.org/html/rfc7517" >RFC 7517, JSON Web Key (JWK)</a>
  *
  * @see
  *   <a href="http://openid.net/specs/openid-connect-core-1_0.htm" >OpenID Connect Core 1.0</a>
  *
  * @see
  *   <a href="http://openid.net/specs/openid-connect-discovery-1_0.html" >OpenID Connect Discovery
  *   1.0</a>
  */

@Singleton
final class JwksController @Inject() (
    controllerComponents: ControllerComponents,
    endpoint: JWKSetEndpoints[Future]
) extends AbstractController(controllerComponents) {

  /**
    * JWK Set endpoint.
    */

  def jwks = TODO
}
