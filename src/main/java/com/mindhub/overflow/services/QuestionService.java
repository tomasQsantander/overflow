package com.mindhub.overflow.services;

import com.mindhub.overflow.dtos.QuestionDTO;
import com.mindhub.overflow.models.Question;
import com.mindhub.overflow.models.Tag;
import com.mindhub.overflow.models.TagQuestions;
import com.mindhub.overflow.repositories.QuestionRepository;
import com.mindhub.overflow.repositories.TagQuestionsRepository;
import com.mindhub.overflow.repositories.TagRepository;
import com.mindhub.overflow.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class QuestionService {

    private static final Integer MAX_TAGS = 3;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private TagQuestionsRepository tagQuestionsRepository;

    private String[] tagsArray;


    public Set<QuestionDTO> getQuestions() {
        return questionRepository.findAll().stream().map(QuestionDTO::new).collect(Collectors.toSet());
                //.stream().sorted(Comparator.comparing(QuestionDTO::getCreatedAt)).collect(Collectors.toSet());
    }

    public QuestionDTO getQuestionById (Long id){
        return questionRepository.findById(id).map(QuestionDTO::new).orElse(null);
    }

    public ResponseUtils addQuestion(String title, String question, String tags) {
        ResponseUtils responseUtils = validateQuestion(title, question, tags);
        if(!responseUtils.getDone()){
            return responseUtils;
        }

        Set<Tag> tagSet = new HashSet<>();

        //Creo el tag o lo traigo del repositorio
        for (int i=0; i<tagsArray.length; i++) {
            Tag tag = tagRepository.findBySubject(tagsArray[i]).orElse(null);
            if (tag == null){
                tag = new Tag(tagsArray[i]);
                tagRepository.save(tag);
            }
            tagSet.add(tag);
        }


        Question newQuestion = new Question(title, question);
        questionRepository.save(newQuestion);

        for (Tag t : tagSet){
            TagQuestions tagQuestions = new TagQuestions(t, newQuestion);
            //newQuestion.addTag(tagQuestions);
            tagQuestionsRepository.save(tagQuestions);
        }

        //agregar
        return responseUtils;
    }

    private ResponseUtils validateQuestion(String title, String question, String tags){
        ResponseUtils responseUtils = new ResponseUtils(true, 200, "question.validation.success");

        tagsArray = tags.split(",");

        if (tagsArray.length > MAX_TAGS){
            return new ResponseUtils(false, 400, "question.validation.failure.maxTags",
                    new String[]{String.valueOf(MAX_TAGS)});
        }

        return responseUtils;
    }
}
