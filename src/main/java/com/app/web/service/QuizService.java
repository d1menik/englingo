package com.app.web.service;

import com.app.web.model.Quiz;

import java.util.List;

public interface QuizService {

    List<Quiz> findAll();

    void delete(Quiz quiz);

    Quiz getOne(Integer id);

    Quiz save(Quiz quiz);

}
