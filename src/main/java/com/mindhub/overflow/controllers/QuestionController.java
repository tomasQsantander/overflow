package com.mindhub.overflow.controllers;

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
    public Set<Question> getQuestions (){
        return questionService.getQuestions();
    }

    @PostMapping(value = "/new")
    public ResponseEntity<Object> addQuestion (@RequestParam @NotBlank String question, @RequestParam @NotBlank String tags){
        ResponseUtils res = questionService.addQuestion(question, tags);

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
