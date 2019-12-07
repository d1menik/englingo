package com.app.web.service;

import com.app.web.model.Quiz;
import com.app.web.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    public List<Quiz> findAll(){
        return quizRepository.findAll();
    }

    public void delete(Quiz quiz){
        quizRepository.delete(quiz);
    }

    public Quiz getOne(Integer id){
        return quizRepository.getOne(id);
    }

    public Quiz save(Quiz quiz){
        return quizRepository.save(quiz);
    }

}
