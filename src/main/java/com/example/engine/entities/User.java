package com.example.engine.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(unique = true)
    private String email;
    
    private String password;
    
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<UserQuizSoln> quizzesSolved;
}
