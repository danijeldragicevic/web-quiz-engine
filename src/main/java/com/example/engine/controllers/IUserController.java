package com.example.engine.controllers;

import com.example.engine.dtos.UserDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("/api")
public interface IUserController {
    
    @PostMapping("/register")
    public void registerUser(@RequestBody @Valid UserDto userDto);
}
