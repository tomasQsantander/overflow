package com.mindhub.overflow.controllers;

import com.mindhub.overflow.dtos.QuestionDTO;
import com.mindhub.overflow.models.Question;
import com.mindhub.overflow.repositories.QuestionRepository;
import com.mindhub.overflow.services.QuestionService;
import com.mindhub.overflow.utils.ResponseUtils;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotBlank;
import java.util.Objects;
import java.util.Set;

@RestController
@Validated
@RequestMapping("/api/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private MessageSource messages;


    @GetMapping(value = "")
    public Set<QuestionDTO> getQuestions (){
        return questionService.getQuestions();
    }

    @GetMapping(value = "/{id}")
    public QuestionDTO getQuestionById (@PathVariable Long id){
        return questionService.getQuestionById(id);
    }

    @PostMapping(value = "/new")
    public ResponseEntity<Object> addQuestion (@RequestParam @NotBlank String title, @RequestParam @NotBlank String question,
                                               @RequestParam @NotBlank String tags, HttpSession session){

        ResponseUtils res = questionService.addQuestion(title, question, tags, session);

        if (res.getDone()){
            return new ResponseEntity<>(
                    messages.getMessage(res.getMessage(), null, LocaleContextHolder.getLocale()),
                    HttpStatus.valueOf(res.getStatusCode()));
        }

        return new ResponseEntity<>(
                messages.getMessage(res.getMessage(), (Object[]) res.getArgs(), LocaleContextHolder.getLocale()),
                HttpStatus.valueOf(res.getStatusCode()));
    }



}
