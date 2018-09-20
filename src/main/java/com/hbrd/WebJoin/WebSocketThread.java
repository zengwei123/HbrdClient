package com.hbrd.WebJoin;


import com.hbrd.Model.Car;
import com.hbrd.Model.Message;
import com.hbrd.Service.impl.CarImpl;
import com.hbrd.Service.impl.MessageImpl;
import com.hbrd.Util.ApplicationContextProvider;
import com.hbrd.Util.GsonString;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class WebSocketThread extends Thread {
    private Map<String,CustomWebSocket> myWebSocketMap=null;
    private List<Car> carList=null;
    private List<Message> messages=null;
    private CarImpl carImpl=null;
    private MessageImpl messageImpl=null;
    public WebSocketThread(){
        carImpl=ApplicationContextProvider.getBean(CarImpl.class);
        messageImpl=ApplicationContextProvider.getBean(MessageImpl.class);
        messages=new ArrayList<>();
    }
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myWebSocketMap=CustomWebSocket.webSocketSet;
            if(myWebSocketMap.size()!=0){
                for(Map.Entry<String,CustomWebSocket> entry:myWebSocketMap.entrySet()){
                    if(carList!=null){
                        carList.clear();
                    }
                    if(messages!=null){
                        messages.clear();
                    }
                    carList=carImpl.CarList(entry.getKey());
                    for (Car car:carList){
                        messages.add(messageImpl.DescMessage(car.getCarId()));
                    }
                    try {
                        myWebSocketMap.get(entry.getKey()).sendMessage("{\"messages\":"+GsonString.MessageJson(messages)+"}");
                    } catch (IOException e) {
                    }
                }
            }
        }
    }
}
