package com.mindhub.overflow.models;

import net.bytebuddy.asm.Advice;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    private String subject;

    @CreatedDate
    private LocalDate createdAt;

    @LastModifiedDate
    private LocalDate updatedAt;

    @OneToMany(mappedBy = "tag", fetch = FetchType.EAGER)
    private Set<TagQuestions> tagQuestions = new HashSet<>();

    public Tag(String subject) {
        this.subject = subject;
    }

    public Long getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Set<TagQuestions> getTagQuestions() {
        return tagQuestions;
    }

    public void setTagQuestions(Set<TagQuestions> tagQuestions) {
        this.tagQuestions = tagQuestions;
    }

    public void addQuestion(TagQuestions tq) {
        tq.setTag(this);
        tagQuestions.add(tq);
    }
}
