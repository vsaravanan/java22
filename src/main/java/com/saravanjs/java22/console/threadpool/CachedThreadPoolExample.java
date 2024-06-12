package com.saravanjs.java22.console.threadpool;

/**
 * @author Sarav on 05 May 2024
 * @project govtech
 * @package com.govtech.demo.console
 * @class CachedThreadPoolExample
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CachedThreadPoolExample {
    public static void main(String[] args) throws InterruptedException {
        // Create a CachedThreadPool
        ExecutorService executor = Executors.newCachedThreadPool();

        // Submit tasks to the executor
        for (int i = 0; i < 100; i++) {
            executor.submit(() -> {
                System.out.println("Task executed by thread: " +  " ->  " + Thread.currentThread().getName());
            });
        }

        // Shutdown the executor service when tasks are completed
        executor.shutdown();
    }

    public static class ScheduledThreadPoolExample {
        public static void main(String[] args) throws InterruptedException {
            // Create a ScheduledThreadPoolExecutor with 5 core threads
            try (ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5)) {


                // Schedule a task to run repeatedly every 2 seconds, starting after an initial delay of 3 seconds
                scheduledThreadPool.scheduleAtFixedRate(() -> {
                    System.out.println("Task executed every 2 seconds");
                }, 3, 2, TimeUnit.SECONDS);

    //             Schedule a task to run after a delay of 1 second
                scheduledThreadPool.schedule(() -> {
                    System.out.println("Task executed after 1 second");
                }, 1, TimeUnit.SECONDS);

    //            Thread.sleep(10000);
    //            scheduledThreadPool.shutdown();
                try {
                    scheduledThreadPool.awaitTermination(5, TimeUnit.SECONDS);
                    // Shutdown the executor after 10 seconds
                    scheduledThreadPool.shutdown();
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }
            }
        }
    }
}