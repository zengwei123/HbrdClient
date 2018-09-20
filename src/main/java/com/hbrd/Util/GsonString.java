package com.hbrd.Util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.hbrd.Model.Car;
import com.hbrd.Model.Drive;
import com.hbrd.Model.Grouping;
import com.hbrd.Model.Message;

import java.lang.reflect.Modifier;
import java.util.List;

public class GsonString {
    /**
     * 所有车辆
     * @return
     */
    public static String CarJson(List<Car> listCar){
        Gson gson = new Gson();
        return gson.toJson(listCar,new TypeToken<List<Car>>() {}.getType());
    }
    /**
     * 单个车辆所有数据
     * @return
     */
    public static String MessageJson(List<Message> listMessage){
        Gson gson = new Gson();
        return gson.toJson(listMessage,new TypeToken<List<Message>>() {}.getType());
    }

    /**
     * 单个车辆所有数据
     * @return
     */
    public static String CarOneJson(Car car){
        Gson gson = new Gson();
        return gson.toJson(car,Car.class);
    }

    /**
     * 所有用户分组
     * @param listGrouping
     * @return
     */
    public static String GroupingJson(List<Grouping> listGrouping){
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        return gson.toJson(listGrouping,new TypeToken<List<Grouping>>() {}.getType());
    }

    /**
     * 所有操作记录
     * @param listDrive
     * @return
     */
    public static String DriveJson(List<Drive> listDrive){
        Gson gson = new Gson();
        return gson.toJson(listDrive,new TypeToken<List<Drive>>() {}.getType());
    }
}
