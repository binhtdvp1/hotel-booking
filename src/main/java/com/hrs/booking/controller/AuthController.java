package com.hrs.booking.controller;

import com.hrs.booking.dto.request.JwtTokenRequest;
import com.hrs.booking.dto.request.UserRegisterRequest;
import com.hrs.booking.exception.InvalidUserException;
import com.hrs.booking.exception.InvalidUserNamePasswordException;
import com.hrs.booking.service.AuthService;
import com.hrs.booking.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public HttpEntity<?> register(@RequestBody UserRegisterRequest request) throws InvalidUserException {
        return new ResponseEntity<>(userService.register(request), HttpStatus.OK);
    }

    @PostMapping("/token")
    public HttpEntity<?> getToken(@RequestBody JwtTokenRequest request) throws InvalidUserNamePasswordException {
        try{
            return new ResponseEntity<>(authService.getToken(request), HttpStatus.OK);
        }catch (InvalidUserNamePasswordException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }
}
