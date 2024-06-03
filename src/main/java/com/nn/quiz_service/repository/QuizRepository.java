package com.nn.quiz_service.repository;

import com.nn.quiz_service.data.models.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz,Long> {
}
