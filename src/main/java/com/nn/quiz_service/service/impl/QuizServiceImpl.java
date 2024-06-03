package com.nn.quiz_service.service.impl;

import com.nn.quiz_service.dao.QuizDao;
import com.nn.quiz_service.data.models.dto.QuestionDto;
import com.nn.quiz_service.data.models.dto.QuizRequestDto;
import com.nn.quiz_service.data.models.dto.ResponseStructure;
import com.nn.quiz_service.data.models.dto.Submission;
import com.nn.quiz_service.data.models.entity.Quiz;
import com.nn.quiz_service.feign.QuizQuestionFeignInterface;
import com.nn.quiz_service.service.QuizService;
import com.nn.quiz_service.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizQuestionFeignInterface questionInterface;

    @Autowired
    private QuizDao quizDao;

    @Override
    public ResponseEntity<ResponseStructure<Quiz>> createQuiz(QuizRequestDto requestDto) {
        List<String> ids = questionInterface.generateQuizQuestions(requestDto.getCategory(), requestDto.getNoOfQuestions()).getBody().getData();
        Quiz quiz = Quiz.builder().quizTitle(requestDto.getQuizTitle()).questionIds(ids).build();
        quiz = quizDao.saveQuiz(quiz);
        return ResponseUtil.getCreated(quiz);
    }

    @Override
    public ResponseEntity<ResponseStructure<List<QuestionDto>>> getQuestionsByIds(long quizId) {
        return questionInterface.getGeneratedQuestions(quizDao.fetchQuizById(quizId).getQuestionIds());
    }

    @Override
    public ResponseEntity<ResponseStructure<Integer>> getScore(List<Submission> submissions) {
        return questionInterface.getScore(submissions);
    }
}
