package com.example.demo.service.impl;

import com.example.demo.converter.UserConverter;
import com.example.demo.entity.UserEntity;
import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserConverter userConverter;

    @Override
    public UserModel register(UserModel userModel) {
        UserEntity user = userConverter.convertUserModelToEntity(userModel);
        user = userRepository.save(user);
        userModel = userConverter.convertUserEntityTOModel(user);
        return userModel;
    }

    @Override
    public UserModel login(String email, String password) {
        return null;
    }
}
