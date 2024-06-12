package com.saravanjs.java22.console.designpatterns.prototype;

/**
 * @author Sarav on 19 Sep 2023
 * @project govtech
 * @package com.govtech.viswa.designpatterns.prototype
 * @class PineTree
 */

public class PineTree extends Tree {

    private String type;

    public PineTree(double mass, double height) {
        super(mass, height);
        this.type = "Pine";
    }

    public String getType() {
        return type;
    }

    @Override
    public Tree copy() {
        PineTree pineTreeClone = new PineTree(this.getMass(), this.getHeight());
        pineTreeClone.setPosition(this.getPosition());
        return pineTreeClone;
    }

}
