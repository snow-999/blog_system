package com.example.demo.controller;


import com.example.demo.entity.PostEntity;
import com.example.demo.model.PostModel;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
public class PostController {
    @Autowired
    private PostService postService;


    @PostMapping("addpost")
    public ResponseEntity<PostModel> createPost(@RequestBody PostModel postModel) {
        postModel = postService.createPost(postModel);
        return new ResponseEntity<>(postModel, HttpStatus.CREATED);
    }
}
