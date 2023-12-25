package com.question.QuestionService.controller;

import com.question.QuestionService.entity.Question;
import com.question.QuestionService.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private QuestionService questionService;
    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }
    @PostMapping
    public Question create(@RequestBody Question question){
        return questionService.add(question);
    }
    @GetMapping
    public List<Question> getAll(){
        return questionService.getAll();
    }
    @GetMapping("/{id}")
    public Question getById(@PathVariable String id){
        return questionService.getById(id);
    }

    @GetMapping("/quiz/{id}")
    public List<Question> getQuestionByQuizId(@PathVariable String id){
        return questionService.getQuestionByQuizId(id);
    }
}
