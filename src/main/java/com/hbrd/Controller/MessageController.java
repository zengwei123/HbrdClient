package com.hbrd.Controller;

import com.hbrd.Model.Chart;
import com.hbrd.Service.impl.MessageImpl;
import com.hbrd.Util.Date;
import com.hbrd.Util.GsonString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
public class MessageController {
    @Autowired
    MessageImpl message;
    /**修改登录密码**/
    @ResponseBody
    @PostMapping("/ReportUserOnline")
    public String ReportUserOnline(@RequestParam("UserId")String UserId){
        List<Chart> hashMap=message.ReportUserOnline(UserId, Date.generate(30).get(0).getDay(),Date.generate(30).get(29).getDay());
        return "{\"state\":\"ok\",\"code\":\"0\",\"ruo\":"+GsonString.ReportUserOnlineJson(hashMap)+"}";
    }

    /**修改登录密码**/
    @ResponseBody
    @PostMapping("/ReportUserColumnar")
    public String ReportUserColumnar(@RequestParam("UserId")String UserId){
        List<Chart> hashMap=message.ReportUserColumnar(UserId, Date.generate(30).get(0).getDay(),Date.generate(30).get(29).getDay());
        return "{\"state\":\"ok\",\"code\":\"0\",\"ruo\":"+GsonString.ReportUserOnlineJson(hashMap)+"}";
    }

}
