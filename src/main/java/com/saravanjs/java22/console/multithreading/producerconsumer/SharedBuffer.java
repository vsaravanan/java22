package com.saravanjs.java22.console.multithreading.producerconsumer;

/**
 * @author Sarav on 16 Jan 2024
 * @project govtech
 * @package com.saravan.corejava.tests
 * @class SharedBuffer
 */
import java.util.LinkedList;

public class SharedBuffer {
    private LinkedList<Integer> buffer = new LinkedList<>();
    private int capacity;

    public SharedBuffer(int capacity) {
        this.capacity = capacity;
    }

    public void produce() throws InterruptedException {
        synchronized (this) {
            while (buffer.size() == capacity) {
                // Buffer is full, wait for a consumer to consume
                System.out.println("Buffer is full, waiting for a consumer to consume");
                wait();
            }

            // Produce an item and add it to the buffer
            int item = (int) (Math.random() * 100);
            buffer.add(item);
            System.out.println("Produced: " + item);

            // Notify consumers that an item is available
            notify();
        }
    }

    public void consume() throws InterruptedException {
        synchronized (this) {
            while (buffer.size() == 0) {
                // Buffer is empty, wait for a producer to produce
                System.out.println("Buffer is empty, waiting for a producer to produce");
                wait();
            }

            // Consume an item from the buffer
            int item = buffer.removeFirst();
            System.out.println("Consumed: " + item);

            // Notify producers that space is available in the buffer
            notify();
        }
    }
}




