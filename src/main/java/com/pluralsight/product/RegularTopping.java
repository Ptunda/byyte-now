package com.pluralsight.product;

public class RegularTopping extends Topping {

    public RegularTopping(String name, String toppingType, boolean isExtra) {

        super(name, toppingType, isExtra);

    }

    @Override
    public void displayDetails() {

        System.out.println("For your " + getToppingType() + "s you have.");
        System.out.println("Name: " + getName());
        System.out.println("You want extra toppings: " + (isExtra() ? "Yes" : "No"));

    }
}
