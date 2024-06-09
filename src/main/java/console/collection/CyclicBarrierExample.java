package console.collection;

import java.lang.ref.Cleaner;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;

/**
 * @author Sarav on 09 Jun 2024
 * @project govtech
 * @package console.collection
 * @class CyclicBarrierExample
 */

/*

CyclicBarrier is a synchronization aid in Java that allows a set of threads to all wait for each other to reach a common barrier point. This barrier is cyclic because it can be reused after the waiting threads are released. This is particularly useful in scenarios where you need to wait for a number of threads to reach a common point before proceeding further.

Key Characteristics
Reusability: The barrier can be reused after the waiting threads are released.
Barrier Action: An optional Runnable command can be executed once all threads have reached the barrier.
Synchronization Point: Ensures that threads wait for each other to reach a certain point in execution.


 */

public class CyclicBarrierExample {

    public static void main(String[] args) {
        var service = Executors.newFixedThreadPool(3);
        try {
            CyclicBarrier c1 = new CyclicBarrier(3, () -> System.out.println("All cleaning is done, lets turn off the lights, activate alarm and go home!"));

            CyclicBarrierExample cleaner = new CyclicBarrierExample();
            for (int i = 0; i < 3; i++) {
                service.submit(() -> cleaner.clean(c1));
            }
        } finally {
            service.shutdown();
        }
    }

    private void clean(CyclicBarrier c1) {
        try {
            vacuumFloor();
            Thread.sleep(Math.round(Math.random() * 1000));
            coffeeBreak();
            Thread.sleep(Math.round(Math.random() * 1000));
            mopFloor();
            Thread.sleep(Math.round(Math.random() * 1000));
            c1.await();
            turnOffLights();
            activateAlarm();
        } catch (InterruptedException | BrokenBarrierException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void vacuumFloor() {
        System.out.println("Vacuming the floor...");
    }
    private void mopFloor() {
        System.out.println("Mopping the floor...");
    }

    private void coffeeBreak() {
        System.out.println("Time for a break!");
    }
    private void turnOffLights() {
        System.out.println("Turning off the lights...");
    }
    private void activateAlarm() {
        System.out.println("Activating the alarm...");
    }
}