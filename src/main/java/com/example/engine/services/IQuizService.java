package com.example.engine.services;

import com.example.engine.entities.Quiz;
import com.example.engine.entities.User;
import com.example.engine.entities.UserQuizSoln;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface IQuizService {
    Quiz createQuiz(User user, Quiz quiz);
    Quiz getQuizById(int quizId);
    Page<Quiz> getAllQuizzes(int pageNo);
    Map<String, String> solveQuiz(User user, int quizId, Map<String, List<Integer>> answers);
    Page<Map<String, UserQuizSoln>> getSolvedQuizzes(User user, int pageNo);
    Map<String, String> deleteQuiz(User user, int quizId);
}
