package com.example.springsamplescala

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class SpringSampleApplication

object SpringSampleApplication {
  def main(args: Array[String]): Unit = {
    SpringApplication.run(classOf[SpringSampleApplication], args: _*)
  }
}
