package com.example.demo.service;

import com.example.demo.entity.Formu;

import java.util.List;

public interface FormuService {

    int publish(String title, String content, String anthorName,String anthorAvatar);

    List<Formu> searchAll();

    List<Formu> getFormuByPage(Integer offset, Integer pagesize);

    List<Formu> getFormuInfoByAuthorName(String  authorName);

    int getFormuCount();

    int deleteFormuById(Integer formuId);

    int updateFormu(String title, String content,String content_url, String anthorName, String anthorAvatar, Integer formuId);

    int updateStar(Integer star,Integer formuId);

    int searchStar(Integer formuId);
}
