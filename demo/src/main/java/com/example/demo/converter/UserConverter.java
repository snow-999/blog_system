package com.example.demo.converter;

import com.example.demo.entity.UserEntity;
import com.example.demo.model.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserEntity convertUserModelToEntity(UserModel userModel) {
        UserEntity user = new UserEntity();
        user.setUserName(userModel.getUserName());
        user.setEmail(userModel.getEmail());
        user.setPassword(userModel.getPassword());
        user.setId(userModel.getId());
        return user;
    }
    
    public UserModel convertUserEntityTOModel(UserEntity userEntity) {
        UserModel model = new UserModel();
        model.setEmail(userEntity.getEmail());
        model.setUserName(userEntity.getUserName());
        model.setPassword(userEntity.getPassword());
        model.setId(userEntity.getId());
        return model;
    }
}
