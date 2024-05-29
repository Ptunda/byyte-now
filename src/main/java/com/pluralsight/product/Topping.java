package com.pluralsight.product;

public abstract class Topping extends MenuItem {

    private final String toppingType;

    public Topping(String name, String toppingType) {
        super(name);
        this.toppingType = toppingType;
    }

    public String getToppingType() {
        return toppingType;
    }

    @Override
    public abstract void displayDetails();

}
