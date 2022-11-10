package com.mindhub.overflow.controllers;

import com.mindhub.overflow.services.AnswerService;
import com.mindhub.overflow.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/api/answer")
public class AnswerController {

    @Autowired
    AnswerService answerService;

    @Autowired
    private MessageSource messages;

    @PostMapping(value = "/new")
    public ResponseEntity<Object> addQuestion (@RequestParam @NotBlank String title, @RequestParam @NotBlank String question,
                                               @RequestParam @NotBlank String tags){

        ResponseUtils res = answerService.addAnswer(title, question, tags);

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
