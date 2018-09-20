package com.hbrd.Service;

import com.hbrd.Model.Car;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CarService {
    int UpdateImsi(String imsi, String CarId);
    List<Car> CarList(String UserId);
    Car CarOne(String UserId, String CarId);
}
