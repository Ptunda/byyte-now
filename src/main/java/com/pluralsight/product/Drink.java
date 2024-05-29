package com.pluralsight.product;

public class Drink extends MenuItem {

    private final String size;
    private double price;

    public Drink(String name, String size) {
        super(name);
        this.size = size;

        setPrice(size);

    }

    private void setPrice(String size) {

        switch (size.toLowerCase()) {

            case "small":
                this.price = 2.00;
                break;
            case "medium":
                this.price = 2.50;
                break;
            case "large":
                this.price = 3.00;
                break;
            default:
                throw new IllegalArgumentException("Invalid size: " + size);

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
