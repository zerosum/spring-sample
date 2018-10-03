package com.example.springsamplescala.controller

import com.example.springsamplescala.controller.support.AuthenticateSupport
import com.example.springsamplescala.model.User
import org.springframework.web.bind.annotation._

@RestController
@RequestMapping(Array("sample"))
class SampleController extends AuthenticateSupport {

  @RequestMapping(Array("2"))
  def sample2(@ModelAttribute user: Option[User]): String = {
    user.fold("no user")(u => s"user has found: ${u.name}")
  }

  @RequestMapping(Array("3"))
  def sample3(@ModelAttribute user: User): String = {
    s"user has found: ${user.name}"
  }
}
