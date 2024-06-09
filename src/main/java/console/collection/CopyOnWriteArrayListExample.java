package console.collection;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Sarav on 09 Jun 2024
 * @project govtech
 * @package console.collection
 * @class CopyOnWriteArrayListExample
 */

/*

    CopyOnWriteArrayList is a thread-safe variant of ArrayList in Java
    where all mutative operations (such as add, set, and remove) are implemented
    by making a fresh copy of the underlying array.
    This class is part of the java.util.concurrent package and is particularly useful
    in scenarios where reads are more frequent than writes.

    Thread Safety: Safe for concurrent use by multiple threads.
    Snapshot Iterators: Iterators do not reflect modifications made to the list after the iterator was created.
    Performance: Read operations (e.g., get, iterator, size) are usually faster than write operations (e.g., add, set, remove), as the latter involve copying the entire array.



    This class is thread-safe: All mutative operations (add, set, and remove) are atomic
    they either succeed completely, or they fail completely.

        Java Collections with Atomic Mutative Operations

        CopyOnWriteArrayList:
        All mutative operations are atomic.
        Suitable for scenarios with more reads than writes.

        ConcurrentHashMap:
        Supports atomic operations like put, remove, and replace.
        Optimized for concurrent access with high concurrency.

        ConcurrentLinkedQueue:
        Operations like offer, poll, and remove are atomic.
        Designed for concurrent access.

        ConcurrentSkipListMap:
        Operations such as put, remove, and replace are atomic.
        Sorted map suitable for concurrent access.

        ConcurrentSkipListSet:
        Operations such as add, remove, and replace are atomic.
        Sorted set suitable for concurrent access.

 */

public class CopyOnWriteArrayListExample {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();

        // Adding elements
        list.add("A");
        list.add("B");
        list.add("C");

        System.out.println("Initial list: " + list);

        // Iterate over the list
        for (String item : list) {
            System.out.println("Item: " + item);
            // Modifying the list during iteration
            list.add("D");
        }

        System.out.println("Final list: " + list);
    }
}
