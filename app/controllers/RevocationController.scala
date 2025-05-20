package controllers

import scala.concurrent.Future

import authlete.apis.RevocationEndpoints
import javax.inject.{Inject, Singleton}
import play.api.*
import play.api.http.HeaderNames
import play.api.mvc.*
import play.api.mvc.Action

/**
  * An implementation of revocation endpoint (<a href=
  * "https://www.rfc-editor.org/rfc/rfc7009.html">RFC 7009</a>).
  *
  * @see
  *   <a href="https://www.rfc-editor.org/rfc/rfc7009.html" >RFC 7009: OAuth 2.0 Token
  *   Revocation</a>
  */

@Singleton
final class RevocationController @Inject() (
    controllerComponents: ControllerComponents,
    endpoint: RevocationEndpoints[Future]
) extends AbstractController(controllerComponents) {

  /**
    * The revocation endpoint for {@code POST} method.
    *
    * @see
    *   <a href="https://www.rfc-editor.org/rfc/rfc7009.html#section-2.1" >RFC 7009, 2.1. Revocation
    *   Request</a>
    */

  def revocation = Action(parse.formUrlEncoded) {
    implicit request: Request[Map[String, Seq[String]]] =>

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
