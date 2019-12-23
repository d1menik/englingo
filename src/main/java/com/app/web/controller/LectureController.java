package com.app.web.controller;

import com.app.web.model.User;
import com.app.web.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RestController
public class LectureController {

    @Autowired
    private LectureService lectureService;

    @PostMapping(value = "/lecture")
    public ModelAndView getLoginForm(@Valid User loginForm, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("loginForm", loginForm);
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("login");
        } else {
            modelAndView.setViewName("lecture");

        }
        return modelAndView;
    }

    @GetMapping(value = "/lecture")
    public ModelAndView getLecture(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("lecture");
        return modelAndView;
    }

}
