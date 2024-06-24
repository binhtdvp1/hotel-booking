package com.hrs.booking.service;

import com.hrs.booking.config.CustomUserDetailService;
import com.hrs.booking.config.JwtGenerator;
import com.hrs.booking.dto.request.JwtTokenRequest;
import com.hrs.booking.dto.response.JwtTokenResponse;
import com.hrs.booking.exception.InvalidUserNamePasswordException;
import com.hrs.booking.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
public class AuthServiceImpl implements AuthService {

    @Value("${jwt.expiration}")
    private int jwtExpirationMs;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailService userDetailService;

    @Autowired
    private JwtGenerator jwtGenerator;

    @Autowired
    private UserRepository userRepository;

    @Override
    public JwtTokenResponse getToken(JwtTokenRequest request) throws InvalidUserNamePasswordException {

        log.info("Start - getToken - {}", request.getEmail());
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));
        }catch (BadCredentialsException ex) {
            throw new InvalidUserNamePasswordException("Username or Password is incorect!");
        }

        UserDetails userDetails = userDetailService.loadUserByUsername(request.getEmail());
        return JwtTokenResponse.builder()
                .accessToken(jwtGenerator.generateToken(userDetails))
                .tokenType("Bearer")
                .expiredDate(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .build();
    }
}
