package com.example.engine.controllers;

import com.example.engine.dtos.QuizDto;
import com.example.engine.dtos.UserQuizSolnDto;
import com.example.engine.entities.User;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface IQuizController {
    QuizDto createQuiz(User user, QuizDto quizDto);
    QuizDto getQuizById(int quizId);
    Page<QuizDto> getAllQuizzes(int pageNo);
    Map<String, String> solveQuiz(User user, int quizId, Map<String, List<Integer>> answers);
    Page<Map<String, UserQuizSolnDto>> getSolvedQuizzes(User user, int pageNo);
    Map<String, String> deleteQuiz(User user, int quizId);
}
