package com.pluralsight.product;

public class Chip extends MenuItem {

    public Chip(String name, double price) {

        super(name, price);

    }

    @Override
    public void displayDetails() {

        System.out.println("Product name: " + getName());
        System.out.println("Product price: " + getPrice());

    }

}
