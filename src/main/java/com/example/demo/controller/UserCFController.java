package com.example.demo.controller;

import com.example.demo.service.UserCFRecommenderService;
import com.example.demo.utils.ResultMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("recommender")
@Api(value = "算法推荐接口", description = "算法推荐接口")
public class UserCFController {

    @Resource
    private UserCFRecommenderService userCFRecommenderService;

    @RequestMapping(value = "publish", method = RequestMethod.POST)
    @ApiOperation(value = "基于用户的协同过滤算法", notes = "基于用户的协同过滤算法")
    public ResultMap publish(Integer userId) {
        if (userCFRecommenderService.recommendNews(userId) != null) {
            return ResultMap.ok(userCFRecommenderService.recommendNews(userId));
        }
        return ResultMap.fail(null);
    }

}
