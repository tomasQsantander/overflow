package com.mindhub.overflow.controllers;

import com.mindhub.overflow.dtos.UsuarioDTO;
import com.mindhub.overflow.services.UsuarioService;
import com.mindhub.overflow.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@RestController
@Validated
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private MessageSource messages;

    @GetMapping(value = "/current")
    public UsuarioDTO getCurrentUser(HttpSession session){
        return usuarioService.getCurrentUser(session);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<Object> logIn(@RequestParam @NotBlank @Email String email, HttpSession session){
        ResponseUtils res = usuarioService.logIn(email, session);

        if (res.getDone()){
            return new ResponseEntity<>(
                    messages.getMessage(res.getMessage(), null, LocaleContextHolder.getLocale()),
                    HttpStatus.valueOf(res.getStatusCode()));
        }

        return new ResponseEntity<>(
                messages.getMessage(res.getMessage(), (Object[]) res.getArgs(), LocaleContextHolder.getLocale()),
                HttpStatus.valueOf(res.getStatusCode()));
    }

    @PostMapping(value = "/register")
    public ResponseEntity<Object> register(@RequestParam @NotBlank String name, @RequestParam @NotBlank String lastName,
                                           @RequestParam @NotBlank @Email String email, HttpSession session){

        ResponseUtils res = usuarioService.register(name, lastName, email, session);

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
