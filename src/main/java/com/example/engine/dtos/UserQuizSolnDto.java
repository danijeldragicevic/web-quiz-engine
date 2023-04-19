package com.example.engine.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserQuizSolnDto {
    private int id;
    private LocalDateTime completedAt;
}
