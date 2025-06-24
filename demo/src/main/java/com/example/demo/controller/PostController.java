package com.example.demo.controller;


import com.example.demo.model.PostModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
public class PostController {
    @PostMapping("addpost")
    public PostModel createPost(@RequestBody PostModel postModel) {
        return postModel;
    }
}
