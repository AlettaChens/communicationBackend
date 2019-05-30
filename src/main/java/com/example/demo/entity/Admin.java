package com.example.demo.entity;

import javax.persistence.Table;

@Table(name="t_admin")
public class Admin {
    private Integer AdminId;
    private String AdminName;
    private  String AdminPassword;

    public Integer getAdminId() {
        return AdminId;
    }

    public void setAdminId(Integer adminId) {
        AdminId = adminId;
    }

    public String getAdminName() {
        return AdminName;
    }

    public void setAdminName(String adminName) {
        AdminName = adminName;
    }

    public String getAdminPassword() {
        return AdminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        AdminPassword = adminPassword;
    }
}
