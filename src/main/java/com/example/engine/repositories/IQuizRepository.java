package com.example.engine.repositories;

import com.example.engine.entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IQuizRepository extends JpaRepository<Quiz, Integer>, PagingAndSortingRepository<Quiz, Integer> {
}
