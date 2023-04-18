package com.example.engine.services.impl;

import com.example.engine.entities.User;
import com.example.engine.exceptions.UserAlreadyExistsException;
import com.example.engine.repositories.IUserRepository;
import com.example.engine.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
    private final IUserRepository userRepository;
    
    
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserByUserId(int id) {
        return null;
    }

    @Override
    public User registerNewUser(User user) throws UserAlreadyExistsException {
        UserDetails userDetails = null;
        try {
            userDetails = loadUserByUsername(user.getUsername());
        } catch (UsernameNotFoundException e) {
            saveUser(user);
        } finally {
            if (userDetails != null) {
                throw new UserAlreadyExistsException();
            }
        }
        
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Not found: " + username);
        }
        
        return new UserDetailsImpl(user);
    }
}
