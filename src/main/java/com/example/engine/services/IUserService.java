package com.example.engine.services;

import com.example.engine.entities.User;

public interface IUserService {
    User saveUser(User user);
    User findUserById(int id);
}
