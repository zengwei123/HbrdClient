package com.hbrd.Service;


import com.hbrd.Model.Chart;
import com.hbrd.Model.Message;

import java.util.HashMap;
import java.util.List;

public interface MessageService {
    int InputTerminusMessage(Message message);
    Message DescMessage(String CarId);
    List<Chart> ReportUserOnline(String UserId, String Date1, String Date2);
    List<Chart> ReportUserColumnar(String UserId, String Date1, String Date2);
}
