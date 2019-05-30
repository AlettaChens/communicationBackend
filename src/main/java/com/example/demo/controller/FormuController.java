package com.example.demo.controller;

import com.example.demo.entity.Formu;
import com.example.demo.service.FormuService;
import com.example.demo.service.StarService;
import com.example.demo.utils.FileUploadUtils;
import com.example.demo.utils.ResultMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("formu")
@Api(value = "论坛接口", description = "论坛接口")
public class FormuController {

    @Resource
    private FormuService formuService;

    @Resource
    private StarService starService;

    @RequestMapping(value = "publish", method = RequestMethod.POST)
    @ApiOperation(value = "论坛言论发布接口", notes = "论坛言论发布接口")
    public ResultMap publish( String title, String content, String anthorName, String anthorAvatar){
        if (formuService.publish(title, content,anthorName, anthorAvatar) == 1) {
            return ResultMap.ok(null);
        }
        return ResultMap.fail(null);
    }

    @RequestMapping(value = "searchAll", method = RequestMethod.POST)
    @ApiOperation(value = "获取所有论坛条目", notes = "获取所有论坛条目")
    public ResultMap searchAll(Integer userId) {
        List<Formu> formuList=formuService.searchAll();
        if (formuList != null) {
            for(Formu formu:formuList){
                if (starService.search(formu.getFormuId(), userId) != null) {
                   formu.setIsCheck(1);
                }
            }
            return ResultMap.ok(formuList);
        }
        return ResultMap.fail(null);
    }

    @RequestMapping(value = "getFormuByPage", method = RequestMethod.POST)
    @ApiOperation(value = "分页获取所有图书", notes = "分页获取所有图书")
    public ResultMap getFormuByPage(Integer offset, Integer pagesize) {
        if (formuService.getFormuByPage(offset, pagesize) != null) {
            return ResultMap.ok(formuService.getFormuByPage(offset, pagesize));
        }
        return ResultMap.fail(null);
    }

    @RequestMapping(value = "getFormuInfoByAuthorName", method = RequestMethod.POST)
    @ApiOperation(value = "通过Id获取所有图书", notes = "通过Id获取所有图书")
    public ResultMap getFormuInfoByAuthorName(String  anthorName) {
        if (formuService.getFormuInfoByAuthorName(anthorName) != null) {
            return ResultMap.ok(formuService.getFormuInfoByAuthorName(anthorName));
        }
        return ResultMap.fail(null);
    }

    @RequestMapping(value = "getFormuCount", method = RequestMethod.POST)
    @ApiOperation(value = "获取所有图书的数量", notes = "获取所有图书的数量")
    public ResultMap getFormuCount() {
        if (formuService.getFormuCount() >= 0) {
            return ResultMap.ok(formuService.getFormuCount());
        }
        return ResultMap.fail(null);
    }

    @RequestMapping(value = "deleteFormuById", method = RequestMethod.POST)
    @ApiOperation(value = "通过Id删除图书", notes = "通过Id删除图书")
    public ResultMap deleteFormuById(Integer id) {
        if (formuService.deleteFormuById(id) == 1) {
            return ResultMap.ok(null);
        }
        return ResultMap.fail(null);
    }

    @RequestMapping(value = "updateFormu", method = RequestMethod.POST)
    @ApiOperation(value = "通过Id更新资讯信息", notes = "通过Id更新资讯信息")
    public ResultMap updateFormu(@RequestParam("file") MultipartFile file, HttpServletRequest request,String title, String content, String anthorName, String anthorAvatar, Integer formuId)throws IOException {
        if (formuService.updateFormu(title, content,FileUploadUtils.upLoadPicture(file, "upload/formu", request),anthorName, anthorAvatar, formuId) == 1) {
            return ResultMap.ok(null);
        }
        return ResultMap.fail(null);
    }

    @ApiOperation(value = "更新点赞数量", notes = "更新点赞数量")
    @RequestMapping(value = "updateStar", method = RequestMethod.POST)
    public ResultMap updateStar(int forumId, int userId, String updateType) {
        int star;
        int currentStar = formuService.searchStar(forumId);
        if (updateType.equals("增加")) {
            star = currentStar + 1;
            starService.publish(forumId, userId);
        } else {
            star = currentStar - 1;
            starService.delete(forumId, userId);
        }
        if (formuService.updateStar(star, forumId) == 1) {
            return ResultMap.ok(null);
        }
        return ResultMap.fail(null);
    }
}
