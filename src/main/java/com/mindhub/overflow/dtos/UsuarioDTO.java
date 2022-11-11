package com.mindhub.overflow.dtos;

import com.mindhub.overflow.models.Answer;
import com.mindhub.overflow.models.Question;
import com.mindhub.overflow.models.Usuario;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class UsuarioDTO {

    private Long id;

    private String name;

    private String lastName;

    private String email;

    private Integer rankingPoint = 0;

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.name = usuario.getName();
        this.lastName = usuario.getLastName();
        this.email = usuario.getEmail();
        this.rankingPoint = usuario.getRankingPoint();
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
}
