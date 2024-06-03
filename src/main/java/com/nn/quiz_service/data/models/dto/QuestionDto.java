package com.nn.quiz_service.data.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionDto {

    private String _id;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
}
