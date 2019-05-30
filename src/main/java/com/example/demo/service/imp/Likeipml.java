package com.example.demo.service.imp;

import com.example.demo.entity.Like;
import com.example.demo.mapper.LikeMapper;
import com.example.demo.service.LikeService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Component
public class Likeipml implements LikeService {
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String date=df.format(new Date());
    @Resource
    private LikeMapper likeMapper;


    @Override
    public int publish(Integer newId, Integer userId) {
        return likeMapper.publish(newId,userId,date,1);
    }


    @Override
    public List<Like> getLikeInfoByUserId(Integer id) {
        return likeMapper.getLikeInfoByUserId(id);
    }


    @Override
    public int deleteLikeById(Integer id) {
        return likeMapper.deleteLikeById(id);
    }

}
