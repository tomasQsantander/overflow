package com.mindhub.overflow.dtos;

import com.mindhub.overflow.models.Question;
import com.mindhub.overflow.models.TagQuestions;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class QuestionDTO {

    private Long id;
    private String title;
    private String question;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Set<TagQuestionsTDTO> tags = new HashSet<>();

    public QuestionDTO() {
    }

    public QuestionDTO(Question question) {
        this.id = question.getId();
        this.title = question.getTitle();
        this.question = question.getQuestion();
        this.createdAt = question.getCreatedAt();
        this.updatedAt = question.getUpdatedAt();
        this.tags = question.getTagQuestionsSet().stream().map(tags -> new TagQuestionsTDTO(new TagQuestions(tags.getTag(),question))).collect(Collectors.toSet());
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

    public Set<TagQuestionsTDTO> getTags() {
        return tags;
    }
}
