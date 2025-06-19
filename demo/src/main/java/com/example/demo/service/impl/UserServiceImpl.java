package com.example.demo.service.impl;

import com.example.demo.converter.UserConverter;
import com.example.demo.entity.UserEntity;
import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserConverter userConverter;
    @Autowired
    private PasswordEncoder passwordEncoder;

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
}
