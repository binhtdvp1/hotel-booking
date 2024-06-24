package com.hrs.booking.service;

import com.hrs.booking.dto.request.UserRegisterRequest;
import com.hrs.booking.exception.InvalidUserException;
import com.hrs.booking.model.User;

public interface UserService {

    User register(UserRegisterRequest request) throws InvalidUserException;
}
