package com.example.hz.demo.utils;

import com.example.hz.demo.controller.IndexController;
import com.example.hz.demo.mapper.Solution;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class MyKeyGeneratorTest {

    MyKeyGenerator my = new MyKeyGenerator();
    Solution c = new Solution();

    public MyKeyGeneratorTest() throws Exception {
    }

    @Test
    public void generate() {
        Method m = null;
        try {
            m = c.getClass().getMethod("maxInWindows", int[].class, int.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        my.generate(c,m,c.getClass());
    }
}