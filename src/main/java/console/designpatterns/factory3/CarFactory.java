package console.designpatterns.factory3;

/**
 * @author Sarav on 19 Sep 2023
 * @project govtech
 * @package com.govtech.viswa.designpatterns.factory3
 * @class MotorcycleFactory
 */
public class CarFactory extends MotorVehicleFactory {
    @Override
    protected MotorVehicle createMotorVehicle() {
        return new Car();
    }
}
