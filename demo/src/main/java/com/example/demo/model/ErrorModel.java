package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class ErrorModel {
    @Getter
    @Setter
    private String errorMsg;
}
