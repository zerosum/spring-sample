package com.example.springsample.controller

import com.example.springsample.controller.resolver.{AllowGuest, Authenticate}
import com.example.springsample.controller.support.AuthenticateSupport
import com.example.springsample.model.User
import com.example.springsample.repository.UserRepository
import com.example.springsample.service.DoSomethingService
import org.springframework.web.bind.annotation._

@RestController
@RequestMapping(Array("sample"))
class SampleController(
                        val doSomethingService: DoSomethingService,
                        override val userRepository: UserRepository
                      ) extends AuthenticateSupport
{
  @RequestMapping(Array("doSomething"))
  def sample2(@AllowGuest user: Option[User]): String = {
    user.fold("authenticate failure")(doSomethingService.doSomething)
//    doSomethingService.doSomething(user)
  }
}
