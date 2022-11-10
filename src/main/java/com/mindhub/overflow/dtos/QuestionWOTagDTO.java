package com.mindhub.overflow.dtos;

import com.mindhub.overflow.models.Question;

import java.time.LocalDateTime;

public class QuestionWOTagDTO {

    private Long id;
    private String title;
    private String question;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public QuestionWOTagDTO() {
    }
    public QuestionWOTagDTO(Question question) {
        this.id = question.getId();
        this.title = question.getTitle();
        this.question = question.getQuestion();
        this.createdAt = question.getCreatedAt();
        this.updatedAt = question.getUpdatedAt();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getQuestion() {
        return question;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
