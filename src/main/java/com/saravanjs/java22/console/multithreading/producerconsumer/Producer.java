package com.saravanjs.java22.console.multithreading.producerconsumer;

/**
 * @author Sarav on 16 Jan 2024
 * @project govtech
 * @package com.saravan.corejava.tests
 * @class Producer
 */
public class Producer implements Runnable {
    private SharedBuffer buffer;

    public Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                buffer.produce();
                Thread.sleep(10000);  // Simulate some work
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
