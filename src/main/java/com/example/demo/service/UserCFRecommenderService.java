package com.example.demo.service;

import com.example.demo.entity.Info;
import java.util.List;


public interface UserCFRecommenderService {

    List<Long> recommend(Integer userId);

    List<Info> recommendNews(Integer userId);
}
