package com.mindhub.overflow.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    private String name;

    private String lastName;

    private String email;

    private Integer rankingPoint = 0;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
    private Set<Question> questions = new HashSet<>();

    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
    private Set<Answer> answers = new HashSet<>();

    public Usuario(String name, String lastName, String email) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }

    public Usuario() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Integer getRankingPoint() {
        return rankingPoint;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void addQuestions(Question question) {
       question.setUsuario(this);
       questions.add(question);
    }

    public void addAnswers(Answer answer) {
        answer.setUsuario(this);
        answers.add(answer);
    }

    public Set<Answer> getAnswers() {
        return answers;
    }
}
