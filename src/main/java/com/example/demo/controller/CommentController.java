package com.example.demo.controller;

import com.example.demo.service.CommentService;
import com.example.demo.utils.ResultMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("comment")
@Api(value = "评论接口", description = "评论接口")
public class CommentController {

    @Resource
    private CommentService commentService;

    @RequestMapping(value = "publish", method = RequestMethod.POST)
    @ApiOperation(value = "评论发布接口", notes = "评论发布接口")
    public ResultMap publish(Integer formuId, String content, String comment_user) {
        if (commentService.publish(formuId, content, comment_user) == 1) {
            return ResultMap.ok(null);
        }
        return ResultMap.fail(null);
    }


    @RequestMapping(value = "searchAll", method = RequestMethod.POST)
    @ApiOperation(value = "获取所有评论条目", notes = "获取所有评论条目")
    public ResultMap searchAll(Integer formuId) {
        if (commentService.searchAll(formuId) != null) {
            return ResultMap.ok(commentService.searchAll(formuId));
        }
        return ResultMap.fail(null);
    }

    @RequestMapping(value = "deleteCommentById", method = RequestMethod.POST)
    @ApiOperation(value = "通过Id删除评论", notes = "通过Id删除评论")
    public ResultMap deleteCommentById(Integer id) {
        if (commentService.deleteCommentById(id) == 1) {
            return ResultMap.ok(null);
        }
        return ResultMap.fail(null);
    }

    @RequestMapping(value = "updateComment", method = RequestMethod.POST)
    @ApiOperation(value = "通过Id更新资讯信息", notes = "通过Id更新资讯信息")
    public ResultMap updateComment(Integer formuId, String content, String comment_user, Integer id) {
        if (commentService.updateComment(formuId,content,comment_user,id) == 1) {
            return ResultMap.ok(null);
        }
        return ResultMap.fail(null);
    }

}
