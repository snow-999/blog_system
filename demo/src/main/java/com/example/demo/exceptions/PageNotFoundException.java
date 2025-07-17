package com.example.demo.exceptions;

public class PageNotFoundException extends RuntimeException{
    public PageNotFoundException(String msg) {
        super(msg);
    }
}
