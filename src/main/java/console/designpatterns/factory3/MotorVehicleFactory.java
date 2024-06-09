package console.designpatterns.factory3;

/**
 * @author Sarav on 19 Sep 2023
 * @project govtech
 * @package com.govtech.viswa.designpatterns.factory3
 * @class MotorVehicleFactory
 */
public abstract class MotorVehicleFactory {
    public MotorVehicle create() {
        MotorVehicle vehicle = createMotorVehicle(); // I will create the object for you
        vehicle.build(); // I will build the object for you
        return vehicle;  // I will return the object to you
        // these tasks are predesigned and are common to all vehicles
        // all these are encapsulated
    }
    protected abstract MotorVehicle createMotorVehicle();
}