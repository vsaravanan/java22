package console.multithreading.ThreadLocalExample;

/**
 * @author Sarav on 25 Sep 2023
 * @project govtech
 * @package com.govtech.viswa.multithreading.ThreadLocalExample
 * @class MyRunnable
 */


public class MyRunnable implements Runnable {

    private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
    Integer myLocal = 0;
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " threadLocal : " + threadLocal.get() + "  myLocal " + myLocal );
        threadLocal.set( (int) (Math.random() * 100D) );
        myLocal = (int) (Math.random() * 100D) ;


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        System.out.println(Thread.currentThread().getName() + " threadLocal : " + threadLocal.get() + "  myLocal " + myLocal );
    }
}