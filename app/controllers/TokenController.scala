package controllers

import scala.concurrent.Future

import authlete.apis.TokenEndpoints
import javax.inject.{Inject, Singleton}
import play.api.*
import play.api.mvc.*
import play.api.mvc.Action

/**
  * An implementation of OAuth 2.0 token endpoint with OpenID Connect support.
  *
  * @see
  *   <a href="http://tools.ietf.org/html/rfc6749#section-3.2" >RFC 6749, 3.2. Token Endpoint</a>
  *
  * @see
  *   <a href="http://openid.net/specs/openid-connect-core-1_0.html#HybridTokenEndpoint" >OpenID
  *   Connect Core 1.0, 3.3.3. Token Endpoint</a>
  */

@Singleton
final class TokenController @Inject() (
    controllerComponents: ControllerComponents,
    endpoint: TokenEndpoints[Future]
) extends AbstractController(controllerComponents) {

  /**
    * The token endpoint for {@code POST} method.
    *
    * <p> <a href="http://tools.ietf.org/html/rfc6749#section-3.2">RFC 6749, 3.2. Token Endpoint</a>
    * says: </p>
    *
    * <blockquote> <i>The client MUST use the HTTP "POST" method when making access token
    * requests.</i> </blockquote>
    *
    * <p> <a href="http://tools.ietf.org/html/rfc6749#section-2.3">RFC 6749, 2.3. Client
    * Authentication</a> mentions (1) HTTP Basic Authentication and (2) {@code client_id} &amp;
    * {@code client_secret} parameters in the request body as the means of client authentication.
    * This implementation supports the both means. </p>
    *
    * @see
    *   <a href="http://tools.ietf.org/html/rfc6749#section-3.2" >RFC 6749, 3.2. Token Endpoint</a>
    */

  def token = Action(parse.formUrlEncoded) { implicit request: Request[Map[String, Seq[String]]] =>
    val parameters = request.body.view.mapValues(_.headOption).toMap
    Ok("")
  }

}
