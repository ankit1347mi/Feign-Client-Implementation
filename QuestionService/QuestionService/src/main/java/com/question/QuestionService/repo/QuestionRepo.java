package com.question.QuestionService.repo;

import com.question.QuestionService.entity.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QuestionRepo extends MongoRepository<Question, String> {

    List<Question> findByQuizId(String quizId);
}
