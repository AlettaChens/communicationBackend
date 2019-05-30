package com.example.demo.controller;

import com.example.demo.service.AdminService;
import com.example.demo.utils.ResultMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
@RequestMapping(value = "admin")
@Api(value = "管理员接口", description = "管理员接口")
public class AdminController {
    @Resource

    private AdminService adminService;

    @ApiOperation(value = "管理员注册", notes = "管理员注册")
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ResultMap register(String name, String password) {
        if (adminService.register(name, password) == 1) {
            return ResultMap.ok(null);
        }
        return ResultMap.fail(null);

    }

    @ApiOperation(value = "管理员登录", notes = "管理员登录")
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResultMap login(String name, String password) {
        if (adminService.login(name, password) != null) {
            return ResultMap.ok(adminService.login(name, password));
        }
        return ResultMap.fail(null);
    }
}
