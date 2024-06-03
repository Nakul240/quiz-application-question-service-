package com.nn.quiz_service.data.models.dto;

import lombok.Data;

@Data
public class QuizRequestDto {

    private String quizTitle;
    private String category;
    private int noOfQuestions;
}
