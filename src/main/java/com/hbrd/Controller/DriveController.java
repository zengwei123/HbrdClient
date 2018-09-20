package com.hbrd.Controller;

import com.hbrd.Dao.DriveDao;
import com.hbrd.Model.Car;
import com.hbrd.Model.Drive;
import com.hbrd.Service.impl.DriveImpl;
import com.hbrd.Util.GsonString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DriveController  {
    @Autowired
    DriveImpl driveImpl;
    /**获取所有车辆*/
    @ResponseBody
    @PostMapping("/DriveList")
    public String DriveList(@RequestParam("UserId") String UserId){
        try {
            List<Drive> driveList = driveImpl.DriverList(UserId);
            return "{\"state\":\"ok\",\"code\":\"0\",\"driveList\":"+ GsonString.DriveJson(driveList)+"}";
        }catch (Exception e){
            e.printStackTrace();
            return "{\"state\":\"error\",\"code\":\"1\"}";
        }
    }
}
