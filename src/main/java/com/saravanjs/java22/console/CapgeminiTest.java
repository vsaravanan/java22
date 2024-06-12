package com.saravanjs.java22.console;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Sarav on 12 Jun 2024
 * @project govtech
 * @package com.saravanjs.java22.console
 * @class CapgeminiTest
 */
public class CapgeminiTest {
    public static void main(String[] args) {
        // arr1 7 9 12  17  120 9 12
        // arr2   5 8 11 20 3 2
        // combine remove the duplicates
        // print desc
        int arr1[] = {7, 9, 12, 17, 120, 9, 12};
        int arr2[] = {5, 8, 11, 20, 3, 2};
        int result[] = new int[arr1.length + arr2.length + 10];
//
//        int a = 0;
//        for (int i : arr1) {
//            for (int j : arr2) {
//                if (i < j) {
//                    result[a] = i;
//                } else if (i > j) {
//                    result[a] = j;
//                }
//                System.out.println(result[a]);
//                a++;
//            }
//        }
//        for (int i : result) {
//            System.out.print(i + " ");
//        }

        // list of 2 apples and 3 oranges and 4 grapes and 1 banana

        List<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("apple");
        fruits.add("orange");
        fruits.add("orange");
        fruits.add("orange");
        fruits.add("grape");
        fruits.add("grape");
        fruits.add("grape");
        fruits.add("grape");
        fruits.add("banana");
//        fruits.stream().sorted()
                //.distinct().forEach(System.out::println);

        String b = "123456789";

        for (char c : b.toCharArray()) {
            System.out.println(c);
        }
        IntStream stream = b.chars();

        stream.forEach(System.out::println);

        String str = "Hello, world!";
        Stream<Character> stream2 = str.chars().mapToObj(ch -> (char) ch);
        stream2.forEach(System.out::println);

//          b .chars().forEach(System.out::println);

//                  .filter(c -> c > 5).forEach(System.out::println);


    }
}
