package com.example.engine.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<String> options;
    
    @ElementCollection
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Integer> answers;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User createdBy;
}
