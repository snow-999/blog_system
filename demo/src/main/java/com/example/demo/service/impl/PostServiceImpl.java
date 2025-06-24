package com.example.demo.service.impl;

import com.example.demo.controller.PostController;
import com.example.demo.converter.PostConverter;
import com.example.demo.entity.PostEntity;
import com.example.demo.model.PostModel;
import com.example.demo.repository.PostRepository;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostConverter postConverter;
    @Autowired
    private PostRepository postRepository;

    @Override
    public PostModel createPost(PostModel postModel) {
        PostEntity post = postConverter.convertPostModelToEntity(postModel);
        post = postRepository.save(post);
        postModel = postConverter.convertPostEntityToModel(post);
        return postModel;
    }
}
