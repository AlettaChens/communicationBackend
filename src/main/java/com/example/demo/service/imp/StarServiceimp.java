package com.example.demo.service.imp;

import com.example.demo.entity.Star;
import com.example.demo.mapper.StarMapper;
import com.example.demo.service.StarService;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class StarServiceimp implements StarService {

    @Resource
    private StarMapper starMapper;

    @Override
    public int publish( int forumId, int userId) {
        return starMapper.publishStar(forumId, userId);
    }

    @Override
    public Star search(int forumId, int userId) {
        return starMapper.searchStar(forumId, userId);
    }

    @Override
    public int delete(int forumId, int userId) {
        return starMapper.deleteStar(forumId, userId);
    }
}
