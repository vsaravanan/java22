package com.saravanjs.java22.console.multithreading.producerconsumer;

/**
 * @author Sarav on 16 Jan 2024
 * @project govtech
 * @package com.saravan.corejava.tests
 * @class ProducerConsumerExample
 */
public class ProducerConsumerExample {

//    https://raw.githubusercontent.com/vsaravanan/java22/master/src/main/java/console/multithreading/producerconsumer/ProducerConsumerExample.java


    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer(5);

        Thread producerThread = new Thread(new Producer(buffer));
        Thread consumerThread = new Thread(new Consumer(buffer));

        producerThread.start();
        consumerThread.start();
    }
}
