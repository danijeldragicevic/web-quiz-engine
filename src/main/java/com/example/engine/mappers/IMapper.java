package com.example.engine.mappers;

import com.example.engine.dtos.QuizDto;
import com.example.engine.dtos.UserDto;
import com.example.engine.dtos.UserQuizSolnDto;
import com.example.engine.entities.Quiz;
import com.example.engine.entities.User;
import com.example.engine.entities.UserQuizSoln;

public interface IMapper {
    Quiz mapToEntity(QuizDto quizDto);
    QuizDto mapToDto(Quiz quiz);
    
    User mapToEntity(UserDto userDto);
    UserDto mapToDto(User user);
    
    UserQuizSoln mapToEntity(UserQuizSolnDto userQuizSolnDto);
    UserQuizSolnDto mapToDto(UserQuizSoln userQuizSoln);
}
