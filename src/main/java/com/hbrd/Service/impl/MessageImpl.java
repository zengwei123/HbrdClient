package com.hbrd.Service.impl;

import com.hbrd.Dao.MessageDao;
import com.hbrd.Model.Message;
import com.hbrd.Service.MessageService;
import com.hbrd.Util.Verify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageImpl implements MessageService {
    @Autowired
    MessageDao messageDao;

    @Override
    public int InputTerminusMessage(Message message) {
        try {
            if(Verify.CarId(message.getCarId())){
                return messageDao.InputTerminusMessage(message);
            }else {
                return 11;
            }

        }catch (Exception e){
            e.printStackTrace();
            return 123;
        }
    }

    @Override
    public Message DescMessage(String CarId) {
        return messageDao.DescMessage(CarId);
    }
}
