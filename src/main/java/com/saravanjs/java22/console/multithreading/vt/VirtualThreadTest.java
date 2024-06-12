package com.saravanjs.java22.console.multithreading.vt;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Sarav on 12 Jun 2024
 * @project govtech
 * @package com.saravanjs.java22.console.multithreading
 * @class VirtualThreadTest
 */
public class VirtualThreadTest {

    public static void main(String[] args) throws InterruptedException {
        // Traditional Threads
        System.out.println("Traditional Threads:");
        ExecutorService traditionalExecutor = Executors.newFixedThreadPool(2);
        traditionalExecutor.submit(() -> {
            System.out.println("Traditional ThreadA started");
            try {
                Thread.sleep(2000); // Simulating some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Traditional ThreadA completed");
        });
        traditionalExecutor.submit(() -> {
            System.out.println("Traditional ThreadB started");
            try {
                Thread.sleep(3000); // Simulating some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Traditional ThreadB completed");
        });
        traditionalExecutor.shutdown();

        // Virtual Threads
        System.out.println("\nVirtual Threads:");

        ExecutorService virtualExecutor = Executors.newVirtualThreadPerTaskExecutor();
        virtualExecutor.submit(() -> {
            System.out.println("Virtual ThreadA started");
            try {
                Thread.sleep(2000); // Simulating some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Virtual ThreadA completed");
        });
        virtualExecutor.submit(() -> {
            System.out.println("Virtual ThreadB started");
            try {
                Thread.sleep(3000); // Simulating some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Virtual ThreadB completed");
        });
        virtualExecutor.shutdown();

        Thread.sleep(20000);
    }
}
