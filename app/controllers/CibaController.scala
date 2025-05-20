package controllers

import scala.concurrent.Future

import authlete.apis.CIBAEndpoints
import javax.inject.{Inject, Singleton}
import play.api.*
import play.api.mvc.*
import play.api.mvc.Action

@Singleton
final class CibaController @Inject() (
    controllerComponents: ControllerComponents,
    endpoint: CIBAEndpoints[Future]
) extends AbstractController(controllerComponents) {}
