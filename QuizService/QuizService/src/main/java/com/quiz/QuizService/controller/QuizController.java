package com.quiz.QuizService.controller;

import com.quiz.QuizService.entity.Quiz;
import com.quiz.QuizService.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    private QuizService quizService;
    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }
    @PostMapping
    public Quiz create(@RequestBody Quiz quiz){
        return quizService.add(quiz);
    }
    @GetMapping
    public List<Quiz> getAll(){
        return quizService.getAll();
    }

    @GetMapping("/{id}")
    public Quiz getById(@PathVariable String id){
        return quizService.getById(id);
    }
}



















