package com.example.springsample.controller.support;

import com.example.springsample.model.User;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Optional;

public interface AuthenticateSupport {

    @ModelAttribute
    default Optional<User> authenticate(@CookieValue(name = "sid", required = false) Optional<String> sessionId) {
        return sessionId.flatMap(this::findAccountBySessionId);
    }

    @ModelAttribute
    default User authenticate(@CookieValue(name = "sid") String sessionId) {
        return findAccountBySessionId(sessionId).get();
    }

    default Optional<User> findAccountBySessionId(String sessionId) {
        return Optional.ofNullable(sessionId)
                .filter(sid -> sid.equals("exists"))
                .map(sid -> new User("John Doe"));
    }

}
