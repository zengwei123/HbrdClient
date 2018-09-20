package com.hbrd.Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    /**
     * 手机号验证
     * @param value
     * @return
     */
    public static boolean Isphone(String value){
        String regExp = "^(0|86|17951)?(13[0-9]|15[0-9]|18[0-9]|14[0-9]|17[0-9])[0-9]{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(value);
        return m.find();
    }

    /**
     * 用户名 大小写字母数字中文下划线  2-10位
     * @param value
     * @return
     */
    public static boolean Isuser(String value){
        String regExp = "^[A-Za-z0-9_\\u4e00-\\u9fa5]{2,10}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(value);
        return m.find();
    }

    /**
     * 密码大于6位
     * @param value
     * @return
     */
    public static boolean Ispass(String value){
        if(value.length()>6){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 身份证号验证
     * @param value
     * @return
     */
    public static boolean Isidcard(String value){
        String regExp = "^(^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$)|(^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])((\\d{4})|\\d{3}[Xx])$)$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(value);
        return m.find();
    }

    /**
     * 车牌验证
     * @param value
     * @return
     */
    public static boolean iscarbrand(String value){
        String regExp = "^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(value);
        return m.find();
    }

    /**
     *判断序列号
     */
    public static boolean isCarInformationSerial(String value){
        if(value.length()==10){
            String regExp = "^\\d+$";
            Pattern p = Pattern.compile(regExp);
            Matcher m = p.matcher(value);
            return m.find();
        }else{
            return false;
        }
    }
//    public static void main(String[] a){
//        System.out.print(  Validate.iscarbrand("湘K99990"));
//
//    }
    /**
     * 传进来统一验证  --用户注册验证
     * @param OneselfName
     * @param OneselfPass
     * @param OneselfPhone
     * @param OneselIdCard
     * @return
     */
    public static boolean ifArr(String OneselfName,String OneselfPass,String OneselfPhone,String OneselIdCard){
        if(!Isuser(OneselfName)){
            return false;
        }
        if(!Ispass(OneselfPass)){
            return false;
        }
        if(!Isphone(OneselfPhone)){
            return false;
        }
        if(!Isidcard(OneselIdCard)){
            return false;
        }
        return true;
    }
}
