package com.example.engine.controllers;

import com.example.engine.dtos.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Map;

@RequestMapping("/api")
public interface IUserController {
    @PostMapping("/register")
    ResponseEntity<Map<String, String>> registerUser(@RequestBody @Valid UserDto userDto);
}
