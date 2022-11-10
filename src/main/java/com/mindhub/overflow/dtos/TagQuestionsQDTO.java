package com.mindhub.overflow.dtos;

import com.mindhub.overflow.models.Question;
import com.mindhub.overflow.models.TagQuestions;

public class TagQuestionsQDTO {

    private Long id;
    private Question question;


    public TagQuestionsQDTO() {
    }

    public TagQuestionsQDTO(TagQuestions tagQuestions) {
        this.id = tagQuestions.getId();
        this.question = tagQuestions.getQuestion();
    }

    public Long getId() {
        return id;
    }

    public Question getQuestion() {
        return question;
    }

}
