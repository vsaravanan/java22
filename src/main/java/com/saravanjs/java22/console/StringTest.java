package com.saravanjs.java22.console;

/**
 * @author Sarav on 14 Jun 2024
 * @project govtech
 * @package com.saravanjs.java22.console
 * @class StringTest
 */
public class StringTest {
    public static void main(String[] args) {

        // Compare references using interned strings
        String str3 = "Hello";
        String str4 = "Hello";
        if (str3 == str4) {
            System.out.println("str3 and str4 are the same object");
        } else {
            System.out.println("str3 and str4 are different objects");
        }

        String str1 = new String("Hello");
        String str2 = new String("Hello");

        // Compare references
        if (str1 == str2) {
            System.out.println("str1 and str2 are the same object");
        } else {
            System.out.println("str1 and str2 are different objects");
        }


        // Compare content
        if (str1.equals(str2)) {
            System.out.println("str1 and str2 have the same content");
        } else {
            System.out.println("str1 and str2 have different content");
        }

        String s1 = "saravanan";
        String s2 = "saravanan";
//        s2 = "java";

        // Compare references
        if (s1 == s2) {
            System.out.println("s1 and s2 are the same object " + s1.hashCode() + "  " + s2.hashCode());
        } else {
            System.out.println("s1 and s2 are different objects " + s1.hashCode() + "  " + s2.hashCode());
        }


        // Compare content
        if (s1.equals(s2)) {
            System.out.println("s1 and s2 have the same content " + s1.hashCode() + "  " + s2.hashCode());
        } else {
            System.out.println("s1 and s2 have different content " + s1.hashCode() + "  " + s2.hashCode()) ;
        }

    }
}
