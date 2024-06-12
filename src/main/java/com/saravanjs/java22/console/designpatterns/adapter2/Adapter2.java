package com.saravanjs.java22.console.designpatterns.adapter2;

/**
 * @author Sarav on 07 May 2024
 * @project govtech
 * @package com.govtech.viswa.designpatterns.adapter2
 * @class Adapter2
 */

// Target interface
interface Target {
    void request();
}

// Adaptee class with incompatible interface
class Adaptee {
    void specificRequest() {
        System.out.println("Adaptee's specific request");
    }
}

// Adapter class implementing the Target interface
class Adapter implements Target {
    private Adaptee adaptee;

    Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest(); // Delegating the request to the Adaptee
    }
}

// Client code
public class Adapter2 {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Target adapter = new Adapter(adaptee);
        adapter.request(); // Client code interacts with the Adapter, which delegates the request to the Adaptee
    }
}
