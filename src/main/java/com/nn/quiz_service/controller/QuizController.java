package com.nn.quiz_service.controller;

import com.nn.quiz_service.data.models.dto.QuestionDto;
import com.nn.quiz_service.data.models.dto.QuizRequestDto;
import com.nn.quiz_service.data.models.dto.ResponseStructure;
import com.nn.quiz_service.data.models.dto.Submission;
import com.nn.quiz_service.data.models.entity.Quiz;
import com.nn.quiz_service.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<ResponseStructure<Quiz>> createQuiz(@RequestBody QuizRequestDto requestDto){
        return quizService.createQuiz(requestDto);
    }

    @GetMapping("/getQuestions")
    public ResponseEntity<ResponseStructure<List<QuestionDto>>> getQuestionsByIds(@RequestParam long quizId){
        return quizService.getQuestionsByIds(quizId);
    }

    @PostMapping("/submit")
    public ResponseEntity<ResponseStructure<Integer>> getScore(@RequestBody List<Submission> submissions){
        return quizService.getScore(submissions);
    }

}
