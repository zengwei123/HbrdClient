package com.hbrd.Model;

public class Drive {
    private int DriveId;
    private String UserId;
    private String DriveClass;
    private String DriveIp;
    private String Date;
    private String Time;

    public Drive() {
    }

    public Drive(String userId, String driveClass, String driveIp, String date, String time) {
        UserId = userId;
        DriveClass = driveClass;
        DriveIp = driveIp;
        Date = date;
        Time = time;
    }

    @Override
    public String toString() {
        return "Drive{" +
                "DriveId=" + DriveId +
                ", UserId='" + UserId + '\'' +
                ", DriveClass='" + DriveClass + '\'' +
                ", DriveIp='" + DriveIp + '\'' +
                ", Date='" + Date + '\'' +
                ", Time='" + Time + '\'' +
                '}';
    }

    public int getDriveId() {
        return DriveId;
    }

    public void setDriveId(int driveId) {
        DriveId = driveId;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getDriveClass() {
        return DriveClass;
    }

    public void setDriveClass(String driveClass) {
        DriveClass = driveClass;
    }

    public String getDriveIp() {
        return DriveIp;
    }

    public void setDriveIp(String driveIp) {
        DriveIp = driveIp;
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
