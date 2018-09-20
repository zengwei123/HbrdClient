package com.hbrd.Service;


import com.hbrd.Model.Message;

public interface MessageService {
    int InputTerminusMessage(Message message);
    Message DescMessage(String CarId);
}
