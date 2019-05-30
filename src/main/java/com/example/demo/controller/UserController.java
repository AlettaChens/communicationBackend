package com.example.demo.controller;

import com.example.demo.service.UserService;
import com.example.demo.utils.FileUploadUtils;
import com.example.demo.utils.ResultMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping(value = "user")
@Api(value = "用户接口", description = "用户接口")
public class UserController {
    @Resource
    private UserService userService;

    @ApiOperation(value = "用户注册", notes = "用户注册")
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ResultMap register(String nickname, String password, String phone) {
        if (userService.register(nickname, password, phone) == 1) {
            return ResultMap.ok(null);
        }
        return ResultMap.fail(null);
    }


    @ApiOperation(value = "用户登录", notes = "用户登录")
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResultMap login(String nickname, String password) {
        if (userService.login(nickname, password) != null) {
            return ResultMap.ok(userService.login(nickname, password));
        }
        return ResultMap.fail(null);
    }


    @ApiOperation(value = "通过ID获取用户信息", notes = "通过ID获取用户信息")
    @RequestMapping(value = "getuserinfo/{id}", method = RequestMethod.POST)
    public ResultMap getUserInfoById(@PathVariable Integer id) {
        if (userService.getUserInfo(id) != null) {
            return ResultMap.ok(userService.getUserInfo(id));
        }
        return ResultMap.fail(null);
    }


    @ApiOperation(value = "修改用户昵称", notes = "修改用户昵称")
    @RequestMapping(value = "updatenick", method = RequestMethod.POST)
    public ResultMap updateNickName(String nickname, Integer userId) {
        if (userService.updateNickName(nickname, userId) == 1) {
            return ResultMap.ok(nickname);
        }
        return ResultMap.fail(null);
    }


    @ApiOperation(value = "修改用户性别", notes = "修改用户性别")
    @RequestMapping(value = "updatesex", method = RequestMethod.POST)
    public ResultMap updateSex(String sex, Integer userId) {
        if (userService.updateSex(sex, userId) == 1) {
            return ResultMap.ok(sex);
        }
        return ResultMap.fail(null);
    }


    @ApiOperation(value = "修改用户电话", notes = "修改用户电话")
    @RequestMapping(value = "updatephone", method = RequestMethod.POST)
    public ResultMap updatePhone(String phone, Integer userId) {
        if (userService.updatePhone(phone, userId) == 1) {
            return ResultMap.ok(phone);
        }
        return ResultMap.fail(null);
    }


    @ApiOperation(value = "修改用户年龄", notes = "修改用户年龄")
    @RequestMapping(value = "updateage", method = RequestMethod.POST)
    public ResultMap updateAge(String age, Integer userId) {
        if (userService.updateAge(age, userId) == 1) {
            return ResultMap.ok(age);
        }
        return ResultMap.fail(null);
    }


    @ApiOperation(value = "修改用户地址", notes = "修改用户地址")
    @RequestMapping(value = "updateaddress", method = RequestMethod.POST)
    public ResultMap updateAddress(String address, Integer userId) {
        if (userService.updateAddress(address, userId) == 1) {
            return ResultMap.ok(address);
        }
        return ResultMap.fail(null);
    }


    @ApiOperation(value = "修改用户头像", notes = "修改用户头像")
    @RequestMapping(value = "/userimageupload", method = RequestMethod.POST)
    public ResultMap uploadImg(@RequestParam("file") MultipartFile file, Integer userId,
                               HttpServletRequest request) throws IOException {
        String url = FileUploadUtils.upLoadPicture(file, "upload/userimage", request);
        if (userService.updateURL(url, userId) == 1) {
            return ResultMap.ok(url);
        }
        return ResultMap.fail(null);
    }

    @ApiOperation(value = "获取所有的用户数据", notes = "获取所有的用户数据")
    @RequestMapping(value = "/getAllUser", method = RequestMethod.POST)
    public ResultMap getAllUser() {
        if (userService.getAllUser() != null) {
            return ResultMap.ok(userService.getAllUser());
        }
        return ResultMap.fail(null);
    }

    @ApiOperation(value = "获取用户数量", notes = "获取用户数量")
    @RequestMapping(value = "/getUserCount", method = RequestMethod.POST)
    public ResultMap getUserCount() {
        return ResultMap.ok(userService.getUserCount());
    }

    @ApiOperation(value = "分页获取用户", notes = "分页获取用户")
    @RequestMapping(value = "getUserByPage", method = RequestMethod.POST)
    public ResultMap getServiceByPage(Integer page, Integer pagesize) {
        if (userService.getUserByPage(page, pagesize) != null) {
            return ResultMap.ok(userService.getUserByPage(page, pagesize));
        }
        return ResultMap.fail(null);
    }

    @ApiOperation(value = "更新用户信息", notes = "更新用户信息")
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public ResultMap UpdateUser(String nickname, String sex, String age, String phone, String address, Integer userId) throws IOException {
        if (userService.updateUser(nickname, sex, age, phone, address, userId) == 1) {
            return ResultMap.ok(null);
        }
        return ResultMap.fail(null);
    }

}
