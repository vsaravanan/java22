package console.designpatterns.prototype2;

/**
 * @author Sarav on 07 May 2024
 * @project govtech
 * @package com.govtech.viswa.designpatterns.prototype2
 * @class Prototype2
 */

interface Shape extends Cloneable {
    void draw();
    Shape clone();
}

class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing a circle");
    }

    @Override
    public Circle clone() {
        try {
            return (Circle) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning not supported", e);
        }
    }
}

class Rectangle implements Shape {
    public void draw() {
        System.out.println("Drawing a rectangle");
    }

    @Override
    public Rectangle clone() {
        try {
            return (Rectangle) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning not supported", e);
        }
    }
}

public class Prototype2 {
    public static void main(String[] args) {
        Shape circlePrototype = new Circle();
        Shape rectanglePrototype = new Rectangle();

        Shape circle1 = circlePrototype.clone();
        Shape circle2 = circlePrototype.clone();
        Shape rectangle1 = rectanglePrototype.clone();
        Shape rectangle2 = rectanglePrototype.clone();
        circle1.draw();
        circle2.draw();
        rectangle1.draw();
        rectangle2.draw();

    }
}