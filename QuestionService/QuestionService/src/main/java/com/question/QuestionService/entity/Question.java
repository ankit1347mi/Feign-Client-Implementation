package com.question.QuestionService.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "question")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    @Id
    private String questionId;

    private String question;

    private String quizId;
}
