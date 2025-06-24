package com.example.demo.repository;

import com.example.demo.entity.PostEntity;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<PostEntity, Long> {
}
