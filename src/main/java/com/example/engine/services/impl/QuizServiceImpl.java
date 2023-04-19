package com.example.engine.services.impl;

import com.example.engine.entities.Quiz;
import com.example.engine.entities.User;
import com.example.engine.entities.UserQuizSoln;
import com.example.engine.exceptions.QuizNotFoundException;
import com.example.engine.repositories.IQuizRepository;
import com.example.engine.services.IQuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements IQuizService {
    private final IQuizRepository quizRepository;
    
    @Override
    public Quiz createQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public Quiz getQuizById(int quizId) throws QuizNotFoundException {
        Optional<Quiz> quiz = quizRepository.findById(quizId);
        if (quiz.isPresent()) {
            return quiz.get();
        } else {
            throw new QuizNotFoundException();
        }
    }

    @Override
    public Page<Quiz> findAll(Pageable pageable) {
        return quizRepository.findAll(pageable);
    }

    @Override
    public Map<String, String> solveQuiz(User user, int quizId, Map<String, List<Integer>> answers) {
        return null;
    }

    @Override
    public Page<Map<String, UserQuizSoln>> getSolvedQuizzes(User user, int pageNo) {
        return null;
    }

    @Override
    public Map<String, String> deleteQuiz(User user, int quizId) {
        return null;
    }
}
