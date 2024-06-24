package com.hrs.booking.service;

import com.hrs.booking.dto.request.JwtTokenRequest;
import com.hrs.booking.dto.response.JwtTokenResponse;
import com.hrs.booking.exception.InvalidUserNamePasswordException;

public interface AuthService {

    JwtTokenResponse getToken(JwtTokenRequest request) throws InvalidUserNamePasswordException;
}
