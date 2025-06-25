package com.example.demo.service.impl;


import com.example.demo.converter.PostConverter;
import com.example.demo.entity.PostEntity;
import com.example.demo.model.PostModel;
import com.example.demo.repository.PostRepository;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<PostModel> getAllPosts() {
        List<PostEntity> postEntities = (List<PostEntity>) postRepository.findAll();
        List<PostModel>  postModels = new ArrayList<>();
        for (PostEntity postEntity : postEntities) {
            PostModel model = postConverter.convertPostEntityToModel(postEntity);
            postModels.add(model);
        }
        return postModels;
    }
}
