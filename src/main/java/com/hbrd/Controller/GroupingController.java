package com.hbrd.Controller;

import com.hbrd.Model.Car;
import com.hbrd.Model.Grouping;
import com.hbrd.Service.impl.GroupingImpl;
import com.hbrd.Util.GsonString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class GroupingController {
    @Autowired
    private GroupingImpl groupingImpl;
    /**获取所有分组*/
    @ResponseBody
    @PostMapping("/GroupingList")
    public String GroupingList(@RequestParam("UserId") String UserId){
        try {
            List<Grouping> groupingList = groupingImpl.GroupingList(UserId);
            return "{\"state\":\"ok\",\"code\":\"0\",\"groupingList\":"+ GsonString.GroupingJson(groupingList)+"}";
        }catch (Exception e){
            return "{\"state\":\"error\",\"code\":\"1\"}";
        }
    }
}
