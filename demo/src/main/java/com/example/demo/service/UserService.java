package com.example.demo.service;

import com.example.demo.model.UserModel;

public interface UserService {
    UserModel register(UserModel userModel);
    UserModel login(UserModel userModel) throws Exception;
    String verify(UserModel userModel);

}
