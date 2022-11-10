package com.mindhub.overflow.dtos;

import com.mindhub.overflow.models.Tag;
import com.mindhub.overflow.models.TagQuestions;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class TagDTO {

    private Long id;
    private String subject;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private Set<TagQuestionsQDTO> questions = new HashSet<>();

    public TagDTO() {
    }

    public TagDTO(Tag tag) {
        this.id = tag.getId();
        this.subject = tag.getSubject();
        this.createdAt = tag.getCreatedAt();
        this.updatedAt = tag.getUpdatedAt();
        this.questions = tag.getTagQuestions().stream().map( questions -> new TagQuestionsQDTO( new TagQuestions( tag,questions.getQuestion()) )).collect(Collectors.toSet());
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
    public Set<TagQuestionsQDTO> getQuestions() {
        return questions;
    }

}
