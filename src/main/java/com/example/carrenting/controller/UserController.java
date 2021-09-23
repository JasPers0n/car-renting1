package com.example.carrenting.controller;


import com.example.carrenting.entity.User;
import com.example.carrenting.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    private  UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }



    @GetMapping("/register")
    public String getRegisterForm(){
        return "user/register-form";
    }

    @PostMapping("/register")
    public String processRegistration(@ModelAttribute User user){
        userService.encodePassword(user);
        userService.save(user);
        return "user/register-result";

    }

}
