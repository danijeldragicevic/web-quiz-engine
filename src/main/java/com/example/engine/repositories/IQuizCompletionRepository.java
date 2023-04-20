package com.example.engine.repositories;

import com.example.engine.entities.QuizCompletion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface IQuizCompletionRepository extends JpaRepository<QuizCompletion, Integer>, PagingAndSortingRepository<QuizCompletion, Integer> {
    
    @Query(value = "SELECT * FROM QUIZZES_COMPLETIONS q WHERE q.USER_ID = :id", nativeQuery = true)
    Page<QuizCompletion> findAllByUserId(@Param("id") int id, Pageable pageable);
}
