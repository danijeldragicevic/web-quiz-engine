package com.example.engine.mappers;

import com.example.engine.dtos.QuizDto;
import com.example.engine.dtos.UserDto;
import com.example.engine.dtos.QuizCompletionDto;
import com.example.engine.entities.Quiz;
import com.example.engine.entities.User;
import com.example.engine.entities.QuizCompletion;

public interface IModelMapper {
    Quiz mapToEntity(User user, QuizDto quizDto);
    QuizDto mapToDto(Quiz quiz);
    
    User mapToEntity(UserDto userDto);
    UserDto mapToDto(User user);
    
    QuizCompletion mapToEntity(QuizCompletionDto quizCompletionDto);
    QuizCompletionDto mapToDto(QuizCompletion quizCompletion);
}
