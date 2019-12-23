package com.app.web.controller;

import com.app.web.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LectureController {

    @Autowired
    private LectureService lectureService;

    @GetMapping(value = "/lecture")
    public ModelAndView getLoginForm(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("lecture");
        return modelAndView;
    }

}
