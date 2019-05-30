package com.example.demo.mapper;

import com.example.demo.entity.Comment;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@org.apache.ibatis.annotations.Mapper
public interface CommentMapper {
    @Insert("insert into t_comment(formuId,content,date,comment_user)values(#{formuId},#{content},#{date},#{comment_user})")
    int publish(@Param(value = "formuId") Integer formuId, @Param(value = "content") String content, @Param(value = "date") String date, @Param(value = "comment_user") String comment_user);

    @Select("select * from t_comment where formuId=#{formuId}")
    List<Comment> searchAll(@Param(value = "formuId") Integer formuId);

    @Select("select * from t_comment limit #{offset},#{pagesize}")
    List<Comment> getCommentByPage(@Param(value = "offset") Integer offset, @Param(value = "pagesize") Integer pagesize);

    @Select("select * from t_comment where id=#{id}")
    Comment getCommentInfoById(@Param(value = "id") Integer id);

    @Select("select count(*) from t_comment")
    int getCommentCount();

    @Delete("delete from t_comment where id=#{id}")
    int deleteCommentById(@Param(value = "id") Integer id);

    @Update("update t_comment set formuId=#{formuId},content=#{content}，date=#{date},comment_user=#{comment_user}where id=#{id}")
    int updateComment(@Param(value = "formuId") Integer formuId, @Param(value = "content") String content, @Param(value = "date") String date, @Param(value = "comment_user") String comment_user, @Param(value = "id") Integer id);
}
