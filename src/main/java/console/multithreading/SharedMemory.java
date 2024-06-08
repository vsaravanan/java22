package console.multithreading;

/**
 * @author Sarav on 07 Jun 2024
 * @project govtech
 * @package console.multithreading
 * @class SharedMemory
 */
public class SharedMemory {
    private int counter = 0;

    public synchronized void increment() {
        counter++;
    }

    public synchronized int getCounter() {
        return counter;
    }

    public static void main(String[] args) throws InterruptedException {
        SharedMemory sharedMemory = new SharedMemory();
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    sharedMemory.increment();
                    System.out.println( Thread.currentThread().getName() + " Counter value: " + sharedMemory.getCounter() );
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Final counter value: " + sharedMemory.getCounter());  // Should print 1000
    }
}

