package com.pluralsight.service;

import com.pluralsight.product.Chip;
import com.pluralsight.product.Drink;
import com.pluralsight.product.Sandwich;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private final int orderId;
    private final Customer customer;
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<Chip> chips;

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

    public void addSandwich(Sandwich sandwich){

        this.sandwiches.add(sandwich);

    }

    public void addDrink(Drink drink){

        this.drinks.add(drink);

    }

    public void addChip(Chip chip){

        this.chips.add(chip);

    }


    public double calculateTotal(){

        double orderTotal = 0.0;
        double sandwichCost = 0.0;


        for (Sandwich sandwich : sandwiches) {



        }

    }

}
