package com.hbrd.Service.impl;


import com.hbrd.Dao.CarDao;
import com.hbrd.Dao.UserDao;
import com.hbrd.Model.Car;
import com.hbrd.Service.CarService;
import com.hbrd.Util.Verify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarImpl implements CarService {
    @Autowired
    CarDao carDao;
    @Autowired
    UserImpl userImpl;
    @Override
    public int UpdateImsi(String imsi,String CarId) {
        try {
            if(Verify.CarImsi(imsi)&&Verify.CarId(CarId)){
                return carDao.UpdateImsi(imsi,CarId);
            }else {
                return 11;
            }
        }catch (Exception e){
            return 123;
        }
    }

    @Override
    public List<Car> CarList(String UserId) {
        if(userImpl.IsUser(UserId)){
            return carDao.CarList(UserId);
        }else{
            return null;
        }
    }

    @Override
    public Car CarOne(String UserId, String CarId) {
        if(userImpl.IsUser(UserId)){
            return carDao.CarOne(UserId,CarId);
        }else{
            return null;
        }
    }
}
