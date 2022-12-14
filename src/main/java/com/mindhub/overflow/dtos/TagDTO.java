package com.mindhub.overflow.dtos;

import com.mindhub.overflow.models.Tag;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class TagDTO {

    private Long id;
    private String subject;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private List<QuestionWOTagDTO> questions = new ArrayList<>();

    public TagDTO() {
    }

    public TagDTO(Tag tag) {
        this.id = tag.getId();
        this.subject = tag.getSubject();
        this.createdAt = tag.getCreatedAt();
        this.updatedAt = tag.getUpdatedAt();
        this.questions = tag.getTagQuestions().stream().map( tagQuestions ->  new QuestionWOTagDTO( tagQuestions.getQuestion())).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }
    public String getSubject() {
        return subject;
    }
    public LocalDate getCreatedAt() {
        return createdAt;
    }
    public LocalDate getUpdatedAt() {
        return updatedAt;
    }
    public List<QuestionWOTagDTO> getQuestions() {
        return questions;
    }

}
