package controllers

import scala.concurrent.Future

import authlete.apis.DynamicClientRegistrationEndpoints
import javax.inject.{Inject, Singleton}
import play.api.*
import play.api.mvc.*
import play.api.mvc.Action

/**
  * An implementation of the dynamic client registration and dynamic client registration management
  * endpoints. This implementation takes registration requests via POST to {@code /api/register} and
  * returns the resulting registered client as JSON. This implementation takes client management
  * requests via GET, PUT, and DELETE to {@code /api/register/client_id} , where {@code client_id}
  * is the client ID of the registered client. This implementation will parse the client ID from the
  * incoming URL and pass it to the Authlete API.
  *
  * @see
  *   <a href="https://tools.ietf.org/html/rfc7591">RFC 7591</a>
  *
  * @see
  *   <a href="https://tools.ietf.org/html/rfc7592">RFC 7592</a>
  *
  * @see
  *   <a href="https://openid.net/specs/openid-connect-registration-1_0.html" >OpenID Connect
  *   Dynamic Client Registration</a>
  */

@Singleton
final class ClientRegistrationController @Inject() (
    controllerComponents: ControllerComponents,
    endpoint: DynamicClientRegistrationEndpoints[Future]
) extends AbstractController(controllerComponents) {

  /**
    * Dynamic client registration endpoint.
    */

  def post               = TODO
  def update(id: String) = TODO
  def read(id: String)   = TODO
  def delete(id: String) = TODO

}
