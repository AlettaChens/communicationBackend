package com.example.demo.controller;

import com.example.demo.entity.Info;
import com.example.demo.entity.Like;
import com.example.demo.service.InfoService;
import com.example.demo.service.LikeService;
import com.example.demo.utils.ResultMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("save")
@Api(value = "历史接口", description = "历史接口")
public class LikeController {

    @Resource
    private LikeService likeService;
    @Resource
    private InfoService infoService;

    @RequestMapping(value = "publish", method = RequestMethod.POST)
    @ApiOperation(value = "添加收藏", notes = "添加收藏")
    public ResultMap publish( Integer newId, Integer userId) {
        if (likeService.publish(newId,userId) == 1) {
            return ResultMap.ok(null);
        }
        return ResultMap.fail(null);
    }

    @RequestMapping(value = "getLikeInfoByUserId", method = RequestMethod.POST)
    @ApiOperation(value = "获取某用户的所有收藏", notes = "获取某用户的所有收藏")
    public ResultMap getLikeInfoByUserId(Integer userId) {
        List<Like> likeList= likeService.getLikeInfoByUserId(userId);
        List<Info> infoList= new ArrayList<>();
        if (likeList != null) {
            for (int i=0;i<likeList.size();i++){
                infoList.add(infoService.getInfoById(likeList.get(i).getNewId()));
            }
            return ResultMap.ok(infoList);
        }
        return ResultMap.fail(null);
    }

    @RequestMapping(value = "deleteLikeById", method = RequestMethod.POST)
    @ApiOperation(value = "通过Id删除收藏", notes = "通过Id删除收藏")
    public ResultMap deleteLikeById(Integer id) {
        if (likeService.deleteLikeById(id) == 1) {
            return ResultMap.ok(null);
        }
        return ResultMap.fail(null);
    }

}
