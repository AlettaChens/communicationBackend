package com.example.demo.mapper;

import com.example.demo.entity.Book;
import com.example.demo.entity.Like;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@org.apache.ibatis.annotations.Mapper
public interface LikeMapper {
    @Insert("insert into t_like(newId,userId,readTime,preference)values(#{newId},#{userId},#{readTime},#{preference})")
    int publish(@Param(value = "newId") Integer newId, @Param(value = "userId") Integer userId,@Param(value = "readTime") String readTime,@Param(value = "preference") float preference);

    @Select("select * from t_like where userId=#{userId}")
    List<Like> getLikeInfoByUserId(@Param(value = "userId") Integer userId);

    @Delete("delete from t_like where id=#{id}")
    int deleteLikeById(@Param(value = "id") Integer id);

}
