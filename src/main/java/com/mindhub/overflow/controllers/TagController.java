package com.mindhub.overflow.controllers;

import com.mindhub.overflow.dtos.QuestionDTO;
import com.mindhub.overflow.dtos.TagDTO;
import com.mindhub.overflow.models.Tag;
import com.mindhub.overflow.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tag")
public class TagController {

    @Autowired
    TagService tagService;

    @GetMapping(value = "")
    public Set<TagDTO> getTags (){
        return tagService.getTags();
    }

    @GetMapping(value = "/{subject}")
    public List<QuestionDTO> getQuestionByTagSubject(@PathVariable String subject){
        return tagService.getQuestionByTagSubject(subject);
    }

}
