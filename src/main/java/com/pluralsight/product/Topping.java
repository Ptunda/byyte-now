package com.pluralsight.product;

public abstract class Topping extends MenuItem {

    private final String toppingType;
    private final boolean isExtra;

    public Topping(String name, String toppingType, boolean isExtra) {
        super(name);
        this.toppingType = toppingType;
        this.isExtra = isExtra;
    }

    public String getToppingType() {
        return toppingType;
    }

    public boolean isExtra() {
        return isExtra;
    }

    @Override
    public abstract void displayDetails();

}
