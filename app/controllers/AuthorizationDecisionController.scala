package controllers

import scala.concurrent.Future

///import authlete.apis.AuthorizationDecisionEndpoints
import javax.inject.{Inject, Singleton}
import play.api.*
import play.api.mvc.*
import play.api.mvc.Action

/**
  * The endpoint that receives a request from the form in the authorization page.
  */

@Singleton
final class AuthorizationDecisionController @Inject() (
    controllerComponents: ControllerComponents
    // endpoint: AuthorizationDecisionEndpoints
) extends AbstractController(controllerComponents) {

  /**
    * Process a request from the form in the authorization page.
    *
    * <p> NOTE: A better implementation would re-display the authorization page when the pair of
    * login ID and password is wrong, but this implementation does not do it for brevity. A much
    * better implementation would check the login credentials by Ajax. </p>
    *
    * @param request
    *   A request from the form in the authorization page.
    *
    * @param parameters
    *   Request parameters.
    *
    * @return
    *   A response to the user agent. Basically, the response will trigger redirection to the
    *   client's redirect endpoint.
    */

  def authorizationDecision = TODO
}
