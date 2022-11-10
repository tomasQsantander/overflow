package com.mindhub.overflow;

import com.mindhub.overflow.models.Answer;
import com.mindhub.overflow.models.Question;
import com.mindhub.overflow.models.Tag;
import com.mindhub.overflow.models.TagQuestions;
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
			Tag t2 = new Tag("java");
			TagQuestions tq = new TagQuestions(t1,q1);
			TagQuestions tq2 = new TagQuestions(t1,q2);
			TagQuestions tq3 = new TagQuestions(t2,q2);
			Answer a = new Answer("Se hace de esta manera");


			questionRepository.save(q1);
			questionRepository.save(q2);
			q1.addAnswer(a);
			answersRepository.save(a);
			tagRepository.save(t1);
			tagRepository.save(t2);

			tagQuestionsRepository.save(tq);
			tagQuestionsRepository.save(tq2);
			tagQuestionsRepository.save(tq3);

		};
	}

}
