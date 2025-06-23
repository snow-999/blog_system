package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserModel {
    private long id;
    private String userName;
    private String email;
    private String password;
}