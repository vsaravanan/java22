package com.saravanjs.java22.console.multithreading.virtualthread.with;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.LockSupport;

/**
 * @author Sarav on 12 Jun 2024
 * @project govtech
 * @package com.saravanjs.java22.console.multithreading.virtualthread.with
 * @class VirtualThreadDemo
 */

public class VirtualThreadDemo {
    public static void main(String[] args) {
        final int NTASKS = 100;
        ExecutorService service = Executors.newVirtualThreadPerTaskExecutor();
        for (int i = 0; i < NTASKS; i++) {
            service.submit(() -> {
                long id = Thread.currentThread().threadId();
                LockSupport.parkNanos(1_000_000_000);
                System.out.println(id);
            });
        }
        service.close();
    }
}
