package com.example.demo.control_adviser;

import com.example.demo.exceptions.PageNotFoundException;
import com.example.demo.exceptions.PostNotFoundException;
import com.example.demo.model.ErrorModel;
import org.hibernate.query.sqm.tree.expression.SqmHqlNumericLiteral;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControlAdviser {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorModel> handleIllegalArgumentException(IllegalArgumentException ex) {
        ErrorModel errorModel = new ErrorModel(ex.getMessage());
        return new ResponseEntity<>(errorModel ,  HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<ErrorModel> handlePostNotFoundException(PostNotFoundException ex) {
        ErrorModel errorModel = new ErrorModel(ex.getMessage());
        return new ResponseEntity<>( errorModel,  HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PageNotFoundException.class)
    public ResponseEntity<ErrorModel> handlePageNotFoundException(PageNotFoundException ex) {
        ErrorModel errorModel = new ErrorModel(ex.getMessage());
        return new ResponseEntity<>( errorModel,  HttpStatus.NOT_FOUND);
    }
}