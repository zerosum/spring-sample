package com.example.springsample.controller.support

import com.example.springsample.model.User
import com.example.springsample.repository.UserRepository
import org.springframework.web.bind.annotation.{CookieValue, ModelAttribute}

trait AuthenticateSupport {

  val userRepository: UserRepository

  @ModelAttribute
  def allowGuest(@CookieValue(name = "sid", required = false) sessionId: String): Option[User] = {
    for {
      sid <- Option(sessionId)
      user <- userRepository.findBySessionId(sid)
    } yield user
  }
}
