package com.hbrd.Dao;


import com.hbrd.Model.Chart;
import com.hbrd.Model.Message;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface MessageDao {
    int InputTerminusMessage(Message message);
    Message DescMessage(String CarId);
    List<Chart> ReportUserOnline(String UserId, String Date1, String Date2);
    List<Chart> ReportUserColumnar(String UserId, String Date1, String Date2);
}
