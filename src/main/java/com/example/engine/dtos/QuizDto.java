package com.example.engine.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class QuizDto {
    @NotBlank(message = "Title field is mandatory")
    private String title;
    
    @NotBlank(message = "Text field is mandatory")
    private String text;
    
    @NotEmpty(message = "Options field is mandatory")
    @Size(min = 2, message = "At least two options are required")
    private List<String> options;
    
    @NotBlank(message = "Answers can not be null")
    private List<Integer> answers;
}
