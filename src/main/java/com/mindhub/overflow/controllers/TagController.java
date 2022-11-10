package com.mindhub.overflow.controllers;

import com.mindhub.overflow.dtos.QuestionDTO;
import com.mindhub.overflow.models.Tag;
import com.mindhub.overflow.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD

=======
import java.util.Set;
>>>>>>> b5e05bd49a7606fe519054981ff64c556dfa1b90

@RestController
@RequestMapping("/api/tag")
public class TagController {

<<<<<<< HEAD
=======
    @Autowired
    TagService tagService;

    @GetMapping(value = "")
    public Set<Tag> getTags (){
        return tagService.getTags();
    }
>>>>>>> b5e05bd49a7606fe519054981ff64c556dfa1b90
}
