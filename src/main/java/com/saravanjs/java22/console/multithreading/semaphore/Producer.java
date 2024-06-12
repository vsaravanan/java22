package com.saravanjs.java22.console.multithreading.semaphore;

/**
 * @author Sarav on 16 Jan 2024
 * @project govtech
 * @package com.saravan.corejava.tests
 * @class Producer
 */
// Producer class
public class Producer implements Runnable {
    private final SharedBuffer sharedBuffer;

    public Producer(SharedBuffer sharedBuffer) {
        this.sharedBuffer = sharedBuffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("Producing " + i);
                sharedBuffer.put(i);
                Thread.sleep((int) (Math.random() * 1000));  // Simulate time taken to produce an item
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Producer was interrupted");
            }
        }
    }
}
