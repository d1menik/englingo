package com.app.web.controller;

import com.app.web.model.User;
import com.app.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String getHome(){
        return "home";
    }

    @GetMapping(value = "/login")
    public String getLoginForm(){
        return "login";
    }

    @PostMapping(value = "/login")
    public String login(@ModelAttribute(name="loginForm") User user, Model model){
        String prihlasJmeno = user.getJmeno();
        String heslo = user.getHeslo();

        if ("admin".equals(prihlasJmeno) && "admin".equals(heslo)) {
            return "home";
        }

        model.addAttribute("invalidCredentials", true);
        return "login";
    }

}
