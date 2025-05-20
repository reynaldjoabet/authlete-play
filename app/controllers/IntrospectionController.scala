package controllers

import scala.concurrent.Future

import authlete.apis.IntrospectionEndpoints
import javax.inject.{Inject, Singleton}
import play.api.*
import play.api.mvc.*
import play.api.mvc.Action

/**
  * An implementation of introspection endpoint (<a href= "http://tools.ietf.org/html/rfc7662">RFC
  * 7662</a>).
  *
  * @see
  *   <a href="http://tools.ietf.org/html/rfc7662" >RFC 7662, OAuth 2.0 Token Introspection</a>
  */

@Singleton
final class IntrospectionController @Inject() (
    controllerComponents: ControllerComponents,
    endpoint: IntrospectionEndpoints[Future]
) extends AbstractController(controllerComponents) {

  /**
    * The introspection endpoint.
    *
    * @see
    *   <a href="http://tools.ietf.org/html/rfc7662#section-2.1" >RFC 7662, 2.1. Introspection
    *   Request</a>
    */

  def introspect = TODO
}
