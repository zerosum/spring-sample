package com.example.springsample.service

import com.example.springsample.model.User
import org.springframework.stereotype.Service

trait DoSomethingService {

  def doSomething(user: User): String = {
    s"do something with ${user.name}"
  }
}

@Service
class DoSomethingServiceImpl extends DoSomethingService
