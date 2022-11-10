package com.mindhub.overflow.models;

import net.bytebuddy.asm.Advice;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private String title;
    private String question;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "question", fetch = FetchType.EAGER)
    Set<TagQuestions> tagQuestionsSet = new HashSet<>();

    @OneToMany(mappedBy = "question", fetch = FetchType.EAGER)
    Set<Answer> answers = new HashSet<>();


    public Question(String title,String question) {
        this.title = title;
        this.question = question;
    }

    public Question() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Set<TagQuestions> getTagQuestionsSet() {
        return tagQuestionsSet;
    }

    public void setTagQuestionsSet(Set<TagQuestions> tagQuestionsSet) {
        this.tagQuestionsSet = tagQuestionsSet;
    }

    public void addTag(TagQuestions tq) {
        tq.setQuestion(this);
        tagQuestionsSet.add(tq);
    }

    public void addAnswer(Answer answer) {
        answer.setQuestion(this);
        answers.add(answer);
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }
}
