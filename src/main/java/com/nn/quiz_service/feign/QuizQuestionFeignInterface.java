package com.nn.quiz_service.feign;

import com.nn.quiz_service.data.models.dto.QuestionDto;
import com.nn.quiz_service.data.models.dto.ResponseStructure;
import com.nn.quiz_service.data.models.dto.Submission;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface QuizQuestionFeignInterface {

    @GetMapping("api/questions/generate")
    public ResponseEntity<ResponseStructure<List<String>>> generateQuizQuestions(@RequestParam String category, @RequestParam int noOfQuestions) ;

    @PostMapping("api/questions/getQuestions")
    public ResponseEntity<ResponseStructure<List<QuestionDto>>> getGeneratedQuestions(@RequestBody List<String> questionIds);

    @PostMapping("api/questions/getScore")
    public ResponseEntity<ResponseStructure<Integer>> getScore(@RequestBody List<Submission> submissions);
}
