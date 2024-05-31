package com.pluralsight.ui;

import com.pluralsight.service.Order;
import com.pluralsight.service.ReceiptService;

import java.util.Scanner;


public class CheckoutScreen {

    private final Order order;

    public CheckoutScreen(Order order) {
        this.order = order;
    }

    public void display() {

        Scanner scanner = new Scanner(System.in);

        System.out.println(order.generateReceipt());

        System.out.println("Confirm order? (yes/no)");
        String response = scanner.nextLine().toLowerCase().trim();

        if (response.equalsIgnoreCase("yes")) {

            ReceiptService.saveReceipt(order);
            System.out.println("Order confirmed and receipt saved.");

        } else {

            System.out.println("Order cancelled.");

        }
    }


}
