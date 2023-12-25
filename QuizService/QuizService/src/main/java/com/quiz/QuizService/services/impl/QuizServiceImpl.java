package com.quiz.QuizService.services.impl;

import com.quiz.QuizService.entity.Question;
import com.quiz.QuizService.entity.Quiz;
import com.quiz.QuizService.repo.QuizRepo;
import com.quiz.QuizService.services.QuestionClient;
import com.quiz.QuizService.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

    private QuizRepo quizRepo;

    private QuestionClient questionClient;

    @Autowired
    public QuizServiceImpl(QuestionClient questionClient, QuizRepo quizRepo) {
        this.questionClient = questionClient;
        this.quizRepo = quizRepo;
    }


    @Override
    public Quiz add(Quiz quiz) {
        return quizRepo.save(quiz);
    }

    @Override
    public List<Quiz> getAll() {
        List<Quiz> quizs = quizRepo.findAll();
        List<Quiz> quizList = quizs.stream().map(quiz -> {
            quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
            return quiz;
        }).collect(Collectors.toList());
        return quizList;
    }

    @Override
    public Quiz getById(String id) {
        Quiz quiz= quizRepo.findById(id).orElseThrow(() -> new RuntimeException("Quiz Not Found"));
        quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
        return quiz;
    }
}
