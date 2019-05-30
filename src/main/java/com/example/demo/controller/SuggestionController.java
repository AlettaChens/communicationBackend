package com.example.demo.controller;

import com.example.demo.service.SuggestionService;
import com.example.demo.utils.ResultMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("suggestion")
@Api(value = "建议接口", description = "建议接口")
public class SuggestionController {
    @Resource
    private SuggestionService suggestionService;

    @RequestMapping(value = "publish", method = RequestMethod.POST)
    @ApiOperation(value = "建议发布接口", notes = "建议发布接口")
    public ResultMap publish(String userAvatar, String userName, String suggestion) {
        if (suggestionService.publish(userAvatar, userName, suggestion) == 1) {
            return ResultMap.ok(null);
        }
        return ResultMap.fail(null);
    }

    @RequestMapping(value = "searchAll", method = RequestMethod.POST)
    @ApiOperation(value = "获取所有建议", notes = "获取所有建议")
    public ResultMap searchAll() {
        if (suggestionService.searchAll() != null) {
            return ResultMap.ok(suggestionService.searchAll());
        }
        return ResultMap.fail(null);
    }

    @RequestMapping(value = "getSuggestionByPage", method = RequestMethod.POST)
    @ApiOperation(value = "分页获取所有建议", notes = "分页获取所有建议")
    public ResultMap getSuggestionByPage(Integer offset, Integer pagesize) {
        if (suggestionService.getSuggestionByPage(offset, pagesize) != null) {
            return ResultMap.ok(suggestionService.getSuggestionByPage(offset, pagesize));
        }
        return ResultMap.fail(null);
    }

    @RequestMapping(value = "getBookById", method = RequestMethod.POST)
    @ApiOperation(value = "通过Id获取建议", notes = "通过Id获取建议")
    public ResultMap getBookById(Integer id) {
        if (suggestionService.getSuggestionInfoById(id) != null) {
            return ResultMap.ok(suggestionService.getSuggestionInfoById(id));
        }
        return ResultMap.fail(null);
    }

    @RequestMapping(value = "getSuggestionCount", method = RequestMethod.POST)
    @ApiOperation(value = "获取所有建议的数量", notes = "获取所有建议的数量")
    public ResultMap getSuggestionCount() {
        if (suggestionService.getSuggestionCount() >= 0) {
            return ResultMap.ok(suggestionService.getSuggestionCount());
        }
        return ResultMap.fail(null);
    }

    @RequestMapping(value = "deleteSuggestionById", method = RequestMethod.POST)
    @ApiOperation(value = "通过Id删除建议", notes = "通过Id删除建议")
    public ResultMap deleteSuggestionById(Integer id) {
        if (suggestionService.deleteSuggestionById(id) == 1) {
            return ResultMap.ok(null);
        }
        return ResultMap.fail(null);
    }

}
