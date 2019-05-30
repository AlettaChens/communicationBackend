package com.example.demo.service;

import com.example.demo.entity.Suggestion;

import java.util.List;

public interface SuggestionService {
    int publish(  String userAvatar,  String userName,  String suggestion);

    List<Suggestion> searchAll();

    List<Suggestion> getSuggestionByPage( Integer offset,  Integer pagesize);

    Suggestion getSuggestionInfoById( Integer id);

    int getSuggestionCount();

    int deleteSuggestionById( Integer id);
}
