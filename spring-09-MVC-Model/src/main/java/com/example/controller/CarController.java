package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarController {
    // localhost:8080/info?make=Acura
    @RequestMapping("/info")
    public String carInfo(@RequestParam String make, Model model){

        model.addAttribute("make",make);

        return "car/car-info";
    }

    // localhost:8080/info2 (Acura default)
    @RequestMapping("/info2")
    public String carInfo2(@RequestParam(value="make",required = false,defaultValue = "Acura") String make, Model model){

        model.addAttribute("make",make);

        return "car/car-info";
    }

    // localhost:8080/info3?make=Acura&year=2016
    @RequestMapping("/info3")
    public String carInfo3(@RequestParam String make, @RequestParam int year, Model model){


        model.addAttribute("make",make);
        model.addAttribute("year",year);

        return "car/car-info";
    }

    // localhost:8080/info/Acura/2015
    @RequestMapping("/info/{make}/{year}")
    public String getCarInfo(@PathVariable String make, @PathVariable int year){
        System.out.println(make);
        System.out.println(year);
        // Acura
        return "car/car-info";
    }


}
