package com.example.demo.service.impl;

import com.example.demo.converter.UserConverter;
import com.example.demo.entity.UserEntity;
import com.example.demo.model.LogInToken;
import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.JWTService;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseCookie;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {
    public static final int DAYS = 24;
    public static final int HOURS = 60;
    public static final int MINUTS = 60;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private JWTService jwtService;


    @Override
    public UserModel register(UserModel userModel) {
        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
        UserEntity user = userConverter.convertUserModelToEntity(userModel);
        user = userRepository.save(user);
        userModel = userConverter.convertUserEntityTOModel(user);
        return userModel;
    }

    @Override
    public UserModel login(UserModel userModel) throws Exception {
        UserModel model = new UserModel();
        Optional<UserEntity> user = userRepository.findByEmail(userModel.getEmail());
        if (user.isPresent()) {
            model = userConverter.convertUserEntityTOModel(user.get());
            if (passwordEncoder.matches(userModel.getPassword(), model.getPassword())) {
                return model;
            }
        } else {
            throw new Exception("user not found");
        }
        return null;
    }

    @Override
    public LogInToken verify(UserModel userModel, HttpServletResponse response) {
        Authentication authentication = manager.authenticate(new UsernamePasswordAuthenticationToken(userModel.getUserName(), userModel.getPassword()));
        if (authentication.isAuthenticated()) {
            LogInToken token = new LogInToken();
            token.setToken(jwtService.generateToken(userModel.getUserName()));
            jwtService.addJwtToCookie(token.getToken(),response);
            return token;
        }
        return null;
    }
}
