package com.saravanjs.java22.console.designpatterns.factory.abstracts;

/**
 * @author Sarav on 18 Sep 2023
 * @project govtech
 * @package com.govtech.viswa.designpatterns.factory.abstracts
 * @class Computer
 */
public abstract class Computer {

    public abstract String getRAM();
    public abstract String getHDD();
    public abstract String getCPU();

    @Override
    public String toString(){
        return "RAM= "+this.getRAM()+", HDD="+this.getHDD()+", CPU="+this.getCPU();
    }
}
