package com.example.demo.service.impl;


import com.example.demo.converter.PostConverter;
import com.example.demo.entity.PostEntity;
import com.example.demo.model.PostModel;
import com.example.demo.repository.PostRepository;
import com.example.demo.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
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

    @Override
    public List<PostModel> getUserPosts(Long userId) {
        List<PostEntity> postEntities = postRepository.findByUserId(userId);
        List<PostModel>  postModels = new ArrayList<>();
        for (PostEntity postEntity: postEntities) {
            PostModel model = postConverter.convertPostEntityToModel(postEntity);
            postModels.add(model);
        }
        return postModels;
    }

    @Override
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }

    @Override
    public PostModel updatePost(PostModel model, Long postId) {
        Optional<PostEntity> entity = postRepository.findById(postId);
        PostModel postModel = new PostModel();
        if (entity.isPresent()) {

            PostEntity postEntity = entity.get();
            System.out.println(postEntity);

            postEntity.setContent(model.getContent());
            postEntity.setTitle(model.getTitle());
            postEntity.setDate(model.getDate());
            postEntity.setEdited(model.isEdited());
            postModel = postConverter.convertPostEntityToModel(postEntity);
            postRepository.save(postEntity);
        }
        return postModel;
    }
}
