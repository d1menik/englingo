package com.app.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controller1 {

    @RequestMapping("/")
    public String actionHome() {
        return "hello";
    }

}
