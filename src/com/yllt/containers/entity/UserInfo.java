package com.yllt.containers.entity;

import java.util.List;

/**
 * Created by Administrator on 2015/11/19.
 */
public class UserInfo {
    private String userId;
    private String userName;
    private List<String> role;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getRole() {
        return role;
    }

    public void setRole(List<String> role) {
        this.role = role;
    }
}
