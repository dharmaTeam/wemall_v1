package com.example.demo.excption;

import java.security.NoSuchAlgorithmException;

public class AppException extends Throwable {
    public AppException(NoSuchAlgorithmException e) {
        System.out.println("MD5异常！");
    }
}
