package com.quiz.QuizService.repo;

import com.quiz.QuizService.entity.Quiz;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuizRepo extends MongoRepository<Quiz, String> {
}
