package com.example.engine.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int id;
    
    @NotBlank(message = "Title field is mandatory")
    private String title;
    
    @NotBlank(message = "Text field is mandatory")
    private String text;
    
    @NotEmpty(message = "Options field is mandatory")
    @Size(min = 2, message = "At least two options are required")
    private List<String> options;
    
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Integer> answers;
}
