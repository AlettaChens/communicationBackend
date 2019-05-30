package com.example.demo.mapper;

import com.example.demo.entity.Info;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@org.apache.ibatis.annotations.Mapper
public interface InfoMapper {
    @Insert("insert into t_info(title,content,date,type,avatar)values(#{title},#{content},#{date},#{type},#{avatar})")
    int publish(@Param(value = "title") String  title, @Param(value = "content") String content, @Param(value = "date") String date, @Param(value = "type") String type,@Param(value = "avatar") String avatar);

    @Select("select * from t_info where type=#{type}")
    List<Info> searchAllByType(@Param(value = "type") String type);

    @Select("select * from t_info limit #{offset},#{pagesize}")
    List<Info> getInfoByPage(@Param(value = "offset") Integer offset, @Param(value = "pagesize") Integer pagesize);

    @Select("select * from t_info where newId=#{newId}")
    Info getInfoById(@Param(value = "newId") Integer newId);

    @Select("select count(*) from t_info")
    int getInfoCount();

    @Delete("delete from t_info where newId=#{newId}")
    int deleteInfoById(@Param(value = "newId") Integer newId);

    @Update("update t_info set title=#{title},content=#{content},date=#{date},avatar=#{url},type=#{type}where newId=#{newId}")
    int updateInfo(@Param(value = "title") String title,  @Param(value = "date") String date, @Param(value = "content") String content, @Param(value = "url") String url, @Param(value = "type") String type, @Param(value = "newId") Integer newId);

    @Update("update t_info set avatar=#{avatar}where newId=#{newId}")
    int updateInfoUrl(@Param(value = "avatar") String avatar, @Param(value = "newId") Integer newId);
}
