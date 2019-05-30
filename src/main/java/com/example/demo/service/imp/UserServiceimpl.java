
package com.example.demo.service.imp;


import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class UserServiceimpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public int register(String nickname, String password,String phone) {
        return userMapper.register(nickname, password,phone);
    }

    @Override
    public User login(String nickname, String password) {
        return userMapper.login(nickname, password);
    }

    @Override
    public User getUserInfo(Integer id) {
        return userMapper.getUserInfoById(id);
    }

    @Override
    public int updateNickName(String nickname, Integer userId) {
        return userMapper.updateNickName(nickname, userId);
    }

    @Override
    public int updateSex(String sex, Integer userId) {
        return userMapper.updateSex(sex, userId);
    }

    @Override
    public int updatePhone(String phone, Integer userId) {
        return userMapper.updatePhone(phone, userId);
    }

    @Override
    public int updateAddress(String address, Integer userId) {
        return userMapper.updateAddress(address, userId);
    }

    @Override
    public int updateAge(String age, Integer userId) {
        return userMapper.updateAge(age, userId);
    }

    @Override
    public int updateURL(String image_url, Integer userId) {
        return userMapper.updateURL(image_url, userId);
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public int getUserCount() {
        return userMapper.getUserCount();
    }

    @Override
    public List<User> getUserByPage(int page, int pagesize) {
        return userMapper.getUserByPage((page-1)*pagesize,pagesize);
    }

    @Override
    public int updateUser(String nickname, String sex, String age, String phone, String address,  Integer userId) {
        return userMapper.updateUser(nickname,sex,age,phone,address,userId);
    }
}

