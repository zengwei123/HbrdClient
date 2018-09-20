package com.hbrd.Util;

import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class Util {
    public static String getDate(){
        DateFormat format = new SimpleDateFormat("YYYYMMdd");      //时间格式
        return format.format(new Date());
    }
    public static String getTime(){
        DateFormat format = new SimpleDateFormat("YYYYMMdd hh:mm:ss");      //时间格式
        return format.format(new Date());
    }

    /**
     * 获取操作地方的ip
     * @param request
     * @return
     */
    public static String getIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
    public static String getAdd(HttpServletRequest request) {
        //淘宝IP地址库：http://ip.taobao.com/instructions.php
        String add = null;
        String ip = getIp(request);
        try {
            //URL U = new URL("http://ip.taobao.com/service/getIpInfo.php?ip=114.111.166.72");
            URL U = new URL("http://ip.taobao.com/service/getIpInfo.php?ip="+ip);
            URLConnection connection = U.openConnection();
            connection.connect();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
            String result = "";
            String line;
            while ((line = in.readLine())!= null){
                result += line;
            }
            in.close();
            //   System.out.println(result);
            JSONObject jsonObject = JSONObject.fromObject(result);
            Map<String, Object> map = (Map) jsonObject;
            String code = String.valueOf(map.get("code"));//0：成功，1：失败。
            if("1".equals(code)){//失败
                String data = String.valueOf(map.get("data"));//错误信息
            }else if("0".equals(code)){//成功
                Map<String, Object> data = (Map<String, Object>) map.get("data");
                String country = String.valueOf(data.get("country"));//国家
                String area = String.valueOf(data.get("area"));//
                String city = String.valueOf(data.get("city"));//省（自治区或直辖市）
                String region = String.valueOf(data.get("region"));//市（县）
                add = country+"-"+city+"-"+region;
            }
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return add;
    }
}
