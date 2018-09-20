package com.hbrd.Dao;

import com.hbrd.Model.Car;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarDao {
    int UpdateImsi(String imsi, String CarId);
    List<Car> CarList(String UserId);
    Car CarOne(String UserId, String CarId);
}
