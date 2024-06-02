package com.pluralsight.ui;

import com.pluralsight.product.Chip;
import com.pluralsight.service.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class AddChipScreen {

    private final Order order;

    public AddChipScreen(Order order) {

        this.order = order;

    }

    public void display() {

        Scanner scanner = new Scanner(System.in);

        List<String> chips = new ArrayList<>();
        chips.add("Classic potato chips");
        chips.add("Kettle cooked chips");
        chips.add("Tortilla chips");
        chips.add("Veggie chips");

        System.out.println("--------Byyte Now Chips---------");
        System.out.println("*Get any chips for $1.50*");

        for (String chip : chips) {

            System.out.println(chip);

        }

        System.out.println("\nEnter chips name:");
        String name = scanner.nextLine().trim();

        // validate user input
        if (!chips.contains(name)){

            System.out.println("Invalid input. Please enter correct chips name");
            return;

        }

        Chip chip = new Chip(name);
        order.addChip(chip);
    }


}
