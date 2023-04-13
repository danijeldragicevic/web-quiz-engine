package com.example.engine.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
    @NotBlank(message = "Email field is mandatory")
    @Email(regexp = ".+\\..+", message = "Email is not correctly formed")
    private String email;
    
    @NotBlank(message = "Password field is mandatory")
    @Size(min = 5, message = "At least five characters are required")
    private String password;
}
