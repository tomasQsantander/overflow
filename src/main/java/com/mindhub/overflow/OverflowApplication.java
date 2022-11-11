package com.mindhub.overflow;

import com.mindhub.overflow.models.*;
import com.mindhub.overflow.repositories.*;
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
									  TagQuestionsRepository tagQuestionsRepository, TagRepository tagRepository,
									  UsuarioRespository usuarioRespository
									  ) {
		return (args) -> {
			Question q1 = new Question("Java string", "Como se separa un string en Java?");
			Question q2 = new Question("Clases java", "Como crear una clase?");
			Tag t1 = new Tag("programacion");
			Tag t2 = new Tag("java");
			TagQuestions tq = new TagQuestions(t1,q1);
			TagQuestions tq2 = new TagQuestions(t1,q2);
			TagQuestions tq3 = new TagQuestions(t2,q2);
			Answer a1 = new Answer("Se hace de esta manera");

			Usuario usuario = new Usuario("tomas", "quinteros", "mail@gmail.com");
			usuario.addQuestions(q1);
			usuario.addQuestions(q2);
			usuario.addAnswers(a1);

			usuarioRespository.save(usuario);
			questionRepository.save(q1);
			questionRepository.save(q2);
			q1.addAnswer(a1);
			answersRepository.save(a1);
			tagRepository.save(t1);
			tagRepository.save(t2);

			tagQuestionsRepository.save(tq);
			tagQuestionsRepository.save(tq2);
			tagQuestionsRepository.save(tq3);



		};
	}

}
