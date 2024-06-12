package com.saravanjs.java22.console.multithreading;

/**
 * @author Sarav on 12 Jun 2024
 * @project govtech
 * @package com.saravanjs.java22.console.multithreading
 * @class VolatileTest
 */


public class VolatileTest {
    private volatile boolean flag = false;

    public void writer() {
        flag = true;
    }

    public void reader() {
        if (flag) {
            System.out.println("Flag is true");
        }
        else {
            System.out.println("Flag is false");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileTest sharedData = new VolatileTest();

        Thread writerThread = new Thread(() -> {
            sharedData.writer();
        });

        Thread readerThread = new Thread(() -> {
            sharedData.reader();
        });
        writerThread.start();
        readerThread.start();

    }
}
