package com.example.springsample.controller;

import com.example.springsample.controller.support.AuthenticateSupport;
import com.example.springsample.model.User;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("sample")
public class SampleController implements AuthenticateSupport {

//    @RequestMapping("1")
//    public String sample1(
//            @CookieValue(name = "sid", required = false) Optional<String> sessionId
//    ) {
//        return sessionId.flatMap(this::findAccountBySessionId)
//                .map(user -> "user has found: " + user.name)
//                .orElse("no user");
//    }

    @RequestMapping("2")
    public String sample2(
            @ModelAttribute Optional<User> user
    ) {
        return user
                .map(u -> "user has found: " + u.name)
                .orElse("no user");
    }

    @RequestMapping("3")
    public String sample3(
            @ModelAttribute User user
    ) {
        return "user has found: " + user.name;
    }

}
