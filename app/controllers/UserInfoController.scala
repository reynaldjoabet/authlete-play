package controllers

import scala.concurrent.Future

import authlete.apis.UserInfoEndpoints
import javax.inject.{Inject, Singleton}
import play.api.*
import play.api.mvc.*
import play.api.mvc.Action

/**
  * An implementation of userinfo endpoint (<a href=
  * "https://openid.net/specs/openid-connect-core-1_0.html#UserInfo" >OpenID Connect Core 1&#x2E;0,
  * 5&#x2E;3&#x2E; UserInfo Endpoint</a>).
  *
  * @see
  *   <a href="https://openid.net/specs/openid-connect-core-1_0.html#UserInfo" >OpenID Connect Core
  *   10, 5.3. UserInfo Endpoint</a>
  */

@Singleton
final class UserInfoController @Inject() (
    controllerComponents: ControllerComponents,
    endpoint: UserInfoEndpoints[Future]
) extends AbstractController(controllerComponents) {

  /**
    * The userinfo endpoint for {@code GET} method.
    *
    * @see
    *   <a href="https://openid.net/specs/openid-connect-core-1_0.html#UserInfoRequest" >OpenID
    *   Connect Core 1.0, 5.3.1. UserInfo Request</a>
    */
  def userinfoGet = TODO

  /**
    * The userinfo endpoint for {@code POST} method.
    *
    * @see
    *   <a href="https://openid.net/specs/openid-connect-core-1_0.html#UserInfoRequest" >OpenID
    *   Connect Core 1.0, 5.3.1. UserInfo Request</a>
    */

  def userinfoPost = TODO

}
