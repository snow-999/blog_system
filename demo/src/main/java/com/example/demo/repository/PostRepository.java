package com.example.demo.repository;

import com.example.demo.entity.PostEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long>,CrudRepository<PostEntity, Long> {
    List<PostEntity> findByUserId(Long userId);
    List<PostEntity> findAllByOrderByPostIdAsc(Pageable pageable);
}
