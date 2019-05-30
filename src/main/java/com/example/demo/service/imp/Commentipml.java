package com.example.demo.service.imp;

import com.example.demo.entity.Comment;
import com.example.demo.mapper.CommentMapper;
import com.example.demo.service.CommentService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Component
public class Commentipml implements CommentService {

    @Resource
    private CommentMapper commentMapper;
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String date=df.format(new Date());
    @Override
    public int publish(Integer formuId, String content, String comment_user) {
        return commentMapper.publish(formuId,content,date,comment_user);
    }

    @Override
    public List<Comment> searchAll(Integer formuId) {
        return commentMapper.searchAll(formuId);
    }

    @Override
    public List<Comment> getCommentByPage(Integer offset, Integer pagesize) {
        return commentMapper.getCommentByPage((offset-1)*pagesize,pagesize);
    }

    @Override
    public Comment getCommentInfoById(Integer id) {
        return commentMapper.getCommentInfoById(id);
    }

    @Override
    public int getCommentCount() {
        return commentMapper.getCommentCount();
    }

    @Override
    public int deleteCommentById(Integer id) {
        return commentMapper.deleteCommentById(id);
    }

    @Override
    public int updateComment(Integer formuId, String content, String comment_user, Integer id) {
        return commentMapper.updateComment(formuId,content,date,comment_user,id);
    }
}
