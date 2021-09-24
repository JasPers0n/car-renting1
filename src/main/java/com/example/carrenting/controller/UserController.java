package com.example.carrenting.controller;


import com.example.carrenting.entity.Car;
import com.example.carrenting.entity.User;
import com.example.carrenting.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/register")
    public String getRegisterForm(@ModelAttribute("user") User user) {
        return "user/register-form";
    }

    @PostMapping("/register")
    public String processRegistration(@Validated @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/user/register-form";
        } else {
            userService.encodePassword(user);
            userService.save(user);
            return "user/register-result";

        }

    }
}
