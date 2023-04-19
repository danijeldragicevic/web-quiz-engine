package com.example.engine.services;

import com.example.engine.entities.Quiz;
import com.example.engine.entities.User;
import com.example.engine.entities.UserQuizSoln;
import com.example.engine.exceptions.QuizNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface IQuizService {
    Quiz createQuiz(Quiz quiz);
    
    Quiz getQuizById(int quizId) throws QuizNotFoundException;
    
    Page<Quiz> findAll(Pageable pageable);
    
    Map<String, String> solveQuiz(User user, int quizId, List<Integer> submittedAnswers);
    
    Page<UserQuizSoln> findAllByUserId(int id, Pageable pageable);
    
    Map<String, String> deleteQuiz(User user, int quizId);

}
