package com.example.engine.repositories;

import com.example.engine.entities.UserQuizSoln;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IUserQuizSolnRepository extends JpaRepository<UserQuizSoln, Integer>, PagingAndSortingRepository<UserQuizSoln, Integer> {
}
