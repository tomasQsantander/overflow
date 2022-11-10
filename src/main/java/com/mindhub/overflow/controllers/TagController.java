package com.mindhub.overflow.controllers;

import com.mindhub.overflow.dtos.QuestionDTO;
import com.mindhub.overflow.models.Tag;
import com.mindhub.overflow.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/tag")
public class TagController {

    @Autowired
    TagService tagService;

    @GetMapping(value = "")
    public Set<Tag> getTags (){
        return tagService.getTags();
    }
}
