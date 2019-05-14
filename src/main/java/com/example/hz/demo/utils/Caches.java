package com.example.hz.demo.utils;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.HashMap;

public class Caches {
    HashMap cache1 = new HashMap<String,Object>(1000);
    HashMap cache2 = new HashMap<String,Object>(10000);
    public Object getResult(String key){
        Object c = cache1.get(key)==null?null:cache1.get(key);
        return c;

    }

    public static void main(String...args){
        String sign = DigestUtils.shaHex("6e26265e-a8d3-45f4-81f0-22a06b2c34c5wangjian21556163094926");
        System.out.println(sign+5);
    }
}
