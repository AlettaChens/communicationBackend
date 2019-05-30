package com.example.demo.service;

import com.example.demo.entity.Like;


import java.util.List;

public interface LikeService {

    int publish( Integer newId,  Integer userId);

    List<Like> getLikeInfoByUserId( Integer UserId);

    int deleteLikeById( Integer id);
}
