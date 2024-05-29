package com.pluralsight.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sandwich extends MenuItem{

    private String size;
    private String breadType;
    private final List<Topping> toppings;
    private boolean isToasted;

    public Sandwich(String name, String size, String breadType, boolean isToasted) {
        super(name);
        this.size = size;
        this.breadType = breadType;
        this.isToasted = isToasted;
        this.toppings = new ArrayList<>();

    }


    public String getSize(){

        return size;

    }

    public String getBreadType(){

        return breadType;

    }

    public boolean isToasted() {

        return isToasted;

    }


    public void customize(){

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


    public void addTopping(Topping topping){

        this.toppings.add(topping);
        System.out.println("Added topping: " + topping.getName() + " (" + topping.getToppingType() + ")");

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

    }
}
