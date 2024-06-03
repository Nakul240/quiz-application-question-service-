package com.nn.quiz_service.dao.impl;

import com.nn.quiz_service.dao.QuizDao;
import com.nn.quiz_service.data.models.entity.Quiz;
import com.nn.quiz_service.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QuizDaoImpl implements QuizDao {

    @Autowired
    private QuizRepository quizRepository;

    @Override
    public Quiz saveQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public Quiz fetchQuizById(long quizId) {
        return quizRepository.findById(quizId).orElseThrow(()->new RuntimeException());
    }
}
