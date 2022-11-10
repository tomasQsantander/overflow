package com.mindhub.overflow.dtos;
import com.mindhub.overflow.models.TagQuestions;

public class TagQuestionsDTO {

    private Long id;
    private TagDTO tag;
    private QuestionDTO question;

    public TagQuestionsDTO() {
    }

    public TagQuestionsDTO(TagQuestions tagQuestions) {
        this.id = tagQuestions.getId();
        this.tag = new TagDTO(tagQuestions.getTag());
        this.question = new QuestionDTO(tagQuestions.getQuestion());
    }

    public Long getId() {
        return id;
    }

    public TagDTO getTag() {
        return tag;
    }

    public QuestionDTO getQuestion() {
        return question;
    }
}
