package com.example.controller;

import com.example.enums.Gender;
import com.example.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MentorController {
    @RequestMapping("/list")
    public String showTable(Model model){
        List<Mentor> mentorList = new ArrayList<>();
        mentorList.add(new Mentor("Mike","Smith",25, Gender.MALE));
        mentorList.add(new Mentor("Alex","Doe",35, Gender.MALE));
        mentorList.add(new Mentor("Mary","Jane",22, Gender.FEMALE));

        model.addAttribute("mentors",mentorList);
        return "mentor/mentor-list";
    }

}
