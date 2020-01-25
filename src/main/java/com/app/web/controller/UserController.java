package com.app.web.controller;

import com.app.web.model.User;
import com.app.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public String getUsers(Model model){
        model.addAttribute("users", userService.findAll());
        return "/user/user";
    }

    @GetMapping(value = "/user/user-edit")
    public String getUsers(Model model, @RequestParam String id){
        model.addAttribute("user", userService.getOne(Integer.valueOf(id)));
        return "/user/user-edit";
    }

    @PostMapping(value = "/user/user-edit")
    public String editUser(User user, BindingResult bindingResult, Model model){
        User oldUser = userService.getOne(user.getIdUser());
        if (bindingResult.hasErrors()) {
            return "/error/error-registration";
        } else {
            user.setActive(oldUser.isActive());
            user.setRole(oldUser.getRole());
            userService.save(user);
            model.addAttribute("users", userService.findAll());
            return "/user/user";
        }
    }

    @GetMapping(value = "/user/user-delete")
    public String getUser(Model model, @RequestParam String id){
        model.addAttribute("user", userService.getOne(Integer.valueOf(id)));
        return "/user/user-delete";
    }

    @PostMapping(value = "/user/user-delete")
    public String deleteUser(User user, Model model, BindingResult bindingResult){
        User userFromDb = userService.getOne(user.getIdUser());
        if (bindingResult.hasErrors() || userFromDb.getRole().getIdRole() == 1) {
            return "/error/error-delete";
        } else {
            userService.delete(userFromDb);
            model.addAttribute("users", userService.findAll());
            return "/user/user";
        }
    }

}
