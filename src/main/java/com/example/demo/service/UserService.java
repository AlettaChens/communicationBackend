package com.example.demo.service;



import com.example.demo.entity.User;


import java.util.List;

public interface UserService {
    int register(String nickname,String password,String phone);
    User login(String nickname, String password);
    User getUserInfo(Integer id);
    int updateNickName(String nickname,Integer userId);
    int updateSex(String sex,Integer userId);
    int updatePhone(String phone,Integer userId);
    int updateAge(String age,Integer userId);
    int updateAddress(String address,Integer userId);
    int updateURL(String image_url,Integer userId);
    List<User> getAllUser();
    int getUserCount();
    List<User> getUserByPage(int offset,int pagesize);
    int updateUser( String nickname, String sex, String age,String phone,String address,Integer userId);
}
