package com.example.controller;

import com.example.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/mentor")
public class MentorController {
    //localhost:8080/register
    @GetMapping("/register")  //localhost:8080/mentor/register
    public String register(Model model){

        List<String> batchList = Arrays.asList("JD1","JD2","JD3");

        model.addAttribute("mentor",new Mentor());
        model.addAttribute("batchList",batchList);

        return "mentor/mentor-register";
    }
}
