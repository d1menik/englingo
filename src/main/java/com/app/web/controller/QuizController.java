package com.app.web.controller;

import com.app.web.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuizController {

    @Autowired
    private QuizService quizService;

}
