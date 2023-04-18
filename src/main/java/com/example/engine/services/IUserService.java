package com.example.engine.services;

import com.example.engine.entities.User;
import com.example.engine.exceptions.UserAlreadyExistsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface IUserService extends UserDetailsService {
    User saveUser(User user);
    User findUserByUserId(int id);
    User registerNewUser(User user) throws UserAlreadyExistsException;
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
