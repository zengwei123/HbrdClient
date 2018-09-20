package com.hbrd.WebJoin;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
@ServerEndpoint(value = "/websocket")
@Component
public class CustomWebSocket {
    public static Map<String,CustomWebSocket> webSocketSet = new HashMap<String,CustomWebSocket>();
    /**与某个客户端的连接会话，需要通过它来给客户端发送数据*/
    private Session session;
    /**
     * 连接建立成功调用的方法
     * @param session
     */
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
    }

    /**
     *  关闭后判断连接的数量是否不为0
     * 如果不为0那么就遍历map集合
     * 查到关闭当前连接的MyWebSocket的key
     * 从集合中清除
     */
    @OnClose
    public void onClose() {
        if(webSocketSet.size()!=0){
            for(Map.Entry<String,CustomWebSocket> entry:webSocketSet.entrySet()){
                if (entry.getValue()==this) {
                    System.out.println("客户端关闭："+entry.getKey());
                    webSocketSet.remove(entry.getKey());
                }
            }
        }
    }

    /**
     * 收到客户端消息后调用
     * @param message
     * @param session
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        String[] mes=message.split("#");
        if(mes[0].equals("A")){
            //连接指令
            webSocketSet.put(mes[1],this);
            System.out.println("客户端连接："+mes[1]);
        }else if(mes[0].equals("B")){

        }
        //sendAll(message);
    }
    /**
     * 发生错误时调用
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

    /**
     * 发送信息
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }
}
