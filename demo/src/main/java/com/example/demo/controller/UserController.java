package com.example.demo.controller;

import com.example.demo.converter.UserConverter;
import com.example.demo.model.LogInToken;
import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@CrossOrigin("http://localhost:4200/")
public class UserController {

    @Autowired
    private UserService userService;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("signup")
    public ResponseEntity<UserModel> register(@RequestBody UserModel userModel) {
        userModel = userService.register(userModel);
        return new ResponseEntity<>(userModel, HttpStatus.CREATED);
    }

    @PostMapping("login")
    public LogInToken greatMe (@RequestBody UserModel userModel, HttpServletResponse response) {
            return userService.login(userModel, response);
    }
}