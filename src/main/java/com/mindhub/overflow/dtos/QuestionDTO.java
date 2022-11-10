package com.mindhub.overflow.dtos;

import com.mindhub.overflow.models.Question;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QuestionDTO {

    private Long id;
    private String title;
    private String question;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<TagWOQuestionDTO> tags = new ArrayList<>();
    private List<AnswerDTO> answers = new ArrayList<>();

    public QuestionDTO() {
    }

    public QuestionDTO(Question question) {
        this.id = question.getId();
        this.title = question.getTitle();
        this.question = question.getQuestion();
        this.createdAt = question.getCreatedAt();
        this.updatedAt = question.getUpdatedAt();
        this.tags = question.getTagQuestionsSet().stream().map(tagQuestions -> new TagWOQuestionDTO(tagQuestions.getTag())).collect(Collectors.toList());
        this.answers = question.getAnswers().stream().map(AnswerDTO::new).collect(Collectors.toList());
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

    public List<TagWOQuestionDTO> getTags() {
        return tags;
    }

    public List<AnswerDTO> getAnswers() {
        return answers;
    }
}
