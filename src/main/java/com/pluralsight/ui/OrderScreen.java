package com.pluralsight.ui;

import com.pluralsight.service.Customer;
import com.pluralsight.service.Order;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import java.util.Scanner;


public class OrderScreen {

    private Order currentOrder;

    public void display() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer full name (e.g., John Smith): ");
        String name = scanner.nextLine().trim();

        // Validate email address
        String emailAddress = "";

        while (true) {

            System.out.print("Email address (e.g., jsmith@example.com): ");
            emailAddress = scanner.nextLine().trim();

            if (isValidEmail(emailAddress)) {

                break;

            } else {

                System.out.println("Invalid email input. Please try again.");

            }
        }

        // Validate phone number
        String phoneNumber = "";

        while (true) {

            System.out.print("Phone number (e.g., 800-555-1234): ");
            phoneNumber = scanner.nextLine().trim();

            if (isValidPhoneNumber(phoneNumber)) {

                break;

            } else {

                System.out.println("Invalid phone number input. Please try again.");

            }
        }

        String contactInfo = emailAddress + ", " + phoneNumber;

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

    // Validate email format
    private boolean isValidEmail(String email) {

        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();

    }

    // Validate phone number format
    private boolean isValidPhoneNumber(String phoneNumber) {

        String phoneRegex = "^\\d{3}-\\d{3}-\\d{4}$";
        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();

    }

    private int generateOrderId() {

        // Logic to generate a unique order ID (e.g., based on current timestamp or a counter)
        return (int) (System.currentTimeMillis() & 0xfffffff);

    }


}
