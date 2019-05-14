package com.example.hz.demo.mapper;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution<T> {
    public Object[] maxInWindows(int [] num, int size)
    {
        int[] a = new int[size];
        ArrayList<Integer> ab = new ArrayList<Integer>();
        int i=0;
        int k1=0;
        int k2=0;
        while(i<num.length){
             k1 = i/size;
             k2 = i%size;
             a[k2] = num[i];
             if(k1>0){
                ab.add(getMax(a));
             }
            i++;
            
        }

        return ab.toArray();
    }
    
    public int getMax(int[] a){
       Arrays.sort(a);
       return a[a.length-1];
    }
}