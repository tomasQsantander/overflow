package com.mindhub.overflow.services;

import com.mindhub.overflow.dtos.QuestionDTO;
import com.mindhub.overflow.dtos.TagDTO;
import com.mindhub.overflow.dtos.TagQuestionsDTO;
import com.mindhub.overflow.models.Tag;
import com.mindhub.overflow.models.TagQuestions;
import com.mindhub.overflow.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TagService {

    @Autowired
    TagRepository tagRepository;

    public Set<TagDTO> getTags (){
        return tagRepository.findAll().stream().map(TagDTO::new).collect(Collectors.toSet());
    }
    //Retorno una lista de taqQuestionDTO
    public List<QuestionDTO> getQuestionByTagSubject(String subject){
        Tag tag = tagRepository.findBySubject(subject).orElse(null);
        return tag.getTagQuestions().stream().map( tagQuestions -> new QuestionDTO(tagQuestions.getQuestion())).collect(Collectors.toList());
    }
}
