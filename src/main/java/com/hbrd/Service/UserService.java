package com.hbrd.Service;

import com.hbrd.Model.User;

import java.util.HashMap;
import java.util.List;

public interface UserService {
    User Login(String UserName,String UserLoginPass);
    User ControlPass(String UserId,String UserControlPass);
    boolean IsUser(String UserId);
    boolean loginPassUpadte(String newpass,String UserId,String UserLoginPass,String UserName);
    boolean loginControlUpadte(String newpass,String UserId,String UserLoginPass,String UserName);
    HashMap<String,Object> UserMessage(String UserId);
}
