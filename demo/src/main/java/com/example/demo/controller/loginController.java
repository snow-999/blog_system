package com.example.demo.controller;

import com.example.demo.converter.UserConverter;
import com.example.demo.entity.UserEntity;
import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class loginController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    protected UserConverter userConverter;

    @PostMapping("login")
    public UserModel login(@RequestBody UserModel userModel) {
        UserEntity user = userConverter.convertUserModelToEntity(userModel);
        user = userRepository.save(user);
        userModel = userConverter.convertUserEntityTOModel(user);
        return userModel;
    }
}