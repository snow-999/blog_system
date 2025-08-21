package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Setter
@Getter
@Entity(name = "posts")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long postId;
    private long userId;
    private boolean isEdited;
    private String content;
    private String title;
    private Date date;

    @Override
    public String toString() {
        return "id: %d title: %s content: %s date: %s post made by user who his id is: %d".formatted(getPostId(), getTitle(), getContent(), getDate(), getUserId());
    }
}
