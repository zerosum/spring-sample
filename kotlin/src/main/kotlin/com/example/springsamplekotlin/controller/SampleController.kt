package com.example.springsamplekotlin.controller

import com.example.springsamplekotlin.model.User
import org.springframework.web.bind.annotation.CookieValue
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("sample")
class SampleController {

    @RequestMapping("2")
    fun sample2(@ModelAttribute user: User?): String {
        return user?.let { "user has found: " + it.name } ?: "no user"
    }

    @RequestMapping("3")
    fun sample3(@ModelAttribute user: User): String {
        return "user has found: " + user.name
    }

    @ModelAttribute
    fun authenticate(@CookieValue(name = "sid", required = false) sessionId: String?): User? {
        return sessionId?.let { sid ->
            findAccountBySessionId(sid)
        }
    }

    @ModelAttribute
    fun strictAuthenticate(@CookieValue(name = "sid") sessionId: String): User {
        return findAccountBySessionId(sessionId)!!
    }

    fun findAccountBySessionId(sessionId: String): User? {
        return if (sessionId == "exists") User("John Doe") else null
    }

}