package com.hrs.booking.config;

import com.hrs.booking.model.Role;
import com.hrs.booking.model.User;
import com.hrs.booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(), mapRoleToAuthority(user.getUserRole()));
    }

    private Collection<GrantedAuthority> mapRoleToAuthority(Role role) {
        return List.of(new SimpleGrantedAuthority(role.getRoleCode()));
    }
}
