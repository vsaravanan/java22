package console.designpatterns.decorator;

/**
 * @author Sarav on 07 May 2024
 * @project govtech
 * @package com.govtech.viswa.designpatterns.decorator
 * @class Decorator
 */

// Step 1: Component interface
interface Topping {
    String getDescription();
}

class Beverage implements Topping {
    private String description = "Beverage";

    public String getDescription() {
        return description;
    }
}

class WhippedCream implements Topping {
    private Topping beverage;

    public WhippedCream(Topping beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Whipped Cream";
    }
}

class ChocolateSyrup implements Topping {
    private Topping beverage;

    public ChocolateSyrup(Topping beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Chocolate Syrup";
    }
}

public class Decorator {
    public static void main(String[] args) {
        Beverage beverage = new Beverage();
        System.out.println(beverage.getDescription());

        Topping beverageWithWhippedCream = new WhippedCream(beverage);
        System.out.println(beverageWithWhippedCream.getDescription());

        Topping beverageWithChocolateSyrup = new ChocolateSyrup(beverage);
        System.out.println(beverageWithChocolateSyrup.getDescription());
    }
}