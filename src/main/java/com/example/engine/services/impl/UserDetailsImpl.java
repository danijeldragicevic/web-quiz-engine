package com.example.engine.services.impl;

import com.example.engine.entities.User;
import com.example.engine.services.IUserDetails;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class UserDetailsImpl implements IUserDetails {
    private final String username;
    private final String password;
    
    public UserDetailsImpl(User user) {
        username = user.getUsername();
        password = user.getPassword();
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
