package com.app.web.service;

import com.app.web.model.Question;
import com.app.web.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImp implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public List<Question> findQuestionsByLecture_Id(Integer id) {
        return questionRepository.findQuestionsByLecture_Id(id);
    }

    @Override
    public void delete(Question lecture) {

    }

    @Override
    public Question getOne(Integer id) {
        return null;
    }

    @Override
    public Question save(Question question) {
        return null;
    }

}
