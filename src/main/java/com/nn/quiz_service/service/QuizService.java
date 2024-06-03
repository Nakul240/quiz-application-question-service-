package com.nn.quiz_service.service;

import com.nn.quiz_service.data.models.dto.QuestionDto;
import com.nn.quiz_service.data.models.dto.QuizRequestDto;
import com.nn.quiz_service.data.models.dto.ResponseStructure;
import com.nn.quiz_service.data.models.dto.Submission;
import com.nn.quiz_service.data.models.entity.Quiz;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuizService {
    ResponseEntity<ResponseStructure<Quiz>> createQuiz(QuizRequestDto requestDto);

    ResponseEntity<ResponseStructure<List<QuestionDto>>> getQuestionsByIds(long quizId);

    ResponseEntity<ResponseStructure<Integer>> getScore(List<Submission> submissions);
}
