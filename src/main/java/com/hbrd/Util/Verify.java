package com.hbrd.Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Verify {
    /**
     * 错误码
     * 1-----正确
     * 11----验证错误
     * 123---数据库操作错误
     */
    private static Pattern p;
    private static Matcher m;

    /**
     * imsi验证
     * @param s
     * @return
     */
    public static boolean CarImsi(String s){
        String regExp = "^[0-9]{15}$";
        p = Pattern.compile(regExp);
        m = p.matcher(s);
        return m.find();
    }

    /**
     * 车辆id验证
     * @param s
     * @return
     */
    public static boolean CarId(String s){
        String regExp = "^[0-9]{10}$";
        p = Pattern.compile(regExp);
        m = p.matcher(s);
        return m.find();
    }
    /**登录密码**/
    public static boolean UserLoginPass(String s){
        String regExp = "^[A-Za-z0-9_]{6,}$";
        p = Pattern.compile(regExp);
        m = p.matcher(s);
        return m.find();
    }
    /**控车密码**/
    public static boolean loginControlPass(String s){
        String regExp = "^[0-9]{6}$";
        p = Pattern.compile(regExp);
        m = p.matcher(s);
        return m.find();
    }
    public static boolean Message(String s1,String s2){
        if(s1.equals("$HBRD")&&s2.equals("com/hbrd")){
            return true;
        }else{
            return false;
        }
    }
}
