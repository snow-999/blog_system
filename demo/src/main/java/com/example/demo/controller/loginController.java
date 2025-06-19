package com.example.demo.controller;

import com.example.demo.converter.UserConverter;
import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class loginController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;
    @Autowired
    private UserService userService;


    @PostMapping("login")
    public ResponseEntity<UserModel> login(@RequestBody UserModel userModel) throws Exception {
        userModel = userService.login(userModel);
        return new ResponseEntity<>(userModel, HttpStatus.OK);
    }
}