package console.multithreading.ThreadLocalExample;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * @author Sarav on 25 Sep 2023
 * @project govtech
 * @package com.govtech.viswa.multithreading.ThreadLocalExample
 * @class ThreadLocalExample
 */
public class ThreadLocalExample {

    public static void main(String[] args) throws InterruptedException {
        MyRunnable sharedRunnableInstance = new MyRunnable();

        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);


        thread1.start();
        thread1.join(); //wait for thread 1 to terminate
        Thread.sleep(2000);
        thread2.start();
        thread2.join(); //wait for thread 2 to terminate
    }



}


