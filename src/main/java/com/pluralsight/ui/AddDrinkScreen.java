package com.pluralsight.ui;

import com.pluralsight.product.Drink;
import com.pluralsight.service.Order;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class AddDrinkScreen {

    private final Order order;

    public AddDrinkScreen(Order order) {
        this.order = order;
    }

    public void display() {

        Scanner scanner = new Scanner(System.in);

        HashMap<String, String> drinks = new HashMap<>();
        drinks.put("General", "Water, Sparkling water");
        drinks.put("Soft Drinks", "Coke, Pepsi, Sprite");
        drinks.put("Tropical", "Kombucha, Coconut water");
        drinks.put("Juices", "Lemonade, Grape juice, Fresh juice");
        drinks.put("Alcohols", "Red wine, Hard root beer");
        drinks.put("Others", "Iced tea, Ginger Ale, Milk");

        Set<String> drinksKeys = drinks.keySet();

        System.out.println("--------Byyte Now Drinks---------");

        for (String drinksKey : drinksKeys) {

            System.out.print(drinksKey + ": ");
            System.out.println(drinks.get(drinksKey));

        }


        // Create a set of all drink names
        Set<String> validDrinks = new HashSet<>();

        for (String drinkList : drinks.values()) {

            String[] drinkNames = drinkList.split(", ");

            for (String drinkName : drinkNames) {

                validDrinks.add(drinkName.toLowerCase());

            }
        }

        String name;

        // Validate user input
        while (true) {

            System.out.println("\nEnter drink name:");
            name = scanner.nextLine().toLowerCase().trim();

            if (validDrinks.contains(name)) {

                System.out.println("You selected a valid drink: " + name);
                break; // Exit the loop if the drink is valid

            } else {

                System.out.println("Invalid drink name. Please try again.");

            }
        }

        HashMap<String, String> drinkSize = new HashMap<>();
        drinkSize.put("small", "$2.00");
        drinkSize.put("medium", "$2.50");
        drinkSize.put("large", "$3.00");

        Set<String> sizeKeys = drinkSize.keySet();

        System.out.println("\nAvailable drink sizes and prices");

        for (String sizeKey : sizeKeys) {

            System.out.print(sizeKey + " = ");
            System.out.println(drinkSize.get(sizeKey));

        }

        System.out.println("\nSelect a drink size\nsmall\nmedium\nlarge");
        String size = scanner.nextLine().toLowerCase().trim();

        // validate user input
        if (!drinkSize.containsKey(size)){

            System.out.println("Invalid input. Please enter correct size");
            return;
        }


        Drink drink = new Drink(name, size);
        order.addDrink(drink);

    }


}
