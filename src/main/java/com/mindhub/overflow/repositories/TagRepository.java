package com.mindhub.overflow.repositories;

import com.mindhub.overflow.models.Tag;
import com.mindhub.overflow.models.TagQuestions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface TagRepository extends JpaRepository<Tag, Long> {

    Optional<Tag> findBySubject(String subject);
}
