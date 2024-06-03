package com.nn.quiz_service.data.models.dto;

import lombok.Data;
import lombok.Getter;

@Data
public class Submission {
    private String questionId;
    private String chosenOption;
}
