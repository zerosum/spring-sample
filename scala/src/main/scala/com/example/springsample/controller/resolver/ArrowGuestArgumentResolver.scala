package com.example.springsample.controller.resolver

import com.example.springsample.repository.UserRepository
import javax.servlet.http.HttpServletRequest
import org.springframework.core.MethodParameter
import org.springframework.web.bind.support.WebDataBinderFactory
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.{HandlerMethodArgumentResolver, ModelAndViewContainer}

class ArrowGuestArgumentResolver(val userRepository: UserRepository) extends HandlerMethodArgumentResolver {

  override def resolveArgument(parameter: MethodParameter,
                               container: ModelAndViewContainer,
                               webRequest: NativeWebRequest,
                               factory: WebDataBinderFactory): AnyRef = {
    val request = webRequest.getNativeRequest(classOf[HttpServletRequest])

    for {
      sid <- request.getCookies.collectFirst { case c if c.getName == "sid" => c.getValue }
      user <- userRepository.findBySessionId(sid)
    } yield user
  }

  override def supportsParameter(parameter: MethodParameter): Boolean = {
    parameter.hasParameterAnnotation(classOf[AllowGuest])
  }
}
