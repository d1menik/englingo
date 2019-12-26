package com.app.web.controller;

import com.app.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public String getUsers(Model model){
        model.addAttribute("users", userService.findAll());
        return "user";
    }

}
