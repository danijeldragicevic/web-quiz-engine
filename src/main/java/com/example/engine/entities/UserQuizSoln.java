package com.example.engine.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "user_quiz")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserQuizSoln {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private LocalDateTime completedAt;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;
}