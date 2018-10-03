package com.example.springsamplekotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringSampleKotlinApplication

fun main(args: Array<String>) {
    runApplication<SpringSampleKotlinApplication>(*args)
}
