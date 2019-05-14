package com.example.hz.demo.utils;

import java.util.ArrayList;

public class kBlockedQueue {
    private int[] data=null;
    private int head = 0;
    private int tail = 0;
    private int leng = 0;
    public kBlockedQueue(int i){
        data = new int[i];
        head=0;
        tail=0;
        leng = i-1;
    }

    public synchronized void put(int num){


        while(leng < tail){
            try {
                wait();
                System.out.println("put wait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        data[tail] = num;
        tail++;
        notifyAll();
    }


    public synchronized int get(){
        while(tail < head||tail==0){
            try {
                wait();
                System.out.println("get wait");
                ArrayList a = new ArrayList();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int a = data[head];
        head++;
        if(head>leng){
            head=0;
            tail=0;
        }
        notifyAll();
        return a;
    }

    public static void main(String...args){
        kBlockedQueue k = new kBlockedQueue(10);
        Runnable t = new Runnable(){

            /**
             * When an object implementing interface <code>Runnable</code> is used
             * to create a thread, starting the thread causes the object's
             * <code>run</code> method to be called in that separately executing
             * thread.
             * <p>
             * The general contract of the method <code>run</code> is that it may
             * take any action whatsoever.
             *
             * @see Thread#run()
             */
            @Override
            public void run(){
                for(int i=1;i<=100;i++) {

                    k.put(10);
                    System.out.println(Thread.currentThread().getName()+" put end");
                }
            }
        };
        Runnable t1 = new Runnable(){

            /**
             * When an object implementing interface <code>Runnable</code> is used
             * to create a thread, starting the thread causes the object's
             * <code>run</code> method to be called in that separately executing
             * thread.
             * <p>
             * The general contract of the method <code>run</code> is that it may
             * take any action whatsoever.
             *
             * @see Thread#run()
             */
            @Override
            public void run(){
                for(int i=1;i<=100;i++) {
                    int a = k.get();
                    System.out.println(Thread.currentThread().getName()+"start get "+a);
                }
            }
        };

        new Thread(t).start();
        new Thread(t1).start();
    }


}
