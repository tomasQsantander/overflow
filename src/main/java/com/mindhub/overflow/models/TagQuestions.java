package com.mindhub.overflow.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class TagQuestions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tag_id")
    private Tag tag;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "question_id")
    private Question question;

    public TagQuestions(Tag tag, Question question) {
        this.tag = tag;
        this.question = question;
    }

    public TagQuestions() {
    }

    public Long getId() {
        return id;
    }


    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

}
