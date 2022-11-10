package com.mindhub.overflow;

import com.mindhub.overflow.models.Question;
import com.mindhub.overflow.models.Tag;
import com.mindhub.overflow.repositories.AnswersRepository;
import com.mindhub.overflow.repositories.QuestionRepository;
import com.mindhub.overflow.repositories.TagQuestionsRepository;
import com.mindhub.overflow.repositories.TagRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OverflowApplication {

	public static void main(String[] args) {
		SpringApplication.run(OverflowApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(AnswersRepository answersRepository, QuestionRepository questionRepository,
									  TagQuestionsRepository tagQuestionsRepository, TagRepository tagRepository
									  ) {
		return (args) -> {
			Question q1 = new Question("Java string", "Como se separa un string en Java?");
			Question q2 = new Question("Clases java", "Como crear una clase?");

			Tag t1 = new Tag("programacion");

			tagRepository.save(t1);
			questionRepository.save(q1);
			questionRepository.save(q2);
		};
	}

}
