package com.example.hz.demo.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class stacks<E> {
    private int top = -1;
    private ArrayList<E> ar = new ArrayList<E>();

    public void clear() {
        top = -1;
    }

    public void push(E e) {
        top++;
        ar.set(top, e);
    }

    public E pop() {
        if (top != -1) {
            E e = ar.get(top);
            top--;
            return e;
        } else {
            return null;

        }
    }

//错误 用stack没法识别回文
//    public static void main(String... args) {
//        StringBuilder sb = new StringBuilder("abcbafabcba");
//        char[] sd = sb.toString().toCharArray();
//        Stack<Character> st = new Stack<>();
//
//        for (int i = 0; i < sd.length; i++) {
//
//            if (st.size()!=0){
//                Character temp = st.pop();
//                if(!temp.equals(sd[i])) {
//                    if(st.size()!=0) {
//                        Character temp1 = st.pop();
//                        if (temp1.equals(sd[i])) {
//                            st.push(temp);
//                        } else {
//                            st.push(temp1);
//                            st.push(temp);
//                            st.push(sd[i]);
//                        }
//                    }else{
//                        st.push(temp);
//                        st.push(sd[i]);
//                    }
//                }
//                else{
//                    st.pop();
//                }
//            }else{
//                st.push(sd[i]);
//            }
//
//        }
//        if(st.size()!=0&&st.size()!=1){
//            System.out.println("false");
//        }else{
//            System.out.println("true");
//        }
//
//
//    }

    public static void main(String... args) {
        HashMap hm = new HashMap();
        int a =10;
        new Integer(a);


    }
}
