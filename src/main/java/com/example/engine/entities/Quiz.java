package com.example.engine.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "quizzes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String title;
    
    private String text;
    
    @ElementCollection
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<String> options = new ArrayList<>();
    
    @ElementCollection
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Integer> answers = new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User createdBy;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<UserQuizSoln> usersWhoSolvedQuiz = new LinkedHashSet<>();
}
