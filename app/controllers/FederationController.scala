package controllers

import scala.concurrent.Future

import authlete.apis.FederationEndpoints
import javax.inject.{Inject, Singleton}
import play.api.*
import play.api.mvc.*
import play.api.mvc.Action

@Singleton
final class FederationController @Inject() (
    controllerComponents: ControllerComponents,
    endpoint: FederationEndpoints[Future]
) extends AbstractController(controllerComponents) {

  def initiation(federationId: String) = TODO

  def callback(federationId: String) = TODO

}
