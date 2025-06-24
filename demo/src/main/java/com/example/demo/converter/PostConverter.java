package com.example.demo.converter;

import com.example.demo.entity.PostEntity;
import com.example.demo.model.PostModel;
import org.springframework.stereotype.Component;

@Component
public class PostConverter {
    public PostEntity convertPostModelToEntity(PostModel postModel) {
        PostEntity post = new PostEntity();
        return post;
    }

    public PostModel convertPostEntityToModel(PostEntity postEntity) {
        PostModel post = new PostModel();
        return post;
    }
}
