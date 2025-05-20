package controllers

import scala.concurrent.Future

import authlete.apis.GrantManagementEndpoints
import javax.inject.{Inject, Singleton}
import play.api.*
import play.api.mvc.*
import play.api.mvc.Action

/**
  * An implementation of Grant Management Endpoint.
  *
  * @see
  *   <a href="https://openid.net/specs/fapi-grant-management.html" >Grant Management for OAuth
  *   2.0</a>
  */

@Singleton
final class GrantManagementController @Inject() (
    controllerComponents: ControllerComponents,
    endpoint: GrantManagementEndpoints[Future]
) extends AbstractController(controllerComponents) {

  /**
    * The entry point for grant management 'query' requests.
    */
  def gm(grantId: String) = TODO

  /**
    * The entry point for grant management 'revoke' requests.
    */

  def revoke(grantId: String) = TODO

}
