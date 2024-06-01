package com.pluralsight.ui;

import com.pluralsight.product.Drink;
import com.pluralsight.service.Order;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;


public class AddDrinkScreen {

    private final Order order;

    public AddDrinkScreen(Order order) {
        this.order = order;
    }

    public void display() {

        Scanner scanner = new Scanner(System.in);

        String[] drinks = {"General: Water, Sparkling water", "Soft Drinks: Coke, Pepsi, Sprite", "Tropical: Kombucha, Coconut water",
                "Lemonade, Grape juice, Fresh juice", "Alcohols: Red wine, Hard root beer", "Others: Iced tea, Ginger Ale, Milk"};


        System.out.println("--------Byyte Now Drinks---------");
        for (String drink : drinks) {

            System.out.println(drink);
            System.out.println();

        }


        System.out.println("Enter drink name:");
        String name = scanner.nextLine().toLowerCase().trim();

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
            return;
        }

        Drink drink = new Drink(name, size);
        order.addDrink(drink);

    }


}
