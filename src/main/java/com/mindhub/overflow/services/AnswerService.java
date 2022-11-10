package com.mindhub.overflow.services;

import com.mindhub.overflow.models.Question;
import com.mindhub.overflow.models.Tag;
import com.mindhub.overflow.models.TagQuestions;
import com.mindhub.overflow.repositories.AnswersRepository;
import com.mindhub.overflow.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AnswerService {

    @Autowired
    AnswersRepository answersRepository;

    public ResponseUtils addAnswer(String title, String question, String tags) {
        ResponseUtils responseUtils = validateAnswer(title, question, tags);
        if(!responseUtils.getDone()){
            return responseUtils;
        }



        //agregar
        return responseUtils;
    }

    private ResponseUtils validateAnswer(String title, String question, String tags){
        ResponseUtils responseUtils = new ResponseUtils(true, 200, "question.validation.success");


        return responseUtils;
    }


}
