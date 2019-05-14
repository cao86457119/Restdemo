package com.example.hz.demo.utils.slideWindow;

import org.junit.Test;

import static org.junit.Assert.*;

public class UnReaptStringTest {

    @Test
    public void getNum() {
        String ss = "abcabcde";
        assert UnReaptString.getNum(ss)==5:"error";
    }
}