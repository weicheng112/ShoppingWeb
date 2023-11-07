package com.shoppingWeb.shoppingWeb.utils;


import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;


@Component
public class MD5util {

    public static String md5(String src ,String salt){
        //springframework Password encryption
        //md5DigestAsHex require bytes
        String result=src+ salt;
        return DigestUtils.md5DigestAsHex(result.getBytes());
    }

}