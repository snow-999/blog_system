package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1")
public class HelloController {
    @GetMapping("/hello")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
