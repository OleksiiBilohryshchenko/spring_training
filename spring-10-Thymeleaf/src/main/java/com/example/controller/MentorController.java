package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/mentor")
public class MentorController {
    //localhost:8080/register
    @RequestMapping("/register")
    public String register(){
        return "student/register";
    }
}
