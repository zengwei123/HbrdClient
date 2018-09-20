package com.hbrd.Service.impl;

import com.hbrd.Dao.DriveDao;
import com.hbrd.Dao.UserDao;
import com.hbrd.Model.Drive;
import com.hbrd.Service.DriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriveImpl implements DriveService{
    @Autowired
    DriveDao driveDao;
    @Override
    public boolean InsertDriver(Drive drive) {
        if(drive!=null){
            return driveDao.InsertDriver(drive);
        }else{
            return false;
        }
    }

    @Override
    public List<Drive> DriverList(String UserId) {
        return driveDao.DriverList(UserId);
    }
}
