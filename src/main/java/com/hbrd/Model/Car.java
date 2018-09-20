package com.hbrd.Model;

public class Car {
    private String CarId;  //车辆id
    private String UserId;  //用户id
    private String CarImsi; //imsi
    private String CarPhone;  //号码
    private String CarPlate;  //车牌
    private String CarShell;  //车架
    private String CarMake;   //车品牌
    private int GroupingId;

    public String getCarId() {
        return CarId;
    }

    public void setCarId(String carId) {
        CarId = carId;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getCarImsi() {
        return CarImsi;
    }

    public void setCarImsi(String carImsi) {
        CarImsi = carImsi;
    }

    public String getCarPhone() {
        return CarPhone;
    }

    public void setCarPhone(String carPhone) {
        CarPhone = carPhone;
    }

    public String getCarPlate() {
        return CarPlate;
    }

    public void setCarPlate(String carPlate) {
        CarPlate = carPlate;
    }

    public String getCarShell() {
        return CarShell;
    }

    public void setCarShell(String carShell) {
        CarShell = carShell;
    }

    public String getCarMake() {
        return CarMake;
    }

    public void setCarMake(String carMake) {
        CarMake = carMake;
    }

    public int getGroupingId() {
        return GroupingId;
    }

    public void setGroupingId(int groupingId) {
        GroupingId = groupingId;
    }
}
