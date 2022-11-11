package com.mindhub.overflow.repositories;

import com.mindhub.overflow.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface UsuarioRespository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}
