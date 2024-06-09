package console.multithreading.producerconsumer;

/**
 * @author Sarav on 16 Jan 2024
 * @project govtech
 * @package com.saravan.corejava.tests
 * @class Consumer
 */

public class Consumer implements Runnable {
    private SharedBuffer buffer;

    public Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                buffer.consume();
                Thread.sleep(1000);  // Simulate some work
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
