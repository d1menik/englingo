package com.app.web.service;

import com.app.web.model.Question;

import java.util.List;

public interface QuestionService {

    List<Question> findAll();

    List<Question> findQuestionsByLecture_Id(Integer id);

    void delete(Question question);

    Question getOne(Integer id);

    Question save(Question question);

}
