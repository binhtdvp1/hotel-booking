package com.hrs.booking.handler;

import com.hrs.booking.config.JwtGenerator;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserLoginHandler {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private JwtGenerator jwtGenerator;

    public Integer getLoginUserId() {
        log.info("Start - get login user info");

        final String authorizationHeader = request.getHeader("Authorization");

        Integer userId;
        String jwt;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7);
            return jwtGenerator.extractUserId(jwt);
        }
        return null;
    }
}
