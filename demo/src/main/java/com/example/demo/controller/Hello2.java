package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class Hello2 {
    @GetMapping("/ho")
    public String hi() {
        return "Hi";
    }
}
