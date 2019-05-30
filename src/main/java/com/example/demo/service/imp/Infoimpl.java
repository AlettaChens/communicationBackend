package com.example.demo.service.imp;

import com.example.demo.entity.Info;
import com.example.demo.mapper.InfoMapper;
import com.example.demo.service.InfoService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Component
public class Infoimpl implements InfoService {

    @Resource
    private InfoMapper infoMapper;
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String date=df.format(new Date());
    @Override
    public int publish(String title, String content, String type, String avatar) {
        return infoMapper.publish(title,content,date,type,avatar);
    }

    @Override
    public List<Info> searchAllByType(String type) {
        return infoMapper.searchAllByType(type);
    }

    @Override
    public List<Info> getInfoByPage(Integer offset, Integer pagesize) {
        return infoMapper.getInfoByPage((offset-1)*pagesize,pagesize);
    }

    @Override
    public Info getInfoById(Integer InfoId) {

        return infoMapper.getInfoById(InfoId);
    }

    @Override
    public int getInfoCount() {
        return infoMapper.getInfoCount();
    }

    @Override
    public int deleteInfoById(Integer newId) {
        return infoMapper.deleteInfoById(newId);
    }

    @Override
    public int updateInfo(String title,String content,String type,String url, Integer newId) {
        return infoMapper.updateInfo(title,date,content,url,type,newId);
    }

    @Override
    public int updateInfoUrl(String avatar, Integer newId) {
        return infoMapper.updateInfoUrl(avatar,newId);
    }
}
