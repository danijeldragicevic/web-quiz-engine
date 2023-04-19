package com.example.engine.services.impl;

import com.example.engine.entities.Quiz;
import com.example.engine.entities.User;
import com.example.engine.entities.UserQuizSoln;
import com.example.engine.exceptions.QuizNotFoundException;
import com.example.engine.repositories.IQuizRepository;
import com.example.engine.repositories.IUserQuizSolnRepository;
import com.example.engine.repositories.IUserRepository;
import com.example.engine.services.IQuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements IQuizService {
    private final IQuizRepository quizRepository;
    private final IUserRepository userRepository;
    private final IUserQuizSolnRepository userQuizSolnRepository;
    
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
    public Map<String, String> solveQuiz(User user, int quizId, List<Integer> submittedAnswers) {
        UserQuizSoln quizSolution = new UserQuizSoln();
        Quiz quiz = getQuizById(quizId);
        
        Map<String, String> responseMsg = new HashMap<>();
        if (answersAreCorrect(quiz.getAnswers(), submittedAnswers)) {
            quizSolution.setUser(user);
            quizSolution.setQuiz(quiz);
            quizSolution.setCompletedAt(LocalDateTime.now());
            
            user.getQuizzesSolved().add(quizSolution);
            quiz.getUsersWhoSolvedQuiz().add(quizSolution);
            
            responseMsg.put("success", "true");
            responseMsg.put("feedback", "Congratulations, you're right!");
        } else {
            responseMsg.put("success", "false");
            responseMsg.put("false", "Wrong answer! Please, try again.");
        }

        try {
            updateRepositories(quizSolution, user, quiz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return responseMsg;
    }

    @Override
    public Page<UserQuizSoln> findAllByUserId(int id, Pageable pageable) {
        return userQuizSolnRepository.findAllByUserId(id, pageable);
    }


    @Override
    public Map<String, String> deleteQuiz(User user, int quizId) {
        return null;
    }

    private boolean answersAreCorrect(List<Integer> quizzesAnswers, List<Integer> submittedAnswers) {
        if (submittedAnswers == null || submittedAnswers.size() == 0) {
            return false;
        }
        if (toSortedList(quizzesAnswers).equals(toSortedList(submittedAnswers))) {
            return true;
        } else {
            return false;
        }
    }
    
    private List<Integer> toSortedList(List<Integer> integers) {
        List<Integer> result = new ArrayList<>();
        for (Integer i: integers) {
            result.add(i);
        }
        Collections.sort(result);
        
        return result;
    }
    
    @Transactional
    void updateRepositories(UserQuizSoln quizSolution, User user, Quiz quiz) {
        userQuizSolnRepository.save(quizSolution);
        userRepository.save(user);
        quizRepository.save(quiz);
    }
}
