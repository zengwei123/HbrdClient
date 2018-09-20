package com.hbrd.Service.impl;

import com.hbrd.Dao.UserDao;
import com.hbrd.Model.User;
import com.hbrd.Service.UserService;
import com.hbrd.Util.Verify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

@Service
public class UserImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public User Login(String UserName,String UserLoginPass) {
        return userDao.Login(UserName,UserLoginPass);
    }

    @Override
    public User ControlPass(String UserId,String UserControlPass) {
        return null;
    }

    @Override
    public boolean IsUser(String UserId) {
        if(userDao.IsUser(UserId)!=null){
            return true;
        }else{
            return false;
        }
    }
    /**修改密码**/
    @Override
    public boolean loginPassUpadte(String newpass, String UserId, String UserLoginPass, String UserName) {
        if(Verify.UserLoginPass(newpass)){
            return userDao.loginPassUpadte(newpass,UserId,UserLoginPass,UserName);
        }else{
            return false;
        }
    }
    /**控车密码**/
    @Override
    public boolean loginControlUpadte(String newpass, String UserId, String UserLoginPass, String UserName) {
        if(Verify.loginControlPass(newpass)){
                return userDao.loginControlUpadte(newpass,UserId,UserLoginPass,UserName);
        }else{
            return false;
        }
    }

    @Override
    public HashMap<String,Object> UserMessage(String UserId) {
        return userDao.UserMessage(UserId);
    }
}
