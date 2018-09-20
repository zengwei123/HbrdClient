package com.hbrd.Util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by hyc on 2018/6/2 11:49
 */
public class Date {
    public static final String PATTERN = "YYYYMMdd";
    public static final String[] weekDays = {"星期日", "星期一"
            , "星期二", "星期三", "星期四", "星期五", "星期六"};
    //日期
    private String day;
    //星期
    private String week;
    public Date(String day, String week) {
        this.day = day;
        this.week = week;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public static List<Date> generate(int zw){
        long dayTime = 24*60*60*1000L;     //1天内的毫秒数
        DateFormat format = new SimpleDateFormat(PATTERN);      //时间格式
        List<Date> dates = new ArrayList<>();                   //存放时间
        //该方法的作用是返回当前的计算机时间，时间的表达格式为当前计算机时间和GMT时间(格林威治时间)1970年1月1号0时0分0秒所差的毫秒数。
        long curTime = System.currentTimeMillis();
        for (int i = 0; i < zw; i++) {
            long time = curTime-i*dayTime;     //获取前i天的毫秒数
            String day = format.format(time);        //
            Date date = new Date(day,getWeek(time));
            dates.add(date);
        }
        return dates;
    }

    private static String getWeek(long time){
        Calendar calendar = Calendar.getInstance();   //这是一个日历类
        calendar.setTime(new java.util.Date(time));       //设置一个时间
        int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;   //获取当前星期
        return weekDays[w<0?0:w];
    }
}
