package com.pluralsight.ui;

import com.pluralsight.product.Drink;
import com.pluralsight.service.Order;

import java.util.Scanner;


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

        System.out.println("Select drink size: (small, medium, large)");
        String size = scanner.nextLine().toLowerCase().trim();

        Drink drink = new Drink(name, size);
        order.addDrink(drink);

    }


}
