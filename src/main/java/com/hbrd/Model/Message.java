package com.hbrd.Model;

public class Message {
    private int MessageId;   //号
    private String CarId;   //车辆
    private String CarX;    //纬度
    private String CarY;   //经度
    private String CarBasis;   //基本
    private String CarWarning;   //警告
    private String CarBms;   //电池
    private String IsWarning;   //是否有警告
    private String Date;   //日期
    private String Time;    //时间

    public int getMessageId() {
        return MessageId;
    }

    public void setMessageId(int messageId) {
        MessageId = messageId;
    }

    public String getCarId() {
        return CarId;
    }

    public void setCarId(String carId) {
        CarId = carId;
    }

    public String getCarX() {
        return CarX;
    }

    public void setCarX(String carX) {
        CarX = carX;
    }

    public String getCarY() {
        return CarY;
    }

    public void setCarY(String carY) {
        CarY = carY;
    }

    public String getCarBasis() {
        return CarBasis;
    }

    public void setCarBasis(String carBasis) {
        CarBasis = carBasis;
    }

    public String getCarWarning() {
        return CarWarning;
    }

    public void setCarWarning(String carWarning) {
        CarWarning = carWarning;
    }

    public String getCarBms() {
        return CarBms;
    }

    public void setCarBms(String carBms) {
        CarBms = carBms;
    }

    public String getIsWarning() {
        return IsWarning;
    }

    public void setIsWarning(String isWarning) {
        IsWarning = isWarning;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
}
