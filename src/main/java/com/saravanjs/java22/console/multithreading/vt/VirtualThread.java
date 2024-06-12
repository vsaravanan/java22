package com.saravanjs.java22.console.multithreading.vt;


public class VirtualThread {
    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();

        // Create and start traditional threads
        for (int i = 0; i < 1000; i++) {
            int id = i;
            Thread.startVirtualThread(() -> {
                try {
                    System.out.println(service.performTask(id));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        // Allow time for virtual threads to complete
        Thread.sleep(20000);
    }
}
