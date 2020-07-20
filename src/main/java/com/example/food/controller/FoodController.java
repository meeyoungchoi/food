package com.example.food.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FoodController {

    @GetMapping("/")
    public String hello() {
        return "hello";
    }

}
