package com.example.engine.services.impl;

import com.example.engine.entities.User;
import com.example.engine.repositories.IUserRepository;
import com.example.engine.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final IUserRepository userRepository;
    
    
    @Override
    public User saveUser(User user) {
        return null;
    }

    @Override
    public User findUserByUserId(int id) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Not found: " + username);
        }
        
        return new com.example.engine.services.impl.UserDetails(user);
    }
}
