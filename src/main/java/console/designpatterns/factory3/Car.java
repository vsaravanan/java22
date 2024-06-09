package console.designpatterns.factory3;

/**
 * @author Sarav on 19 Sep 2023
 * @project govtech
 * @package com.govtech.viswa.designpatterns.factory3
 * @class Motorcycle
 */
public class Car implements MotorVehicle {
    @Override
    public void build() {
        System.out.println("Build Car");
    }
}
