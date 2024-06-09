package console.designpatterns.bridge;

/**
 * @author Sarav on 07 May 2024
 * @project govtech
 * @package com.govtech.viswa.designpatterns.bridge
 * @class Bridge
 */

interface Shape {
    void draw();
}

abstract class ShapeType implements Shape {
    protected RenderingMode renderingMode;

    public ShapeType(RenderingMode renderingMode) {
        this.renderingMode = renderingMode;
    }

//    public abstract void drawShape();
}

class Circle extends ShapeType {

    public Circle(RenderingMode renderingMode) {
        super(renderingMode);
    }

    @Override
    public void draw() {
        System.out.print("Drawing a ");
        renderingMode.render();
    }
}

class Rectangle extends ShapeType {
    public Rectangle(RenderingMode renderingMode) {
        super(renderingMode);
    }

    @Override
    public void draw() {
        System.out.print("Drawing a ");
        renderingMode.render();
    }
}

// Other shape types...

interface RenderingMode {
    void render();
}

class TwoDRendering implements RenderingMode {
    public void render() {
        System.out.println("2D shape");
    }
}

class ThreeDRendering implements RenderingMode {
    public void render() {
        System.out.println("3D shape");
    }
}

public class Bridge {
    public static void main(String[] args) {
        RenderingMode twoD = new TwoDRendering();
        RenderingMode threeD = new ThreeDRendering();

        Shape circle = new Circle(twoD);
        Shape rectangle = new Rectangle(threeD);

        circle.draw();
        rectangle.draw();
    }
}
