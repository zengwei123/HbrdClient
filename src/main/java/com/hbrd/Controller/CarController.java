package com.hbrd.Controller;

import com.hbrd.Model.Car;
import com.hbrd.Service.impl.CarImpl;
import com.hbrd.Service.impl.UserImpl;
import com.hbrd.Util.GsonString;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CarController {
    @Autowired
    CarImpl carImpl;

    /**获取所有车辆*/
    @ResponseBody
    @PostMapping("/CarList")
    public String CarList(@RequestParam("UserId") String UserId){
        try {
            List<Car> carList = carImpl.CarList(UserId);
            return "{\"state\":\"ok\",\"code\":\"0\",\"carList\":"+GsonString.CarJson(carList)+"}";
        }catch (Exception e){
            return "{\"state\":\"error\",\"code\":\"1\"}";
        }
    }
    /**获取单个车辆*/
    @ResponseBody
    @PostMapping("/CarOne")
    public String CarOne(@RequestParam("UserId") String UserId,@RequestParam("CarId") String CarId){
        try {
            return "{\"state\":\"ok\",\"code\":\"0\",\"car\":"+GsonString.CarOneJson(carImpl.CarOne(UserId,CarId))+"}";
        }catch (Exception e){
            return "{\"state\":\"error\",\"code\":\"1\"}";
        }
    }
}
