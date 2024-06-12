package com.saravanjs.java22.console.multithreading.virtualthread.without;

/**
 * @author Sarav on 12 Jun 2024
 * @project govtech
 * @package com.saravanjs.java22.console.multithreading.virtualthread.without
 * @class TraditionalThreadExample
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TraditionalThreadExample {

    public static void main(String[] args) throws InterruptedException {
        int numThreads = 10;
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        for (int i = 0; i < numThreads; i++) {
            executor.execute(new SimulatedTask());
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
    }
}

class SimulatedTask implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            // Simulate some work
            Math.sqrt(i);
        }
    }
}
