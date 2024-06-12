package com.saravanjs.java22.console.multithreading;

/**
 * @author Sarav on 07 Jun 2024
 * @project govtech
 * @package console.multithreading
 * @class ConditionExample
 */
public class ConditionExample {

    // Condition variables allow threads to wait for certain conditions to be met.
    // The wait() method makes a thread wait until another thread invokes notify() or notifyAll()
    // on the same object.

    private static final Object lock = new Object();
    private static boolean dataReady = false;

    public static void main(String[] args) throws InterruptedException {
        Thread producer = new Thread(() -> {
            synchronized (lock) {
                dataReady = true;
                lock.notifyAll();
            }
        });

        Thread consumer = new Thread(() -> {
            synchronized (lock) {
                while (!dataReady) {
                    try {
                        System.out.println("Waiting for data...");
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println("Data is ready!");
            }
        });

        consumer.start();
        Thread.sleep(1000);  // Ensure consumer is waiting
        producer.start();

        producer.join();
        consumer.join();
    }
}
