package com.example.engine.controllers.impl;

import com.example.engine.controllers.IUserController;
import com.example.engine.dtos.UserDto;
import com.example.engine.entities.User;
import com.example.engine.exceptions.UserAlreadyExistsException;
import com.example.engine.mappers.IModelMapper;
import com.example.engine.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements IUserController {
    private final IModelMapper modelMapper;
    private final IUserService userService;
    
    @Override
    public ResponseEntity<Map<String, String>> registerUser(UserDto userDto) {
        User user = modelMapper.mapToEntity(userDto);
        try {
            userService.registerNewUser(user);
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.badRequest().build();
        }
        
        return ResponseEntity.ok(Map.of("message", "User successfully created."));
    }
}
