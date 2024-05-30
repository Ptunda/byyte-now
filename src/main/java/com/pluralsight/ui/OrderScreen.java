package com.pluralsight.ui;

import com.pluralsight.product.Chip;
import com.pluralsight.product.Drink;
import com.pluralsight.service.Customer;
import com.pluralsight.service.Order;

import java.util.Scanner;


public class OrderScreen {

    private Order currentOrder;

    public void display() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter customer name:");
        String name = scanner.nextLine().trim();

        System.out.println("Enter customer contact info:");
        String contactInfo = scanner.nextLine().trim();

        Customer customer = new Customer(name, contactInfo);
        currentOrder = new Order(generateOrderId(), customer);

        boolean ordering = true;

        while (ordering) {

            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    AddSandwichScreen sandwichScreen = new AddSandwichScreen(currentOrder);
                    sandwichScreen.display();
                    break;
                case "2":
                    AddDrinkScreen drinkScreen = new AddDrinkScreen(currentOrder);
                    drinkScreen.display();
                    break;
                case "3":
                    AddChipScreen chipScreen = new AddChipScreen(currentOrder);
                    chipScreen.display();
                    break;
                case "4":
                    CheckoutScreen checkoutScreen = new CheckoutScreen(currentOrder);
                    checkoutScreen.display();
                    ordering = false;
                    break;
                case "0":
                    System.out.println("Order cancelled.");
                    ordering = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private int generateOrderId() {

        // Logic to generate a unique order ID (e.g., based on current timestamp or a counter)
        return (int) (System.currentTimeMillis() & 0xfffffff);

    }


}
