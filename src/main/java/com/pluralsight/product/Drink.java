package com.pluralsight.product;

public class Drink extends MenuItem{

    private final String size;
    private double price;

    public Drink(String name, String size) {
        super(name);
        this.size = size;

        if (size.equalsIgnoreCase("small")){

            this.price = 2.00;

        } else if (size.equalsIgnoreCase("medium")) {

            this.price = 2.50;

        } else if (size.equalsIgnoreCase("large")) {

            this.price = 3.00;

        }

    }

    public String getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public void displayDetails() {

        System.out.println("You ordered a: " + getName());
        System.out.println("Size: " + size);
        System.out.println("Total cost : $" + this.price);

    }
}
