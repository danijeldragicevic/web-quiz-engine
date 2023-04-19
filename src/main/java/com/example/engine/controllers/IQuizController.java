package com.example.engine.controllers;

import com.example.engine.dtos.QuizDto;
import com.example.engine.dtos.UserQuizSolnDto;
import com.example.engine.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RequestMapping("/api")
public interface IQuizController {
    @PostMapping("/quizzes")
    ResponseEntity<QuizDto> createQuiz(@AuthenticationPrincipal UserDetails userDetails, 
                                       @RequestBody @Valid QuizDto quizDto);
    
    @GetMapping("/quizzes/{id}")
    ResponseEntity<QuizDto> getQuizById(@PathVariable int id);
    
    @GetMapping("/quizzes")
    ResponseEntity<List<QuizDto>> getAllQuizzes(@RequestParam(defaultValue = "0") int page);
    
    
    
    Map<String, String> solveQuiz(User user, int quizId, Map<String, List<Integer>> answers);
    Page<Map<String, UserQuizSolnDto>> getSolvedQuizzes(User user, int page);
    Map<String, String> deleteQuiz(User user, int quizId);
}
