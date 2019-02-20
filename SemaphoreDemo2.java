package com.example.demo;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo2 {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(1);

        //等同于多线程的高并发加锁
        for (int i = 1; i <=60; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"已经抢占了资源");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName()+"已经离开");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally{
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }
}
