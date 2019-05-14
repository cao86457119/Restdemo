package com.example.hz.demo.utils;

import org.springframework.cache.interceptor.KeyGenerator;

import java.lang.reflect.Method;

public class MyKeyGenerator implements KeyGenerator {
    @Override
    public Object generate(Object o, Method method, Object... objects) {
        Class[] a = method.getParameterTypes();
        for (Class i:
             a) {
            System.out.println(i.getName());
            
        }
        return null;
    }
}
