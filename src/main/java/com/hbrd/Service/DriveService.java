package com.hbrd.Service;

import com.hbrd.Model.Drive;

import java.util.List;

public interface DriveService {
    boolean InsertDriver(Drive drive);
    List<Drive> DriverList(String UserId);
}
