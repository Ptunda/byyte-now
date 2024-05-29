package com.pluralsight.product;

public class Chip extends MenuItem {

    private double price;

    public Chip(String name) {

        super(name);
        this.price = 1.00;

    }

    public double getPrice(){

        return price;

    }

    @Override
    public void displayDetails() {

        System.out.println("Your order includes: " + getName());
        System.out.println("Product price: $" + this.price);

    }

}
