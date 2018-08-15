package com.example.demo.util;

/**
 * Create by coldwarm on 2018/8/15.
 */

public class OrderFormStatusString {
    public static String stringStatus(Integer status){
        if (status == 15){
            return "线下支付待审核";
        }else if (status == 10){
           return "待付款";
        }else if (status ==20){
            return "已付款";
        }else if (status == 40){
            return "已收货";
        }
        return null;
    }
}
