package controllers

import scala.concurrent.Future
import scala.util.Failure
import scala.util.Success
import scala.util.Try

import authlete.apis.AuthorizationEndpoints
import authlete.models.*
import javax.inject.{Inject, Singleton}
import play.api.*
import play.api.libs.json.Json
import play.api.mvc.*
import play.api.mvc.Action

/**
  * An implementation of OAuth 2.0 authorization endpoint with OpenID Connect support.
  *
  * @see
  *   <a href="http://tools.ietf.org/html/rfc6749#section-3.1" >RFC 6749, 3.1. Authorization
  *   Endpoint</a>
  *
  * @see
  *   <a href="http://openid.net/specs/openid-connect-core-1_0.html#AuthorizationEndpoint" >OpenID
  *   Connect Core 1.0, 3.1.2. Authorization Endpoint (Authorization Code Flow)</a>
  *
  * @see
  *   <a href="http://openid.net/specs/openid-connect-core-1_0.html#ImplicitAuthorizationEndpoint"
  *   >OpenID Connect Core 1.0, 3.2.2. Authorization Endpoint (Implicit Flow)</a>
  *
  * @see
  *   <a href="http://openid.net/specs/openid-connect-core-1_0.html#HybridAuthorizationEndpoint"
  *   >OpenID Connect Core 1.0, 3.3.2. Authorization Endpoint (Hybrid Flow)</a>
  */

@Singleton
final class AuthorizationController @Inject() (
    controllerComponents: ControllerComponents,
    endpoint: AuthorizationEndpoints[Future]
) extends AbstractController(controllerComponents) {

  implicit val ec: scala.concurrent.ExecutionContext =
    controllerComponents.executionContext

  /**
    * The authorization endpoint for {@code GET} method.
    *
    * <p> <a href="http://tools.ietf.org/html/rfc6749#section-3.1">RFC 6749, 3.1 Authorization
    * Endpoint</a> says that the authorization endpoint MUST support {@code GET} method. </p>
    *
    * @see
    *   <a href="http://tools.ietf.org/html/rfc6749#section-3.1" >RFC 6749, 3.1 Authorization
    *   Endpoint</a>
    */

  def authorizationGet: Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    val params = ???
    Ok("")
  }
  //   val authReq = new AuthorizationRequest(params)
  //   val req     = endpoint.authAuthorizationApi("", "")(authReq)
  //   backend
  //     .send(req)
  //     .map { response =>
  //       response.code match {
  //         // code 200 : AuthorizationResponse ()
  //         case StatusCode.Ok =>
  //           response.body match {
  //             case Right(authResponse) =>
  //               // Handle success based on the action
  //               authResponse
  //                 .action
  //                 .fold(
  //                   Ok("bad res")
  //                 )(action => handleResponse(action))
  //             case Left(_) =>
  //               BadRequest(Json.obj("error" -> "msg"))
  //           }

  //         // code 400 : Result ()
  //         case StatusCode.BadRequest =>
  //           response.body.fold(_ => BadRequest(""), result => BadRequest(""))
  //         // BadRequest("")
  //         // code 401 : Result ()
  //         case StatusCode.Unauthorized => Unauthorized("")
  //         // code 403 : Result ()
  //         case StatusCode.Forbidden => Forbidden("")
  //         // code 500 : Result ()
  //         case StatusCode.InternalServerError => InternalServerError("")
  //       }
  //     }
  //     .recover { case ex: Exception =>
  //       // Handle any exception in the Future
  //       InternalServerError(Json.obj("error" -> "Internal Server Error"))
  //     }
  // }

  /**
    * The authorization endpoint for {@code POST} method.
    *
    * <p> <a href="http://tools.ietf.org/html/rfc6749#section-3.1">RFC 6749, 3.1 Authorization
    * Endpoint</a> says that the authorization endpoint MAY support {@code POST} method. </p>
    *
    * <p> In addition, <a href="http://openid.net/specs/openid-connect-core-1_0.html#AuthRequest"
    * >OpenID Connect Core 1.0, 3.1.2.1. Authentication Request</a> says that the authorization
    * endpoint MUST support {@code POST} method. </p>
    */

  def authorizationPost = Action(parse.formUrlEncoded) {
    implicit request: Request[Map[String, Seq[String]]] =>
      val parameters = request.body // from form
      Ok("Authorization post endpoint")
  }

  // private def handleResponse(action: AuthorizationResponseEnums.Action) =
  //   action match {
  //     case AuthorizationResponseEnums.Action.BADREQUEST          => Ok("")
  //     case AuthorizationResponseEnums.Action.FORM                => Ok("")
  //     case AuthorizationResponseEnums.Action.INTERACTION         => Ok("")
  //     case AuthorizationResponseEnums.Action.INTERNALSERVERERROR => Ok("")
  //     case AuthorizationResponseEnums.Action.LOCATION            => Ok("")
  //     case AuthorizationResponseEnums.Action.NOINTERACTION       => Ok("")

  //   }

}
