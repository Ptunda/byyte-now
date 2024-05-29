package com.pluralsight.product;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends MenuItem{

    private final String size;
    private final String breadType;
    private final List<Topping> toppings;
    private final boolean isToasted;

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
        System.out.println("Toasted: " + (isToasted ? "Yes" : "No"));
        System.out.println("Toppings:");
        for (Topping topping : toppings) {
            topping.displayDetails();
        }

    }
}
