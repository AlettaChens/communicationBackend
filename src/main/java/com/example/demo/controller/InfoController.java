package com.example.demo.controller;

import com.example.demo.service.InfoService;
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

@RestController
@RequestMapping("info")
@Api(value = "资讯接口", description = "资讯接口")
public class InfoController {
    @Resource
    private InfoService infoService;

    @RequestMapping(value = "publish", method = RequestMethod.POST)
    @ApiOperation(value = "资讯发布接口", notes = "资讯发布接口")
    public ResultMap publish(String title, String content, String type, String avatar) {
        if (infoService.publish(title,content,type,avatar) == 1) {
            return ResultMap.ok(null);
        }
        return ResultMap.fail(null);
    }

    @RequestMapping(value = "searchAllByType", method = RequestMethod.POST)
    @ApiOperation(value = "获取所有资讯", notes = "获取所有资讯")
    public ResultMap searchAllByType(String type) {
        if (infoService.searchAllByType(type) != null) {
            return ResultMap.ok(infoService.searchAllByType(type));
        }
        return ResultMap.fail(null);
    }


    @RequestMapping(value = "getInfoByPage", method = RequestMethod.POST)
    @ApiOperation(value = "分页获取所有资讯", notes = "分页获取所有资讯")
    public ResultMap getInfoByPage(Integer offset, Integer pagesize) {
        if (infoService.getInfoByPage(offset, pagesize) != null) {
            return ResultMap.ok(infoService.getInfoByPage(offset, pagesize));
        }
        return ResultMap.fail(null);
    }

    @RequestMapping(value = "getInfoById", method = RequestMethod.POST)
    @ApiOperation(value = "通过Id获取所有资讯", notes = "通过Id获取所有资讯")
    public ResultMap getInfoById(Integer id) {
        if (infoService.getInfoById(id) != null) {
            return ResultMap.ok(infoService.getInfoById(id));
        }
        return ResultMap.fail(null);
    }

    @RequestMapping(value = "getInfoCount", method = RequestMethod.POST)
    @ApiOperation(value = "获取所有资讯的数量", notes = "获取所有资讯的数量")
    public ResultMap getInfoCount() {
        if (infoService.getInfoCount() >= 0) {
            return ResultMap.ok(infoService.getInfoCount());
        }
        return ResultMap.fail(null);
    }

    @RequestMapping(value = "deleteInfoById", method = RequestMethod.POST)
    @ApiOperation(value = "通过Id删除资讯", notes = "通过Id删除资讯")
    public ResultMap deleteInfoById(Integer id) {
        if (infoService.deleteInfoById(id) == 1) {
            return ResultMap.ok(null);
        }
        return ResultMap.fail(null);
    }

    @RequestMapping(value = "updateInfo", method = RequestMethod.POST)
    @ApiOperation(value = "通过Id更新资讯信息", notes = "通过Id更新资讯信息")
    public ResultMap updateInfo(String title, String content, String type, String avatar, Integer newId) {
        if (infoService.updateInfo(title, content, type, avatar, newId) == 1) {
            return ResultMap.ok(null);
        }
        return ResultMap.fail(null);
    }

    @ApiOperation(value = "修改资讯头像", notes = "修改资讯头像")
    @RequestMapping(value = "/updateInfoUrl", method = RequestMethod.POST)
    public ResultMap updateInfoUrl(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        String url = FileUploadUtils.upLoadPicture(file, "upload/info", request);
        return ResultMap.ok(url);
    }
}
