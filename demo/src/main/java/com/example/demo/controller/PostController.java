package com.example.demo.controller;


import com.example.demo.model.PostModel;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class PostController {
    @Autowired
    private PostService postService;


    @PostMapping("post")
    public ResponseEntity<PostModel> createPost(@RequestBody PostModel postModel) {
        postModel = postService.createPost(postModel);
        return new ResponseEntity<>(postModel, HttpStatus.CREATED);
    }

    @GetMapping("posts")
    public ResponseEntity<List<PostModel>> getAllPosts() {
        List<PostModel> posts = postService.getAllPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }


    @GetMapping("pages")
    public ResponseEntity<Page<PostModel>> getPosts(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "10") int size)
    {
        Page<PostModel> posts = postService.getGroupOfPosts(size, page);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("post/user/{userId}")
    public ResponseEntity<List<PostModel>> getUserPosts(@PathVariable Long userId) {
        List<PostModel> posts = postService.getUserPosts(userId);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @DeleteMapping("post/{postId}")
    public ResponseEntity<PostModel> deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @PutMapping("post/{postId}")
    public ResponseEntity<PostModel> updatePost(@RequestBody PostModel postModel ,@PathVariable Long postId) {
        postModel = postService.updatePost(postModel, postId);
        if (postModel == null) {
            return new ResponseEntity<>(postModel, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(postModel, HttpStatus.OK);
    }
}
