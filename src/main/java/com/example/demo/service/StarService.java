package com.example.demo.service;


import com.example.demo.entity.Star;

public interface StarService {

    int publish(int forumId, int userId);

    Star search(int forumId, int userId);

    int delete(int forumId, int userId);
}
