package com.mindhub.overflow.services;

import com.mindhub.overflow.models.Tag;
import com.mindhub.overflow.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TagService {

    @Autowired
    TagRepository tagRepository;

    public Set<Tag> getTags (){
        return tagRepository.findAll().stream().collect(Collectors.toSet());
    }
}
