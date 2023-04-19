package com.example.engine.repositories;

import com.example.engine.entities.UserQuizSoln;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface IUserQuizSolnRepository extends JpaRepository<UserQuizSoln, Integer>, PagingAndSortingRepository<UserQuizSoln, Integer> {
    
    @Query(value = "SELECT * FROM USER_QUIZ u WHERE u.USER_ID = :id", nativeQuery = true)
    Page<UserQuizSoln> findAllByUserId(@Param("id") int id, Pageable pageable);
}
