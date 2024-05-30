package com.pluralsight.service;

import com.pluralsight.product.Chip;
import com.pluralsight.product.Drink;
import com.pluralsight.product.Sandwich;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private final int orderId;
    private final Customer customer;
    private final List<Sandwich> sandwiches;
    private final List<Drink> drinks;
    private final List<Chip> chips;

    public Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.sandwiches = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.chips = new ArrayList<>();

    }

    public int getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {

        return customer;

    }

    public void addSandwich(Sandwich sandwich) {

        if (sandwich != null) {

            this.sandwiches.add(sandwich);

        }


    }

    public void addDrink(Drink drink) {

        if (drink != null) {

            this.drinks.add(drink);

        }

    }

    public void addChip(Chip chip) {

        if (chip != null) {

            this.chips.add(chip);

        }

    }


    public double calculateTotal() {

        double sandwichCost = 0.0;
        double drinkCost = 0.0;
        double chipCost = 0.0;


        for (Sandwich sandwich : sandwiches) {

            sandwichCost += sandwich.getPrice();

        }

        for (Drink drink : drinks) {

            drinkCost += drink.getPrice();

        }

        for (Chip chip : chips) {

            chipCost += chip.getPrice();

        }


        return sandwichCost + drinkCost + chipCost;

    }


    public String generateReceipt() {

        StringBuilder receipt = new StringBuilder();

        receipt.append("Order ID: ").append(orderId).append("\n").append("Customer: ").append(customer.getName()).append("\n\n").append("Items:\n");

        for (Sandwich sandwich : sandwiches) {

            receipt.append("Sandwich: ").append(sandwich.getName()).append(" - $").append(sandwich.getPrice()).append("\n");

        }

        for (Drink drink : drinks) {

            receipt.append("Drink: ").append(drink.getName()).append(" - $").append(drink.getPrice()).append("\n");

        }

        for (Chip chip : chips) {

            receipt.append("Chip: ").append(chip.getName()).append(" - $").append(chip.getPrice()).append("\n");

        }

        receipt.append("\nTotal: $").append(calculateTotal());
        return receipt.toString();

    }


}
