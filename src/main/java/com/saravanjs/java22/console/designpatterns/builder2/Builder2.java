package com.saravanjs.java22.console.designpatterns.builder2;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sarav on 07 May 2024
 * @project govtech
 * @package com.govtech.viswa.designpatterns.builder2
 * @class Tr
 */

@Data
class Pizza {
    private String size;
    private String crustType;
    private boolean cheese;
    private List<String> toppings;

    private Pizza(Builder builder) {
        this.size = builder.size;
        this.crustType = builder.crustType;
        this.cheese = builder.cheese;
        this.toppings = builder.toppings;
    }

    // Getters
    // You can add setters if needed

    // Static inner Builder class
    static class Builder {
        private String size;
        private String crustType;
        private boolean cheese;
        private List<String> toppings = new ArrayList<>();

        public Builder size(String size) {
            this.size = size;
            return this;
        }

        public Builder crustType(String crustType) {
            this.crustType = crustType;
            return this;
        }

        public Builder cheese(boolean cheese) {
            this.cheese = cheese;
            return this;
        }

        public Builder addTopping(String topping) {
            this.toppings.add(topping);
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }
}

public class Builder2 {
    public static void main(String[] args) {
//        Pizza pizza1 = new Pizza(); // direct creation is not allowed
        Pizza pizza = new Pizza.Builder()
                .size("Large")
                .crustType("Thin crust")
                .cheese(true)
                .addTopping("Pepperoni")
                .addTopping("Mushrooms")
                .build();

        System.out.println("Pizza details:");
        System.out.println("Size: " + pizza.getSize());
        System.out.println("Crust Type: " + pizza.getCrustType());
        System.out.println("Cheese: " + pizza.isCheese());
        System.out.println("Toppings: " + pizza.getToppings());
    }
}
