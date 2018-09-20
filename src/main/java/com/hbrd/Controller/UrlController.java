package com.hbrd.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UrlController {
    @GetMapping("/Login")
    public String Login(){
        return "login";
    }
    @GetMapping("/Home")
    public String Home(HttpSession session){
        return isUser(session)?"Home":"Login";
    }
    @GetMapping("/Report")
    public String Report(HttpSession session){
        return isUser(session)?"Report":"Login";
    }
    @GetMapping("/Management")
    public String Management(HttpSession session){
        return isUser(session)?"Management":"Login";
    }
    @GetMapping("/User")
    public String User(HttpSession session){
        return isUser(session)?"User":"Login";
    }
    /**判断用户是否登录**/
    private boolean isUser(HttpSession session){
        if(session.getAttribute("userid")!=null){
            return true;
        }else{
            return false;
        }
    }
}
