package com.hbrd.Dao;

import com.hbrd.Model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
@Repository
public interface UserDao {
    User Login(String UserName,String UserLoginPass);
    User ControlPass(String UserId,String UserControlPass);
    User IsUser(String UserId);
    boolean loginPassUpadte(String newpass,String UserId,String UserLoginPass,String UserName);
    boolean loginControlUpadte(String newpass,String UserId,String UserLoginPass,String UserName);
    HashMap<String,Object> UserMessage(String UserId);
}
