package com.mindhub.overflow.dtos;

import com.mindhub.overflow.models.Tag;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TagWOQuestionDTO {

    private Long id;
    private String subject;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    public TagWOQuestionDTO() {
    }

    public TagWOQuestionDTO(Tag tag) {
        this.id = tag.getId();
        this.subject = tag.getSubject();
        this.createdAt = tag.getCreatedAt();
        this.updatedAt = tag.getUpdatedAt();
    }

    public String getSubject() {
        return subject;
    }

}
