package com.example.demo.controller;

import com.example.demo.converter.UserConverter;
import com.example.demo.entity.UserEntity;
import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class signupController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("signup")
    public ResponseEntity<UserModel> register(@RequestBody UserModel userModel) {
        userModel = userService.register(userModel);
        return new ResponseEntity<>(userModel, HttpStatus.CREATED);
    }




}
