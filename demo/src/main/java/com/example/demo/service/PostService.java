package com.example.demo.service;

import com.example.demo.entity.PostEntity;
import com.example.demo.model.PostModel;

import java.util.List;
import java.util.Optional;

public interface PostService {
    PostModel createPost(PostModel postModel);
    List<PostModel> getAllPosts();
    List<PostModel> getUserPosts(Long userId);
    void deletePost(Long postId);
    PostModel updatePost(PostModel model, Long postId);
}
