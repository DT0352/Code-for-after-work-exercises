package com.practice.JUC;

import java.util.concurrent.TimeUnit;

/**
 * @author ZhiDong
 * <p>
 * 2020/12/27
 */
public class JucSync01 {
    // T01_WhatIsThread
    private static class T1 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    System.out.println(Thread.currentThread().getName());
                    TimeUnit.MICROSECONDS.sleep(1
                    );

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                System.out.println("t1");
            }
        }
    }

    public static class R1 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("这是学习多线程与高并发的第一天");
            }
        }
    }


    public static void main(String[] args) {
        new T1().start();
        new Thread(new R1()).start();
//        new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                System.out.println("你猜我要做些什么");
//            }
//        }).start();

//        new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                System.out.println("我猜不出来");
//            }
//        }).start();
    }
}
