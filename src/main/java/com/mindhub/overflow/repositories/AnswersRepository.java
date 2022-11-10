package com.mindhub.overflow.repositories;

import com.mindhub.overflow.models.Answers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AnswersRepository extends JpaRepository<Answers, Long> {
}
