package com.example.demo.service;


import com.example.demo.entity.Admin;

public interface AdminService {
    int register(String name, String password);

    Admin login(String name, String password);

}
