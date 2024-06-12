package com.saravanjs.java22.console.designpatterns.factory;


import com.saravanjs.java22.console.designpatterns.factory.abstracts.Computer;

/**
 * @author Sarav on 18 Sep 2023
 * @project govtech
 * @package com.govtech.viswa.mains
 * @class Server
 */

public class Server extends Computer {

    private String ram;
    private String hdd;
    private String cpu;

    public Server(String ram, String hdd, String cpu){
        this.ram=ram;
        this.hdd=hdd;
        this.cpu=cpu;
    }
    @Override
    public String getRAM() {
        return this.ram;
    }

    @Override
    public String getHDD() {
        return this.hdd;
    }

    @Override
    public String getCPU() {
        return this.cpu;
    }

}
