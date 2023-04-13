package com.example.engine.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "quizzes")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String title;
    
    private String text;
    
    @ElementCollection
    private List<String> options;
    
    @ElementCollection
    private List<Integer> answers;
    
    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;
}
