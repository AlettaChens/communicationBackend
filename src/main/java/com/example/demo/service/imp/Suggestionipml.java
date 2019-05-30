package com.example.demo.service.imp;

import com.example.demo.entity.Suggestion;
import com.example.demo.mapper.SuggestionMapper;
import com.example.demo.service.SuggestionService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
@Component
public class Suggestionipml implements SuggestionService {
    @Resource
    private SuggestionMapper suggestionMapper;

    @Override
    public int publish(String userAvatar, String userName, String suggestion) {
        return suggestionMapper.publish(userAvatar,userName,suggestion);
    }

    @Override
    public List<Suggestion> searchAll() {
        return suggestionMapper.searchAll();
    }

    @Override
    public List<Suggestion> getSuggestionByPage(Integer offset, Integer pagesize) {
        return suggestionMapper.getSuggestionByPage((offset-1)*pagesize,pagesize);
    }

    @Override
    public Suggestion getSuggestionInfoById(Integer id) {
        return suggestionMapper.getSuggestionInfoById(id);
    }

    @Override
    public int getSuggestionCount() {
        return suggestionMapper.getSuggestionCount();
    }

    @Override
    public int deleteSuggestionById(Integer id) {
        return suggestionMapper.deleteSuggestionById(id);
    }
}
