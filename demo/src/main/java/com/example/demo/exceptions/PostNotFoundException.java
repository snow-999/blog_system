package com.example.demo.exceptions;

public class PostNotFoundException extends RuntimeException{
    public PostNotFoundException(String msg) {
        super(msg);
    }
}
