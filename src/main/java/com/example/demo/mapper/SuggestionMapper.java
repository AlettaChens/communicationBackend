package com.example.demo.mapper;

import com.example.demo.entity.Book;
import com.example.demo.entity.Suggestion;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@org.apache.ibatis.annotations.Mapper
public interface SuggestionMapper {

    @Insert("insert into t_suggestion(userAvatar,userName,suggestion)values(#{userAvatar},#{userName},#{suggestion})")
    int publish( @Param(value = "userAvatar") String userAvatar, @Param(value = "userName") String userName, @Param(value = "suggestion") String suggestion);

    @Select("select * from t_suggestion")
    List<Suggestion> searchAll();

    @Select("select * from t_suggestion limit #{offset},#{pagesize}")
    List<Suggestion> getSuggestionByPage(@Param(value = "offset") Integer offset, @Param(value = "pagesize") Integer pagesize);

    @Select("select * from t_suggestion where id=#{id}")
    Suggestion getSuggestionInfoById(@Param(value = "id") Integer id);

    @Select("select count(*) from t_suggestion")
    int getSuggestionCount();

    @Delete("delete from t_suggestion where id=#{id}")
    int deleteSuggestionById(@Param(value = "id") Integer id);
}
