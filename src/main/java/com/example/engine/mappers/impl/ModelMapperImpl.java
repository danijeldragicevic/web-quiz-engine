package com.example.engine.mappers.impl;

import com.example.engine.configs.BeansConfig;
import com.example.engine.dtos.QuizDto;
import com.example.engine.dtos.UserDto;
import com.example.engine.dtos.UserQuizSolnDto;
import com.example.engine.entities.Quiz;
import com.example.engine.entities.User;
import com.example.engine.entities.UserQuizSoln;
import com.example.engine.mappers.IModelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@RequiredArgsConstructor
public class ModelMapperImpl implements IModelMapper {
    
    @Autowired
    private BeansConfig beansConfig;

    @Override
    public Quiz mapToEntity(User user, QuizDto quizDto) {
        Quiz quiz = new Quiz();
        quiz.setTitle(quizDto.getTitle());
        quiz.setText(quizDto.getText());
        quiz.setOptions(quizDto.getOptions());
        quiz.setAnswers(quizDto.getAnswers());
        quiz.setCreatedBy(user);
        
        return quiz;
    }

    @Override
    public QuizDto mapToDto(Quiz quiz) {
        QuizDto quizDto = new QuizDto();
        quizDto.setId(quiz.getId());
        quizDto.setTitle(quiz.getTitle());
        quizDto.setText(quiz.getText());
        quizDto.setOptions(quiz.getOptions());
        
        return quizDto;
    }

    @Override
    public User mapToEntity(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getEmail());
        user.setPassword(beansConfig.getEncoder().encode(userDto.getPassword()));
        
        return user;
    }

    @Override
    public UserDto mapToDto(User user) {
        return null;
    }

    @Override
    public UserQuizSoln mapToEntity(UserQuizSolnDto userQuizSolnDto) {
        return null;
    }

    @Override
    public UserQuizSolnDto mapToDto(UserQuizSoln userQuizSoln) {
        return null;
    }
}
