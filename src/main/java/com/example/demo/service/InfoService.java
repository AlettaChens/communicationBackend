package com.example.demo.service;

import com.example.demo.entity.Info;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InfoService {

    int publish(String title, String content, String type, String avatar);

    List<Info> searchAllByType(String type);

    List<Info> getInfoByPage(Integer offset, Integer pagesize);

    Info getInfoById(Integer InfoId);

    int getInfoCount();

    int deleteInfoById(Integer newId);

    int updateInfo(String title, String content, String tyep, String url, Integer newId);

    int updateInfoUrl(String avatar, Integer newId);


}
