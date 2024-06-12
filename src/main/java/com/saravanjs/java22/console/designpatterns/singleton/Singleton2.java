package com.saravanjs.java22.console.designpatterns.singleton;

/**
 * @author Sarav on 19 Sep 2023
 * @project govtech
 * @package com.govtech.viswa.designpatterns.Singleton2
 * @class Singleton22
 */
public final class Singleton2 {
    private static Singleton2 instance;
    public String value;

    private Singleton2(String value) {
        // The following code emulates slow initialization.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.value = value;
    }

    public static Singleton2 getInstance(String value) {
        if (instance == null) {
            instance = new Singleton2(value);
        }
        return instance;
    }

    public static void main(String[] args) {
        System.out.println("If you see the same value, then singleton was reused (yay!)" + "\n" +
                "If you see different values, then 2 singletons were created (booo!!)" + "\n\n" +
                "RESULT:" + "\n");
        Singleton2 singleton = Singleton2.getInstance("FOO");
        Singleton2 anotherSingleton = Singleton2.getInstance("BAR");
        System.out.println(singleton.value);
        System.out.println(anotherSingleton.value);
    }
}