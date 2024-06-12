package com.saravanjs.java22.console.designpatterns.prototype;

/**
 * @author Sarav on 19 Sep 2023
 * @project govtech
 * @package com.govtech.viswa.designpatterns.prototype
 * @class PlasticTree
 */



public class PlasticTree extends Tree {

    private String name;

    public PlasticTree(double mass, double height) {
        super(mass, height);
        this.name = "PlasticTree";
    }

    public String getName() {
        return name;
    }

    @Override
    public Tree copy() {
        PlasticTree plasticTreeClone = new PlasticTree(this.getMass(), this.getHeight());
        plasticTreeClone.setPosition(this.getPosition());
        return plasticTreeClone;
    }

}