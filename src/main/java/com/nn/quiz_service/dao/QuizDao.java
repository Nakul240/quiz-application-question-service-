package com.nn.quiz_service.dao;

import com.nn.quiz_service.data.models.entity.Quiz;

import java.util.List;

public interface QuizDao {
    Quiz saveQuiz(Quiz quiz);

    Quiz fetchQuizById(long quizId);
}
