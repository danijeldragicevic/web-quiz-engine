package com.example.engine.controllers.impl;

import com.example.engine.controllers.IUserController;
import com.example.engine.dtos.UserDto;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements IUserController {
    @Override
    public void registerUser(UserDto userDto) {
        System.out.println(userDto);
    }
}
