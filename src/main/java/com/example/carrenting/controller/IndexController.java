package com.example.carrenting.controller;


import com.example.carrenting.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/start")
public class IndexController {

    private EmployeeService employeeService;

    @RequestMapping("/index") //wchodzimy przez ten adres ->  http://localhost:8080/index
    public String main() {
        return "start/index";
    }

    @RequestMapping("/about")
    public String about() {
        return "/start/about";
    }

}
