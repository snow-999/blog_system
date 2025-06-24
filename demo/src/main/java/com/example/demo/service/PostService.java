package com.example.demo.service;

import com.example.demo.model.PostModel;

import java.util.List;

public interface PostService {
    PostModel createPost(PostModel postModel);

    List<PostModel> getAllPosts();
}
