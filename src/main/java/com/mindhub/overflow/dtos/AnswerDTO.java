package com.mindhub.overflow.dtos;

import com.mindhub.overflow.models.Answer;
import com.mindhub.overflow.models.Question;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDateTime;

public class AnswerDTO {

    private Long id;
    private String text;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Integer votes;

    private UsuarioDTO usuario;
    public AnswerDTO() {
    }

    public AnswerDTO(Answer answer) {
        this.id = answer.getId();
        this.text = answer.getText();
        this.votes = answer.getVotes();
        this.createdAt = answer.getCreatedAt();
        this.updatedAt = answer.getUpdatedAt();
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public Integer getVotes() {
        return votes;
    }
}
