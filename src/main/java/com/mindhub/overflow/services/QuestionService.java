package com.mindhub.overflow.services;

import com.mindhub.overflow.models.Question;
import com.mindhub.overflow.repositories.QuestionRepository;
import com.mindhub.overflow.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class QuestionService {

    private static final Integer MAX_TAGS = 3;

    @Autowired
    private QuestionRepository questionRepository;


    public Set<Question> getQuestions() {
        return questionRepository.findAll().stream().collect(Collectors.toSet());
    }

    public ResponseUtils addQuestion(String question, String tags) {
        ResponseUtils responseUtils = validateQuestion(question, tags);
        if(!responseUtils.getDone()){
            return responseUtils;
        }



        //agregar
        return responseUtils;
    }

    private ResponseUtils validateQuestion(String question, String tags){
        ResponseUtils responseUtils = new ResponseUtils(true, 200, "question.validation.success");


//        String comma = "ejemplo,tomas";
//        String[] commaAray = comma.split(",");
        String[] tagsArray = tags.split(",");


        if (tagsArray.length > MAX_TAGS){
            return new ResponseUtils(false, 400, "question.validation.failure.maxTags",
                    new String[]{String.valueOf(MAX_TAGS)});
        }



        return responseUtils;
    }
}
