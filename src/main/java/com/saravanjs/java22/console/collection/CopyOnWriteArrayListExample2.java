package com.saravanjs.java22.console.collection;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Sarav on 27 Sep 2023
 * @project govtech
 * @package com.govtech.viswa.collections.concurrenthashmap
 * @class CopyOnWriteArrayList
 */


public class CopyOnWriteArrayListExample2 {

    /*

    https://raw.githubusercontent.com/vsaravanan/java22/master/src/main/java/console/collection/CopyOnWriteArrayListExample2.java


        CopyOnWriteArrayList allows the reader and writer threads to operate concurrently
        without the need for external synchronization.
        Readers will see a consistent snapshot of the list even if its modified by the writer thread

        High Read Performance:
        Low Write Performance: Write operations (add, set, remove, etc.) are relatively expensive
        CopyOnWriteArrayList is not suitable for use cases with frequent write operations.
        Thread Safety: CopyOnWriteArrayList achieves thread safety
           by creating a new copy of the underlying array every time there is a modification



     */


    public static void main(String[] args) throws InterruptedException {

        List<String> copyOnWriteList = new CopyOnWriteArrayList<>();

        Runnable myTask = new Runnable() {
            public void run() {
                for (String name : copyOnWriteList) {
                    System.out.println("Read: " + name);
                }
            }
        };

        copyOnWriteList.add("Alice");
        copyOnWriteList.add("Bob");
        copyOnWriteList.add("Charlie");

        // Create a thread for reading
        Thread readerThread = new Thread(myTask);

        // Create a thread for writing
        Thread writerThread = new Thread(() -> {
            copyOnWriteList.add("David");
            copyOnWriteList.remove("Alice");
        });

        readerThread.start();
        writerThread.start();

        Thread.sleep(1000);

        Thread readerThread2 = new Thread(myTask);
        readerThread2.start();

    }


}