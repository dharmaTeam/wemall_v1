package com.example.demo.kuaidi;

import java.security.NoSuchAlgorithmException;

public class AppException extends Throwable {
    public AppException(NoSuchAlgorithmException e) {
        System.out.println("MD5异常！");
    }
}
