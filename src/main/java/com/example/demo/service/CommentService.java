package com.example.demo.service;

import com.example.demo.entity.Comment;

import java.util.List;

public interface CommentService {

    int publish(Integer formuId, String content, String comment_user);

    List<Comment> searchAll(Integer formuId);

    List<Comment> getCommentByPage(Integer offset, Integer pagesize);

    Comment getCommentInfoById(Integer id);

    int getCommentCount();

    int deleteCommentById(Integer id);

    int updateComment(Integer formuId, String content, String comment_user, Integer id);
}

