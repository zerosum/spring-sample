package com.example.springsample

import java.util

import com.example.springsample.controller.resolver.AuthenticatedArgumentResolver
import com.example.springsample.repository.UserRepository
import org.springframework.context.annotation.Configuration
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.servlet.config.annotation.{EnableWebMvc, WebMvcConfigurer}

@Configuration
@EnableWebMvc
class Config extends WebMvcConfigurer {

  override def addArgumentResolvers(argumentResolvers: util.List[HandlerMethodArgumentResolver]): Unit = {
    argumentResolvers.add(new AuthenticatedArgumentResolver(UserRepository))
    argumentResolvers.add(new AuthenticatedArgumentResolver(UserRepository))
  }
}
