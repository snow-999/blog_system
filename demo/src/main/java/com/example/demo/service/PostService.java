package com.example.demo.service;

import com.example.demo.model.PostModel;
import org.springframework.data.domain.Page;
import java.util.List;

public interface PostService {
    PostModel createPost(PostModel postModel);
    List<PostModel> getAllPosts();
    Page<PostModel> getGroupOfPosts(int size, int page);
    List<PostModel> getUserPosts(Long userId);
    void deletePost(Long postId);
    PostModel updatePost(PostModel model, Long postId);
}
