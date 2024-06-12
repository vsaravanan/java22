package com.saravanjs.java22.console.multithreading.semaphore;

/**
 * @author Sarav on 16 Jan 2024
 * @project govtech
 * @package com.saravan.corejava.tests
 * @class Consumer
 */

public class Consumer implements Runnable {
    private final SharedBuffer sharedBuffer;

    public Consumer(SharedBuffer sharedBuffer) {
        this.sharedBuffer = sharedBuffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int item = sharedBuffer.take();
                System.out.println("Consuming " + item);
                Thread.sleep((int) (Math.random() * 1000));  // Simulate time taken to consume an item
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Consumer was interrupted");
                break;  // Exit the loop if interrupted
            }
        }
    }
}
