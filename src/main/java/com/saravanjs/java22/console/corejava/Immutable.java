package com.saravanjs.java22.console.corejava;

import java.util.Date;

/**
 * @author Sarav on 17 Jun 2024
 * @project govtech
 * @package com.saravanjs.java22.console.corejava
 * @class Immutable
 */

final class Person {
    private final String name;
    private final int age;
    private final Date birthDate;

    public Person(String name, int age, Date birthDate) {
        this.name = name;
        this.age = age;
        // Create a defensive copy of the mutable Date object
        this.birthDate = new Date(birthDate.getTime());
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Date getBirthDate() {
        // Return a defensive copy of the mutable Date object
        return new Date(birthDate.getTime());
    }
}
public class Immutable {
    public static void main(String[] args) {
        Date birthDate = new Date();
        Person person = new Person("John Doe", 30, birthDate);

        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        System.out.println("Birth Date: " + person.getBirthDate());

        // Attempt to modify the birthDate object
        birthDate.setTime(0);
        System.out.println("Variable : " + birthDate);

        // Verify that the birthDate inside Person is not affected
        System.out.println("Modified Birth Date: " + person.getBirthDate());
    }
}
