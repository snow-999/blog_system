package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Setter
@Getter
public class PostModel {
    private long postId;
    private long userId;
    private boolean isEdited;
    private String content;
    private String title;
    private Date date;
}
