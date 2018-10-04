package com.example.springsample.controller.resolver

import com.example.springsample.repository.UserRepository
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.core.MethodParameter
import org.springframework.web.bind.support.WebDataBinderFactory
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.{HandlerMethodArgumentResolver, ModelAndViewContainer}

import scala.collection.JavaConverters._

class AuthenticatedArgumentResolver(val userRepository: UserRepository) extends HandlerMethodArgumentResolver {

  private val logger: Logger = LoggerFactory.getLogger("hoge")

  override def resolveArgument(parameter: MethodParameter,
                               container: ModelAndViewContainer,
                               request: NativeWebRequest,
                               factory: WebDataBinderFactory): AnyRef = {
    request.getParameterMap.asScala.foreach{ case (k, v) => logger.info(s"$k:$v")}

    userRepository.findBySessionId("valid")
  }

  override def supportsParameter(parameter: MethodParameter): Boolean = {
    val bool = parameter.hasParameterAnnotation(classOf[Authenticate])

    logger.info(bool.toString)

    bool
  }
}
