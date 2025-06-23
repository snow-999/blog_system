package com.example.demo.service;

import com.example.demo.model.UserModel;
import jakarta.servlet.http.HttpServletResponse;

public interface UserService {
    UserModel register(UserModel userModel);
    UserModel login(UserModel userModel) throws Exception;
    String verify(UserModel userModel, HttpServletResponse response);

}
