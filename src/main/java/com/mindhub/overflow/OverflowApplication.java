package com.mindhub.overflow;

import com.mindhub.overflow.dtos.TagDTO;
import com.mindhub.overflow.dtos.TagQuestionsQDTO;
import com.mindhub.overflow.models.Question;
import com.mindhub.overflow.models.Tag;
import com.mindhub.overflow.models.TagQuestions;
import com.mindhub.overflow.repositories.QuestionRepository;
import com.mindhub.overflow.repositories.TagQuestionsRepository;
import com.mindhub.overflow.repositories.TagRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Set;

@SpringBootApplication
public class OverflowApplication {

	public static void main(String[] args) {
		SpringApplication.run(OverflowApplication.class, args);
	}

}
