package com.example.demo.repository;

import com.example.demo.entity.PostEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends CrudRepository<PostEntity, Long> {
}
