package com.app.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controller1 {

    @RequestMapping("/")
    public String actionHome() {
        return "home";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

}
