package console.multithreading;

import java.util.concurrent.CountDownLatch;

/**
 * @author Sarav on 09 Jun 2024
 * @project govtech
 * @package console.multithreading
 * @class CountDownLatchExample
 */

// Suppose we have a server-side core Java application that uses a services architecture,
// where multiple services are provided by multiple threads.
// The application cannot start processing until all services have started successfully.
// In this scenario, we can use CountDownLatch to ensure that the main thread waits until
// all services have started before proceeding with further processing


public class CountDownLatchExample {
    private static final int NUM_SERVICES = 3;
    private static final CountDownLatch latch = new CountDownLatch(NUM_SERVICES);

    public static void main(String[] args) {
        // Start the services in separate threads
        for (int i = 0; i < NUM_SERVICES; i++) {
            Thread serviceThread = new Thread(new Service());
            serviceThread.start();
        }

        try {
            // Wait for all services to start
            System.out.println("Waiting for " + latch.getCount() +  " services to start");
            latch.await();
            System.out.println("All services have started. Proceeding with further processing...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Service implements Runnable {
        @Override
        public void run() {
            // Simulate some processing
            try {
                Thread.sleep(2000);
                System.out.println("Started ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Service has started, decrement the latch count
            latch.countDown();
        }
    }
}
