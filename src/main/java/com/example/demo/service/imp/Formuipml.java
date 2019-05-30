package com.example.demo.service.imp;

import com.example.demo.entity.Formu;
import com.example.demo.mapper.FormuMapper;
import com.example.demo.service.FormuService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Component
public class Formuipml implements FormuService {

    @Resource
    private FormuMapper formuMapper;

    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String publishDate=df.format(new Date());

    @Override
    public int publish(String title, String content, String anthorName,String anthorAvatar) {
        return formuMapper.publish(title,content,anthorName,anthorAvatar,publishDate);
    }

    @Override
    public List<Formu> searchAll() {
        return formuMapper.searchAll();
    }

    @Override
    public List<Formu> getFormuByPage(Integer offset, Integer pagesize) {
        return formuMapper.getFormuByPage((offset-1)*pagesize,pagesize);
    }

    @Override
    public List<Formu> getFormuInfoByAuthorName(String anthorName) {
        return formuMapper.getFormuInfoByAuthorName(anthorName);
    }

    @Override
    public int getFormuCount() {
        return formuMapper.getFormuCount();
    }

    @Override
    public int deleteFormuById(Integer formuId) {
        return formuMapper.deleteFormuById(formuId);
    }

    @Override
    public int updateFormu(String title, String content, String content_url, String anthorName, String anthorAvatar, Integer formuId) {
        return formuMapper.updateFormu(title,content,content_url,anthorName,anthorAvatar,publishDate,formuId);
    }

    @Override
    public int updateStar(Integer star, Integer formuId) {
        return formuMapper.updateStar(star,formuId);
    }

    @Override
    public int searchStar(Integer formuId) {
        return formuMapper.searchStar(formuId);
    }
}
