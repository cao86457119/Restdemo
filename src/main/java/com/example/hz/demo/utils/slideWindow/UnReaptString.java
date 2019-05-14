package com.example.hz.demo.utils.slideWindow;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

import static sun.swing.MenuItemLayoutHelper.max;

public class UnReaptString {


    public static int getNum(String s){
        int[] a = new int[256];
        int l=0,r=-1,res=0;
        while(l<s.length()){
            if(r+1<s.length()&&a[s.charAt(r+1)]==0){
                r++;
                a[s.charAt(r)]++;
            }
            else{
                a[s.charAt(l)]--;
                l++;
            }
            res = max(res,r-l+1);
        }
        return res;
    }

    //获取最大值
    public static int[] MaxNum(int[] nums,int k){
        PriorityQueue priorityQueue = new PriorityQueue();
        Deque deque = new LinkedList();
        int[] res= new int[nums.length-k+1];
        int l=0,r=k-1;
        int m1 = 0;
        while(r<=nums.length-1){
            m1 = nums[l];
            for(int i=l+1;i<=r;i++) {
                m1 = max(nums[i],m1);
            }
            res[l]=m1;
            r++;
            l++;
        }
        return res;
    }


    public static void main(String...args){
        int[] namx = MaxNum(new int[]{10, 8, 9, 4, 5, 6, 7},3);
        for(int i:namx){
            System.out.println(i);
        }
    }


}
