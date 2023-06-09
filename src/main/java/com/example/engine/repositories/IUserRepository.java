package com.example.engine.repositories;

import com.example.engine.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
    @Override
    User save(User user);
    
    User findUserByUsername(String username);
}
