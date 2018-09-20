package com.hbrd.Controller;

import com.hbrd.Model.Drive;
import com.hbrd.Model.Message;
import com.hbrd.Model.User;
import com.hbrd.Service.impl.CarImpl;
import com.hbrd.Service.impl.DriveImpl;
import com.hbrd.Service.impl.MessageImpl;
import com.hbrd.Service.impl.UserImpl;
import com.hbrd.Util.Util;
import com.hbrd.Util.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.HashMap;

@Controller
public class UserController {
    @Autowired
    UserImpl userlmpl;
    @Autowired
    DriveImpl drivelmpl;
    /**登录**/
    @PostMapping("/landing")
    public ModelAndView login(HttpServletRequest request, HttpSession session, ModelAndView mv, @RequestParam("UserName") String UserName, @RequestParam("UserLoginPass") String UserLoginPass){
        if(Validate.Isuser(UserName)&&Validate.Ispass(UserLoginPass)){
            User user=userlmpl.Login(UserName,UserLoginPass);
            if(user!=null){
                mv.setViewName("/Home");
                session.setAttribute("userid",user.getUserId());
                session.setAttribute("username",user.getUserName());
                drivelmpl.InsertDriver(new Drive(user.getUserId(),"登录", Util.getAdd(request),Util.getDate(),Util.getTime()));
                return mv;
            }else{
                mv.setViewName("/Login");
                request.setAttribute("error","用户名密码错误!");
                return mv ;
            }
        }else{
            mv.setViewName("/Login");
            request.setAttribute("error","格式错误!");
            return mv;
        }
    }
    /**修改登录密码**/
    @ResponseBody
    @PostMapping("/loginPassUpadte")
    public String loginPassUpadte(HttpServletRequest request,@RequestParam("newpass")String newpass,@RequestParam("UserId")String UserId,@RequestParam("UserLoginPass")String UserLoginPass,@RequestParam("UserName")String UserName){
        if(userlmpl.loginPassUpadte(newpass,UserId,UserLoginPass,UserName)){
            drivelmpl.InsertDriver(new Drive(UserId,"修改登录密码", Util.getAdd(request),Util.getDate(),Util.getTime()));
            return "{\"state\":\"ok\",\"code\":\"0\"}";
        }else{
            return "{\"state\":\"error\",\"code\":\"1\"}";
        }
    }
    /**修改控车密码**/
    @ResponseBody
    @PostMapping("/loginControlUpadte")
    public String loginControlUpadte(HttpServletRequest request,@RequestParam("newpass")String newpass,@RequestParam("UserId")String UserId,@RequestParam("UserLoginPass")String UserLoginPass,@RequestParam("UserName")String UserName){
        if(userlmpl.loginControlUpadte(newpass,UserId,UserLoginPass,UserName)){
            drivelmpl.InsertDriver(new Drive(UserId,"修改控车密码", Util.getAdd(request),Util.getDate(),Util.getTime()));
            return "{\"state\":\"ok\",\"code\":\"0\"}";
        }else{
            return "{\"state\":\"error\",\"code\":\"1\"}";
        }
    }
    /**用户信息**/
    @ResponseBody
    @PostMapping("/UserMessage")
    public String UserMessage(@RequestParam("UserId")String UserId){
        try {
            HashMap<String,Object> SSHashMap=userlmpl.UserMessage(UserId);
            return "{\"state\":\"ok\",\"code\":\"0\",\"carhe\":\""+SSHashMap.get("carhe")+"\",\"controlhe\":\""+SSHashMap.get("controlhe")+"\",\"Time\":\""+SSHashMap.get("Time")+"\",\"DriveIp\":\""+SSHashMap.get("DriveIp")+"\"}";
        }catch (Exception e){
            e.printStackTrace();
            return "{\"state\":\"error\",\"code\":\"1\"}";
        }
    }
}
