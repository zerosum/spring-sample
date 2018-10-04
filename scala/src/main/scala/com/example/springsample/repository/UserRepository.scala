package com.example.springsample.repository

import com.example.springsample.model.User
import org.springframework.stereotype.Service

trait UserRepository {

  def findBySessionId(sessionId: String): Option[User] = {
    sessionId match {
      case "valid" => Some(User("John Doe"))
      case _ => None
    }
  }
}

@Service
object UserRepository extends UserRepository
