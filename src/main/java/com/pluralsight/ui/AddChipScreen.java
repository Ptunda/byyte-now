package com.pluralsight.ui;

import com.pluralsight.product.Chip;
import com.pluralsight.service.Order;

import java.util.Scanner;


public class AddChipScreen {

    private final Order order;

    public AddChipScreen(Order order) {

        this.order = order;

    }

    public void display() {

        Scanner scanner = new Scanner(System.in);

        String[] chips = {"Classic potato chips", "Kettle cooked chips", "Tortilla chips", "Veggie chips"};


        System.out.println("--------Byyte Now Chips---------");

        for (String chip : chips) {

            System.out.println(chip);

        }

        System.out.println("Enter chip name:");
        String name = scanner.nextLine().trim();

        Chip chip = new Chip(name);
        order.addChip(chip);
    }


}
