package com.example.engine.controllers;

import com.example.engine.dtos.QuizDto;
import com.example.engine.dtos.UserQuizSolnDto;
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
    
    @PostMapping("/quizzes/{id}/solve")
    ResponseEntity<Map<String, String>> solveQuiz(@AuthenticationPrincipal UserDetails userDetails, 
                                                  @PathVariable int id, 
                                                  @RequestBody Map<String, List<Integer>> answers);
    
    @GetMapping("/quizzes/completed")
    ResponseEntity<Map<String, List<UserQuizSolnDto>>> getCompletedQuizzes(@AuthenticationPrincipal UserDetails userDetails, 
                                                                     @RequestParam(defaultValue = "0") int page);
    
    @DeleteMapping("/quizzes/{id}")
    ResponseEntity<?> deleteQuiz(@AuthenticationPrincipal UserDetails userDetails, 
                                 @PathVariable int id);
}
