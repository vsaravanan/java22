package com.saravanjs.java22.console.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Sarav on 09 Jun 2024
 * @project govtech
 * @package console.collection
 * @class ConcurrentHashMapExample
 */


/*

// https://raw.githubusercontent.com/vsaravanan/java22/master/src/main/java/console/collection/ConcurrentHashMapExample.java

ConcurrentHashMap

ConcurrentHashMap is a thread-safe variant of HashMap that allows concurrent access and modification.
Key Characteristics
•	Thread Safety: Multiple threads can operate on the map concurrently
    without the need for explicit synchronization.
•	Performance: It provides better performance compared to
    Collections.synchronizedMap due to finer-grained locking.
•	Atomic Operations: Supports atomic operations like putIfAbsent, remove, replace, etc.

 */
public class ConcurrentHashMapExample {
    public static void main(String[] args) {

        //ConcurrentHashMap
        Map<String,String> myMap = new ConcurrentHashMap<String,String>();
        myMap.put("1", "1");
        myMap.put("2", "1");
        myMap.put("3", "1");
        myMap.put("4", "1");
        myMap.put("5", "1");
        myMap.put("6", "1");
        System.out.println("ConcurrentHashMap before iterator: "+myMap);
        Iterator<String> it = myMap.keySet().iterator();

        while(it.hasNext()){
            String key = it.next();
            if(key.equals("3")) myMap.put(key+"new", "new3");
        }
        System.out.println("ConcurrentHashMap after iterator: "+myMap);

        //HashMap
        myMap = new HashMap<String,String>();
        myMap.put("1", "1");
        myMap.put("2", "1");
        myMap.put("3", "1");
        myMap.put("4", "1");
        myMap.put("5", "1");
        myMap.put("6", "1");
        System.out.println("HashMap before iterator: "+myMap);
        Iterator<String> it1 = myMap.keySet().iterator();

        while(it1.hasNext()){
            String key = it1.next();
            if(key.equals("3")) {
                myMap.put(key+"new", "new3");
                break; // comment and try to get ConcurrentModificationException
            }
        }
        System.out.println("HashMap after iterator: "+myMap);
    }
}

