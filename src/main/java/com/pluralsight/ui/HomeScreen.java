package com.pluralsight.ui;

import java.util.Scanner;

public class HomeScreen {

    public void display() {

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    OrderScreen orderScreen = new OrderScreen();
                    orderScreen.display();
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Exiting application. Goodbye!");

    }


}
