package com.hrs.booking.service;

import com.hrs.booking.dto.request.UserRegisterRequest;
import com.hrs.booking.exception.InvalidUserException;
import com.hrs.booking.model.User;
import com.hrs.booking.repository.RoleRepository;
import com.hrs.booking.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User register(UserRegisterRequest request) throws InvalidUserException {

        log.info("Start - register user - {}", request.getEmail());

        if (userRepository.existsByEmail(request.getEmail())) {
            throw  new InvalidUserException("Email is existed");
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setPhoneNumber(request.getPhoneNumber());
        user.setRefRoleId(roleRepository.findByRoleCodeAndActiveFlag("USER", 1).getRoleId());

        return userRepository.save(user);
    }
}
