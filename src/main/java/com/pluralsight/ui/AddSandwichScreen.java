package com.pluralsight.ui;

import com.pluralsight.product.*;
import com.pluralsight.service.Order;

import java.util.Scanner;


public class AddSandwichScreen {

    private final Order order;

    public AddSandwichScreen(Order order) {
        this.order = order;
    }

    public void display() {

        Scanner scanner = new Scanner(System.in);

        String[] sandwiches = {

                "Name: Classic Club\nBread: White\nMeats: Ham, Chicken, Bacon\nCheese: Swiss\nRegular Toppings: Lettuce, Tomatoes, Onions\nSauces: Mayo",
                "Name: Italian Delight\nBread: Wheat\nMeats: Salami, Ham, Roasted Beef\nCheese: Provolone\nRegular Toppings: Peppers, Cucumbers, Pickles\nSauces: Vinaigrette",
                "Name: Veggie Supreme\nBread: Rye\nCheese: Provolone\nRegular Toppings: Peppers, Cucumbers, Pickles\nSauces: Vinaigrette",
                "Name: Spicy Chicken Ranch\nBread: Wrap\nMeats: Chicken, Bacon\nCheese: American\nRegular Toppings: Lettuce, Onions, Jalapenos\nSauces: Ranch",
                "Name: Steak & Cheese\nBread: White\nMeats: Steak\nCheese: Cheddar\nRegular Toppings: Onions, Peppers, Mushrooms\nSauces: Thousand Islands",
                "Name: Ham & Swiss Delight\nBread: Wheat\nMeats: Ham\nCheese: Swiss\nRegular Toppings: Lettuce, Tomatoes, Cucumbers\nSauces: Mayo",
                "Name: Roast Beef & Provolone\nBread: Rye\nMeats: Roasted Beef\nCheese: Provolone\nRegular Toppings: Pickles, Onions, Tomatoes\nSauces: Mustard",
                "Name: Chicken & Bacon Ranch\nBread: Wrap\nMeats: Chicken, Bacon\nCheese: American\nRegular Toppings: Lettuce, Tomatoes, Jalapenos\nSauces: Ranch"
        };

        System.out.println("--------Byyte Now Sandwiches---------");
        for (String sandwich : sandwiches) {
            System.out.println(sandwich);
            System.out.println();
        }

        System.out.println("Enter sandwich name:");
        String name = scanner.nextLine().trim();

        System.out.println("Select your bread type: (white, wheat, rye, or wrap)");
        String breadType = scanner.nextLine().trim();

        System.out.println("Select sandwich size: (4, 8, or 12)");
        String size = scanner.nextLine().trim();

        System.out.println("Would you like the sandwich toasted? (yes/no)");
        boolean isToasted = scanner.nextLine().trim().equalsIgnoreCase("yes");

        Sandwich sandwich = new Sandwich(name, size, breadType, isToasted);

        addToppings(scanner, sandwich);

        order.addSandwich(sandwich);
    }

    private void addToppings(Scanner scanner, Sandwich sandwich) {

        boolean addingToppings = true;

        while (addingToppings) {

            System.out.println("Add a topping (meats, cheese, regular, sauce, side) or type 'done' to finish:");

            String toppingType = scanner.nextLine().trim().toLowerCase();

            if (toppingType.equals("done")) {

                addingToppings = false;

            } else {

                System.out.println("Enter topping name:");
                String toppingName = scanner.nextLine().trim();

                boolean isExtra = false;

                if (toppingType.equals("meats") || toppingType.equals("cheese")) {

                    System.out.println("Do you want extra? (yes/no)");
                    isExtra = scanner.nextLine().trim().equalsIgnoreCase("yes");

                }

                Topping topping;

                switch (toppingType) {
                    case "meats":
                    case "cheese":
                        topping = new PremiumTopping(toppingName, toppingType, isExtra, sandwich.getSize());
                        break;
                    case "sauce":
                        topping = new Sauce(toppingName, "sauce", isExtra);
                        break;
                    case "side":
                        topping = new Side(toppingName, "side", isExtra);
                        break;
                    default:
                        topping = new RegularTopping(toppingName, toppingType, isExtra);
                }

                sandwich.addTopping(topping);
            }
        }
    }


}
