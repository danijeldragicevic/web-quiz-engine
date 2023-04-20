package com.example.engine.mappers.impl;

import com.example.engine.configs.BeansConfig;
import com.example.engine.dtos.QuizDto;
import com.example.engine.dtos.UserDto;
import com.example.engine.dtos.QuizCompletionDto;
import com.example.engine.entities.Quiz;
import com.example.engine.entities.User;
import com.example.engine.entities.QuizCompletion;
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
    public QuizCompletion mapToEntity(QuizCompletionDto quizCompletionDto) {
        return null;
    }

    @Override
    public QuizCompletionDto mapToDto(QuizCompletion quizCompletion) {
        QuizCompletionDto dto = new QuizCompletionDto();
        dto.setId(quizCompletion.getQuiz().getId());
        dto.setCompletedAt(quizCompletion.getCompletedAt());
        
        return dto;
    }
}
