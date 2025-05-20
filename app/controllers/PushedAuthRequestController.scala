package controllers

import scala.concurrent.Future

import authlete.apis.PushedAuthorizationEndpoints
import javax.inject.{Inject, Singleton}
import play.api.*
import play.api.http.HeaderNames
import play.api.mvc.*
import play.api.mvc.Action

/**
  * An implementation of a pushed authorization endpoint.
  *
  * @see
  *   <a href="https://tools.ietf.org/html/draft-lodderstedt-oauth-par" >OAuth 2.0 Pushed
  *   Authorization Requests</a>
  */

@Singleton
final class PushedAuthRequestController @Inject() (
    controllerComponents: ControllerComponents,
    endpoint: PushedAuthorizationEndpoints[Future]
) extends AbstractController(controllerComponents) {

  /**
    * The pushed authorization request endpoint. This uses the {@code POST} method and the same
    * client authentication as is available on the Token Endpoint.
    */
  def post = Action(parse.formUrlEncoded) { implicit request: Request[Map[String, Seq[String]]] =>

    val parameters    = request.body.view.mapValues(_.headOption).toMap
    val headers       = request.headers
    val authorization = headers.get(HeaderNames.AUTHORIZATION)

    // MTLS
    // RFC 8705 : OAuth 2.0 Mutual-TLS Client Authentication and Certificate-Bound Access Tokens
    val clientCertificatePath =
      ??? // (extractClientCertificateChain(request));

    // DPoP
    // RFC 9449 : OAuth 2.0 Demonstrating Proof of Possession (DPoP)
    val dpop = headers.get("DPoP")
    val htm  = "POST"
    val htu  = request.uri

    val clientAttestation    = headers.get("OAuth-Client-Attestation")
    val clientAttestationPop = headers.get("OAuth-Client-Attestation-PoP")

    val params = (
      "parameters"            -> parameters,
      "authorization"         -> authorization,
      "dpop"                  -> dpop,
      "htm"                   -> htm,
      "htu"                   -> htu,
      "clientAttestation"     -> clientAttestation,
      "clientAttestationPop"  -> clientAttestationPop,
      "clientCertificatePath" -> clientCertificatePath
    )

    Ok("")
  }

}
