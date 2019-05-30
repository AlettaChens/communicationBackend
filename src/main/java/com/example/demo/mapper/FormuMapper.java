package com.example.demo.mapper;

import com.example.demo.entity.Formu;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@org.apache.ibatis.annotations.Mapper
public interface FormuMapper {

    @Insert("insert into t_formu(title,content,anthorName,anthorAvatar,publishDate)values(#{title},#{content},#{anthorName},#{anthorAvatar},#{publishDate})")
    int publish(@Param(value = "title") String title, @Param(value = "content") String content, @Param(value = "anthorName") String anthorName, @Param(value = "anthorAvatar") String anthorAvatar, @Param(value = "publishDate") String publishDate);

    @Select("select * from t_formu")
    List<Formu> searchAll();

    @Select("select * from t_formu limit #{offset},#{pagesize}")
    List<Formu> getFormuByPage(@Param(value = "offset") Integer offset, @Param(value = "pagesize") Integer pagesize);

    @Select("select * from t_formu where anthorName=#{anthorName}")
    List<Formu> getFormuInfoByAuthorName(@Param(value = "anthorName") String anthorName);

    @Select("select count(*) from t_formu")
    int getFormuCount();

    @Delete("delete from t_formu where formuId=#{formuId}")
    int deleteFormuById(@Param(value = "formuId") Integer formuId);

    @Update("update t_formu set title=#{title},content=#{content}，content_url=#{content_url},anthorName=#{anthorName},anthorAvatar=#{anthorAvatar},publishDate=#{publishDate}where formuId=#{formuId}")
    int updateFormu(@Param(value = "title") String title, @Param(value = "content") String content, @Param(value = "content_url") String content_url, @Param(value = "anthorName") String anthorName, @Param(value = "anthorAvatar") String anthorAvatar, @Param(value = "publishDate") String publishDate,@Param(value = "formuId") Integer formuId);

    @Update("update t_formu set star=#{star} where formuId=#{formuId} ")
    int updateStar(@Param(value = "star") Integer star,@Param(value = "formuId") Integer formuId);

    @Select("select star from t_formu where formuId=#{formuId}")
    int searchStar(@Param(value = "formuId") Integer formuId);
}