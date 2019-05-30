package com.example.demo.entity;

import io.swagger.models.auth.In;

import javax.persistence.Table;

@Table(name = "t_like")
public class Like {
    private Integer id;
    private Integer newId;
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNewId() {
        return newId;
    }

    public void setNewId(Integer newId) {
        this.newId = newId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
