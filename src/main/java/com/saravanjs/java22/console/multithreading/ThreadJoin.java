package com.saravanjs.java22.console.multithreading;

/**
 * @author Sarav on 12 Jun 2024
 * @project govtech
 * @package com.saravanjs.java22.console.multithreading
 * @class ThreadJoin
 */


public class ThreadJoin {
    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            System.out.println("ThreadA started");
            try {
                System.out.println("Sleeping at A");
                Thread.sleep(2000); // Simulating some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ThreadA completed");
        });

        Thread threadB = new Thread(() -> {
            System.out.println("ThreadB started");
            try {
                threadA.start();
                System.out.println("ThreadA joined with ThreadB");
                Thread.sleep(1000);
//                threadA.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ThreadB completed");
        });


        threadB.start();

        System.out.println("Main thread completed");
    }
}
