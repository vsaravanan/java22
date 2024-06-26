package com.saravanjs.java22.console.designpatterns.prototype;

/**
 * @author Sarav on 19 Sep 2023
 * @project govtech
 * @package com.govtech.viswa.designpatterns.prototype
 * @class Tree
 */

public abstract class Tree {

    private double mass;
    private double height;
    private Position position;

    public Tree(double mass, double height) {
        this.mass = mass;
        this.height = height;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public double getMass() {
        return mass;
    }

    public double getHeight() {
        return height;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Tree [mass=" + mass + ", height=" + height + ", position=" + position + "]";
    }

    public abstract Tree copy();
}