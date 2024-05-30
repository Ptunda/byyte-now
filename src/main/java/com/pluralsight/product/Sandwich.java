package com.pluralsight.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sandwich extends MenuItem {

    private String size;
    private String breadType;
    private final List<Topping> toppings;
    private boolean isToasted;
    private double price;

    public Sandwich(String name, String size, String breadType, boolean isToasted) {
        super(name);
        this.size = size;
        this.breadType = breadType;
        this.toppings = new ArrayList<>();
        this.isToasted = isToasted;

        setPrice(size);

    }


    public String getSize() {

        return size;

    }

    public String getBreadType() {

        return breadType;

    }

    public boolean isToasted() {

        return isToasted;

    }


    public void setPrice(String size) {

        switch (size) {

            case "4":
                price = 5.50;
                break;
            case "8":
                price = 7.00;
                break;
            case "12":
                price = 8.50;
                break;
            default:
                throw new IllegalArgumentException("Invalid sandwich size: " + size);

        }

    }

    public double getPrice() {

        return calculatePrice();

    }


    public void customize() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter new size (4, 8, 12):");
        this.size = scanner.nextLine().trim();

        System.out.println("Enter new bread type:");
        this.breadType = scanner.nextLine().toLowerCase().trim();

        System.out.println("Do you want it toasted? (yes/no):");
        String toastedResponse = scanner.nextLine().toLowerCase().trim();
        this.isToasted = toastedResponse.equalsIgnoreCase("yes");

        System.out.println("Customization complete.");

    }


    public void addTopping(Topping topping) {

        this.toppings.add(topping);
        System.out.println("Added topping: " + topping.getName() + " (" + topping.getToppingType() + ")");

    }


    public double calculatePrice() {

        double totalPrice = price;

        for (Topping topping : toppings) {

            if (topping instanceof PremiumTopping) {

                totalPrice += ((PremiumTopping) topping).getPrice();

            }

        }

        return totalPrice;

    }


    @Override
    public void displayDetails() {

        System.out.println("Sandwich Details:");
        System.out.println("Name: " + getName());
        System.out.println("Size: " + size + "\"");
        System.out.println("Bread Type: " + breadType);
        System.out.println("Toasted: " + (isToasted ? "Yes" : "No") + "\n");
        System.out.println("Toppings:");
        for (Topping topping : toppings) {
            topping.displayDetails();
            System.out.println();
        }
        System.out.println("Your total cost for the sandwich is: $" + getPrice());

    }
}
