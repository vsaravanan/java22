package console.multithreading.semaphore;

/**
 * @author Sarav on 16 Jan 2024
 * @project govtech
 * @package com.saravan.corejava.tests
 * @class ProducerConsumerExample
 */


//    https://raw.githubusercontent.com/vsaravanan/java22/master/src/main/java/console/multithreading/semaphore/ProducerConsumerExample.java

public class ProducerConsumerExample {
    public static void main(String[] args) {
        SharedBuffer sharedBuffer = new SharedBuffer(5);

        Thread producerThread = new Thread(new Producer(sharedBuffer));
        Thread consumerThread = new Thread(new Consumer(sharedBuffer));

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();  // Wait for the producer to finish
            consumerThread.interrupt();  // Interrupt the consumer after the producer is done
            consumerThread.join();  // Wait for the consumer to finish
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Main thread was interrupted");
        }
    }
}