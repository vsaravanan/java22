package com.saravanjs.java22.console.designpatterns.factory;


import com.saravanjs.java22.console.designpatterns.factory.abstracts.Computer;

/**
 * @author Sarav on 18 Sep 2023
 * @project govtech
 * @package com.govtech.viswa.mains
 * @class ComputerFactory
 */
public class ComputerFactory {

    public static Computer getComputer(String type, String ram, String hdd, String cpu){
        if("PC".equalsIgnoreCase(type))
            return new PC(ram, hdd, cpu);
        else if("Server".equalsIgnoreCase(type))
            return new Server(ram, hdd, cpu);

        return null;
    }
}