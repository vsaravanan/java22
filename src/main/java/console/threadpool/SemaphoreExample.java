package console.threadpool;

/**
 * @author Sarav on 16 Apr 2024
 * @project govtech
 * @package com.govtech.demo.console
 * @class SemaphoreExample
 */
import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    private static final int THREAD_COUNT = 5;

    public static void main(String[] args) {
        // Create a Semaphore with permits for THREAD_COUNT concurrent threads
        Semaphore semaphore = new Semaphore(THREAD_COUNT);

        // Create and start multiple threads
        for (int i = 0; i < THREAD_COUNT * 2; i++) {
            Thread thread = new Thread(new Worker(semaphore));
            thread.start();
        }
    }

    static class Worker implements Runnable {
        private final Semaphore semaphore;

        Worker(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                // Acquire a permit from the semaphore
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + " has acquired a permit.");

                // Simulate some work
                Thread.sleep(1000);

                // Release the permit back to the semaphore
                semaphore.release();
                System.out.println(Thread.currentThread().getName() + " has released the permit.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

