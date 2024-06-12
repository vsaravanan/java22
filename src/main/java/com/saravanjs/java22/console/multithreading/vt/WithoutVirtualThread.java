package com.saravanjs.java22.console.multithreading.vt;

/**
 * @author Sarav on 12 Jun 2024
 * @project govtech
 * @package com.saravanjs.java22.console.multithreading
 * @class WithoutVirtualThread
 */

class MyService {
    public String performTask(int id) throws InterruptedException {
        // Simulate a blocking IO operation
        Thread.sleep(10000);
        return "Task " + id + " Completed";
    }
}
public class WithoutVirtualThread {
    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();

        // Create and start traditional threads
        for (int i = 0; i < 1000; i++) {
            int id = i;
            Thread thread = new Thread(() -> {
                try {
                    System.out.println(service.performTask(id));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }
    }
}
