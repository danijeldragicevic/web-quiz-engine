package com.example.engine.controllers.impl;

import com.example.engine.controllers.IQuizController;
import com.example.engine.dtos.QuizDto;
import com.example.engine.dtos.UserQuizSolnDto;
import com.example.engine.entities.Quiz;
import com.example.engine.entities.User;
import com.example.engine.exceptions.QuizNotFoundException;
import com.example.engine.mappers.IModelMapper;
import com.example.engine.services.IQuizService;
import com.example.engine.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class QuizControllerImpl implements IQuizController {
    public static final int PAGE_SIZE = 10;
    private final IModelMapper modelMapper;
    private final IQuizService quizService;
    private final IUserService userService;
    
    @Override
    public ResponseEntity<QuizDto> createQuiz(UserDetails userDetails, QuizDto quizDto) {
        User user = userService.findUserByUsername(userDetails.getUsername());
        
        Quiz quiz = modelMapper.mapToEntity(user, quizDto);
        quizService.createQuiz(quiz);
        
        QuizDto newQuiz = modelMapper.mapToDto(quiz);
        
        return ResponseEntity.ok(newQuiz);
    }

    @Override
    public ResponseEntity<QuizDto> getQuizById(int id) {
        try {
            Quiz quiz = quizService.getQuizById(id);
            QuizDto quizDto = modelMapper.mapToDto(quiz);
            
            return ResponseEntity.ok(quizDto);
        
        } catch (QuizNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<List<QuizDto>>  getAllQuizzes(int page) {
        Pageable pageable = PageRequest.of(page, PAGE_SIZE, Sort.by("id").ascending());
        Page<Quiz> quizPage = quizService.findAll(pageable);
        
        List<QuizDto> quizDtoList = new ArrayList<>();
        for (Quiz q: quizPage.getContent()) {
            quizDtoList.add(modelMapper.mapToDto(q));
        } 
        
        return ResponseEntity.ok(quizDtoList);
    }

    @Override
    public Map<String, String> solveQuiz(User user, int quizId, Map<String, List<Integer>> answers) {
        return null;
    }

    @Override
    public Page<Map<String, UserQuizSolnDto>> getSolvedQuizzes(User user, int page) {
        return null;
    }

    @Override
    public Map<String, String> deleteQuiz(User user, int quizId) {
        return null;
    }
}
