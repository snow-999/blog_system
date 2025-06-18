package com.example.demo.controller;

import com.example.demo.model.UserModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class HomeController {
    @GetMapping("/")
    public ArrayList<UserModel> getUser() {
        UserModel model = new UserModel();
        model.setId(1);
        model.setUserName("khaled");
        model.setEmail("khalde");
        model.setPassword("1111");
        UserModel modelTwo = new UserModel();
        modelTwo.setId(2);
        modelTwo.setUserName("mohamde");
        modelTwo.setEmail("mohamed");
        modelTwo.setPassword("1111");
        return (ArrayList<UserModel>) List.of(
                model,
                modelTwo
        );
    }
}
