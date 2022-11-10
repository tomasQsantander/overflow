package com.mindhub.overflow.dtos;

import com.mindhub.overflow.models.Tag;
import com.mindhub.overflow.models.TagQuestions;

public class TagQuestionsTDTO {

    private Long id;
    private Tag tag;

    public TagQuestionsTDTO() {
    }

    public TagQuestionsTDTO(TagQuestions tagQuestions) {
        this.id = tagQuestions.getId();
        this.tag = tagQuestions.getTag();
    }

    public Long getId() {
        return id;
    }


    public Tag getTag() {
        return tag;
    }
}
