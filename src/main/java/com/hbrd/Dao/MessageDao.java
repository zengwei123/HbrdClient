package com.hbrd.Dao;


import com.hbrd.Model.Message;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageDao {
    int InputTerminusMessage(Message message);
    Message DescMessage(String CarId);
}
