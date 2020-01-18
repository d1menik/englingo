package com.app.web.controller;

import com.app.web.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {
    @Autowired
    private TestService testService;

    @RequestMapping(value = "/lectures/{id}/test/questions")
    public Model getQuestions(Model model) {
        model.addAttribute("lectures", testService.findAll());
        return model;
    }

}
