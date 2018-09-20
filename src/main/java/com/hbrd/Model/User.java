package com.hbrd.Model;

public class User {
    private String UserId;
    private String UserName;   //用户名
    private String UserLoginPass;   //密码
    private String UserControlPass;  //控车密码

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }
}
