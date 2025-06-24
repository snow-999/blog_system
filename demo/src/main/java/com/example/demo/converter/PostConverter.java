package com.example.demo.converter;

import com.example.demo.entity.PostEntity;
import com.example.demo.model.PostModel;
import org.springframework.stereotype.Component;

@Component
public class PostConverter {
    public PostEntity convertPostModelToEntity(PostModel postModel) {
        PostEntity post = new PostEntity();
        post.setPostId(postModel.getPostId());
        post.setDate(postModel.getDate());
        post.setTitle(postModel.getTitle());
        post.setEdited(postModel.isEdited());
        post.setContent(postModel.getContent());
        post.setUserId(postModel.getUserId());
        return post;
    }

    public PostModel convertPostEntityToModel(PostEntity postEntity) {
        PostModel post = new PostModel();
        post.setPostId(postEntity.getPostId());
        post.setDate(postEntity.getDate());
        post.setTitle(postEntity.getTitle());
        post.setEdited(postEntity.isEdited());
        post.setContent(postEntity.getContent());
        post.setUserId(postEntity.getUserId());
        return post;
    }
}
