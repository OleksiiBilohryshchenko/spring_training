package com.example.controller;

import com.example.bootstrap.DataGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/student")
public class StudentController {
    //localhost:8080/register
    @RequestMapping("/register")
    public String register(Model model){

        model.addAttribute("students", DataGenerator.createStudent());

        return "student/register";
    }

    //localhost:8080/student/welcome
    @RequestMapping("/welcome")
    public String welcome(@RequestParam int id){

        System.out.println(id);
        return "student/welcome";
    }


}
