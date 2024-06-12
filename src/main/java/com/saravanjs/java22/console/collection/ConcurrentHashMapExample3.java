package com.saravanjs.java22.console.collection;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Sarav on 09 Jun 2024
 * @project govtech
 * @package console.collection
 * @class ConcurrentHashMapExample3
 */

// https://raw.githubusercontent.com/vsaravanan/java22/master/src/main/java/console/collection/ConcurrentHashMapExample3.java

public class ConcurrentHashMapExample3 {

    public static void main(String[] args) {
        // Create a ConcurrentHashMap
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        // Create a fixed thread pool
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // Create and submit tasks to the executor service
        for (int i = 0; i < 3; i++) {
            executorService.submit(() -> {
                for (int j = 0; j < 5; j++) {
                    String key = "key" + j;
                    map.compute(key, (k, v) -> v == null ? 1 : v + 1);
                    System.out.println(Thread.currentThread().getName() + " updated " + key + " to " + map.get(key));
                }
            });
        }

        // Shutdown the executor service
        executorService.shutdown();

        // Wait for all tasks to complete
        while (!executorService.isTerminated()) {}

        // Print the final map
        System.out.println("Final map: " + map);
    }
}
