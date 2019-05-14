package com.example.hz.demo.mapper;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution a = new Solution();


    @Test
    public void maxInWindows() {
        //assertEquals(a.maxInWindows(new int[]{2, 3, 4, 2, 6, 2, 5, 1},3), new int[]{4, 4, 6, 6, 6, 5});
        int i = 0; int a = i++; int b = ++a; int c = a+b; int d = (a == 1)?b:c;
        System.out.println("a="+a+" d= "+d);
    }

    @Test
    public void getMax() {
    }
}