package com.app.web.controller;

import com.app.web.model.User;
import com.app.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public ModelAndView getHome(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @GetMapping(value = "/login")
    public ModelAndView getLogin(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @GetMapping(value = "/registration")
    public ModelAndView getRegForm(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @PostMapping(value="/registration")
    public ModelAndView addAStudent(@Valid User user, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView();
        Optional<User> userExists = userService.findUserByName(user.getUsername());
        if (userExists.isPresent()) {
            bindingResult
                    .rejectValue("username", "error.user",
                            "Existuje už uživatel se stejným uživatelským jménem");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("error-registration");
        } else {
            userService.save(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

}
