package com.hbrd.Dao;

import com.hbrd.Model.Drive;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriveDao {
    boolean InsertDriver(Drive drive);
    List<Drive> DriverList(String UserId);
}
