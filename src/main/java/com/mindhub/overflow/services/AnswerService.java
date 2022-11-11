package com.mindhub.overflow.services;

import com.mindhub.overflow.models.*;
import com.mindhub.overflow.repositories.AnswersRepository;
import com.mindhub.overflow.repositories.QuestionRepository;
import com.mindhub.overflow.repositories.UsuarioRespository;
import com.mindhub.overflow.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;

@Service
public class AnswerService {

    @Autowired
    private AnswersRepository answersRepository;

    @Autowired
    private QuestionRepository questionRepository;
    
    @Autowired
    private UsuarioRespository usuarioRespository;

    private Question question;

    private Answer answer;

    private Integer voteTruncated;

    private Usuario usuario;

    public ResponseUtils addAnswer(Long questionId, String answer, HttpSession session) {
        ResponseUtils responseUtils = validateAnswer(questionId, session);
        if(!responseUtils.getDone()){
            return responseUtils;
        }

        Answer answer1 = new Answer(answer);
        question.addAnswer(answer1);
        answersRepository.save(answer1);
        questionRepository.save(question);
        
        usuario.addAnswers(answer1);
        usuario.addRankingPoint(1);
        usuarioRespository.save(usuario);

        return responseUtils;
    }

    private ResponseUtils validateAnswer(Long questionId, HttpSession session){
        ResponseUtils responseUtils = new ResponseUtils(true, 200, "answer.validation.success");

        question = questionRepository.findById(questionId).orElse(null);
        
        //La pregunta debe existir
        if (question == null){
            return new ResponseUtils(false, 400, "answer.validation.failure.questionMissing");
        }

        usuario = (Usuario) session.getAttribute("usuario");
        
        //EL usuario debe estar registrado en session
        if (usuario == null){
            return new ResponseUtils(false, 400, "answer.validation.failure.userMustLogin");
        }
        
        //El usuario no puede responder su propia pregunta
        if (question.getUsuario().getId().equals(usuario.getId())){
            return new ResponseUtils(false, 400, "answer.validation.failure.sameUser");
        }

        return responseUtils;
    }

    public ResponseUtils addVote (Long answerId, Integer vote) {
        ResponseUtils res = validateVote(answerId, vote);
        if(!res.getDone()){
            return res;
        }

        answer.addVote(voteTruncated);
        answersRepository.save(answer);

        return res;
    }

    private ResponseUtils validateVote(Long answerId, Integer vote){
        ResponseUtils responseUtils = new ResponseUtils(true, 200, "answer.vote.validation.success");

        answer = answersRepository.findById(answerId).orElse(null);
        if (answer == null){
            return new ResponseUtils(false, 400, "answer.validation.failure.answerMissing");
        }

        if (vote == 0){
            return new ResponseUtils(false, 400, "answer.vote.validation.failure.voteZero");
        }

        //Si se paso un voto mayor a 1 o menor a -1 se lleva a uno de los dos valores
        voteTruncated = vote;
        if (vote > 1){
            voteTruncated = 1;
        } else if (vote < -1){
            voteTruncated = -1;
        }

        return responseUtils;
    }


}
