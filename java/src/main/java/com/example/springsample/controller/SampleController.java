package com.example.springsample.controller;

import com.example.springsample.controller.support.AuthenticateSupport;
import com.example.springsample.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Optional;

@RestController
@RequestMapping("sample")
public class SampleController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

//    @RequestMapping("1")
//    public String sample1(
//            @CookieValue(name = "sid", required = false) Optional<String> sessionId
//    ) {
//        return sessionId.flatMap(this::findAccountBySessionId)
//                .map(user -> "user has found: " + user.name)
//                .orElse("no user");
//    }

    @RequestMapping("2")
    public String sample2(@ModelAttribute(ALLOW_GUEST) Optional<User> user) {
        return user
                .map(u -> "user has found: " + u.name)
                .orElse("no user");
    }

    @RequestMapping("3")
    public String sample3(@ModelAttribute(AUTHENTICATE) User user) {
        return "user has found: " + user.name;
    }

    private final String ALLOW_GUEST = "allowGuest";
    private final String AUTHENTICATE = "authenticate";

    @ModelAttribute(ALLOW_GUEST)
    private Optional<User> allowGuest(@CookieValue(value = "sid", required = false) String sessionId) {
        logger.info("================ ALLOW GUEST");
        return Optional.ofNullable(sessionId).flatMap(this::findAccountBySessionId);
    }

    @ModelAttribute(AUTHENTICATE)
    private User authenticate(@CookieValue(value = "sid") String sessionId) {
        logger.info("================ AUTHENTICATE");
        return findAccountBySessionId(sessionId).get();
    }

    private Optional<User> findAccountBySessionId(String sessionId) {
        return Optional.ofNullable(sessionId)
                .filter(sid -> sid.equals("exists"))
                .map(sid -> new User("John Doe"));
    }

}
