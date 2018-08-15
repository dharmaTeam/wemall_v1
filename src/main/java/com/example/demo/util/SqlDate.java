package com.example.demo.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Create by coldwarm on 2018/8/15.
 */

public class SqlDate {
    public static String dataToString(Date date){
        if (date != null) {
            SimpleDateFormat bjSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");     // 北京
            bjSdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));  // 设置北京时区
            return bjSdf.format(date).toString();
        }else {
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(dataToString(new Date()));
    }
}
