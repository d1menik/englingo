package com.app.web.controller;

import com.app.web.model.Lecture;
import com.app.web.model.User;
import com.app.web.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class LectureController {

    @Autowired
    private LectureService lectureService;

    @PostMapping(value = "/lectures")
    public ModelAndView getLoginForm(@Valid User loginForm, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("loginForm", loginForm);
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("login");
        } else {
            modelAndView.setViewName("lecture");

        }
        return modelAndView;
    }

    @RequestMapping(value = "/lectures")
    public String getLecture(Model model) {
        model.addAttribute("lectures", lectureService.findAll());
        return "lecture";
    }

}
