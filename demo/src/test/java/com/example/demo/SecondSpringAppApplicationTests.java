package com.example.demo;

import com.example.demo.converter.PostConverter;
import com.example.demo.entity.PostEntity;
import com.example.demo.repository.PostRepository;
import com.example.demo.service.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class SecondSpringAppApplicationTests {

	@Autowired
	private PostService postService;
	@Autowired
	private PostConverter postConverter;
	@Autowired
	private PostRepository postRepository;

	@Test
	void contextLoads() {
		System.out.println("tested");
	}

	@Test
	void testGetPostInDataBase() {
		long id = 2;
		Optional<PostEntity> postEntity = postRepository.findById(id);
		if (postEntity.isPresent()) {
			PostEntity post = postEntity.get();
			System.out.println(post);
		}
	}
}