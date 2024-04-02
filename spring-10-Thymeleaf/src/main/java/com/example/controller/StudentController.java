package com.example.controller;

import com.example.bootstrap.DataGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class StudentController {
    //localhost:8080/register
    @RequestMapping("/register")
    @GetMapping("/register")
    public String register(Model model){

        model.addAttribute("students", DataGenerator.createStudent());

        return "student/register";
    }

    //localhost:8080/student/welcome?name=Alex
    @RequestMapping("/welcome")
    @PostMapping("/welcome")
    public String welcome(){


        return "student/welcome";
    }


}
