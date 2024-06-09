package console.collection;

/**
 * @author Sarav on 16 Apr 2024
 * @project govtech
 * @package com.govtech.demo.console
 * @class ConcurrentHashMapExample
 */
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        // Thread 1
        new Thread(() -> {
            map.put("D", 4);
            System.out.println("Thread 1: " + map);
        }).start();

        // Thread 2
        new Thread(() -> {
            map.put("E", 5);
            System.out.println("Thread 2: " + map);
        }).start();

        System.out.println("Main thread: " + map);
    }
}
