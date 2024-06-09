package console.multithreading.semaphore;

/**
 * @author Sarav on 16 Jan 2024
 * @project govtech
 * @package com.saravan.corejava.tests
 * @class SharedBuffer
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

class SharedBuffer {
    private final Queue<Integer> buffer;
    private final int maxSize;
    private final Semaphore items;   // Semaphore counting available items
    private final Semaphore spaces;  // Semaphore counting available spaces
    private final Semaphore mutex;   // Binary semaphore for mutual exclusion

    public SharedBuffer(int maxSize) {
        this.buffer = new LinkedList<>();
        this.maxSize = maxSize;
        this.items = new Semaphore(0);
        this.spaces = new Semaphore(maxSize);
        this.mutex = new Semaphore(1);
    }

    public void put(int item) throws InterruptedException {
        spaces.acquire();  // Wait for available space
        mutex.acquire();   // Ensure mutual exclusion
        buffer.add(item);
        mutex.release();
        items.release();   // Signal that an item is available
    }

    public int take() throws InterruptedException {
        items.acquire();   // Wait for an available item
        mutex.acquire();   // Ensure mutual exclusion
        int item = buffer.poll();
        mutex.release();
        spaces.release();  // Signal that space is available
        return item;
    }
}





