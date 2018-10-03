package com.example.springsamplescala.controller.support

import com.example.springsamplescala.model.User
import org.springframework.web.bind.annotation.{CookieValue, ModelAttribute}

trait AuthenticateSupport {

  @ModelAttribute
  def allowGuest(@CookieValue(name = "sid", required = false) sessionId: String): Option[User] = {
    for {
      sid <- Option(sessionId)
      user <- findAccountBySessionId(sid)
    } yield user
  }

  @ModelAttribute
  def authenticate(@CookieValue(name = "sid") sessionId: String): User = {
    findAccountBySessionId(sessionId).get
  }

  def findAccountBySessionId(sessionId: String): Option[User] = {
    sessionId match {
      case "exists" => Some(User("John Doe"))
      case _ => None
    }
  }
}
