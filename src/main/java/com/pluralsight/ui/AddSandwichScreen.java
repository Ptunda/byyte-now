package com.pluralsight.ui;

import com.pluralsight.product.*;
import com.pluralsight.service.Order;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;


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

        HashMap<String, String> sandwichNames = new HashMap<>();
        sandwichNames.put("1", "Classic Club");
        sandwichNames.put("2", "Italian Delight");
        sandwichNames.put("3", "Veggie Supreme");
        sandwichNames.put("4", "Spicy Chicken Ranch");
        sandwichNames.put("5", "Steak & Cheese");
        sandwichNames.put("6", "Ham & Swiss Delight");
        sandwichNames.put("7", "Roast Beef & Provolone");
        sandwichNames.put("8", "Chicken & Bacon Ranch");

        HashMap<String, String> breadTypeNames = new HashMap<>();
        breadTypeNames.put("1", "white");
        breadTypeNames.put("2", "wheat");
        breadTypeNames.put("3", "rye");
        breadTypeNames.put("4", "wrap");

        HashMap<String, String> breadSizesNames = new HashMap<>();
        breadSizesNames.put("1", "4");
        breadSizesNames.put("2", "8");
        breadSizesNames.put("3", "12");

        Set<String> sandwichNamesKeys = sandwichNames.keySet();
        Set<String> breadTypeNamesKeys = breadTypeNames.keySet();
        Set<String> breadSizesNamesKeys = breadSizesNames.keySet();

        String name = getValidInput(scanner, "Enter sandwich name:", sandwichNames, sandwichNamesKeys);
        String breadType = getValidInput(scanner, "Select your bread type:", breadTypeNames, breadTypeNamesKeys);
        String size = getValidInput(scanner, "Select sandwich size:", breadSizesNames, breadSizesNamesKeys);

        System.out.println("Would you like the sandwich toasted? (yes/no)");
        boolean isToasted = scanner.nextLine().trim().equalsIgnoreCase("yes");

        Sandwich sandwich = new Sandwich(name, size, breadType, isToasted);

        addToppings(scanner, sandwich);

        order.addSandwich(sandwich);
    }

    private String getValidInput(Scanner scanner, String prompt, HashMap<String, String> map, Set<String> keys) {

        while (true) {

            System.out.println(prompt);

            for (String key : keys) {

                System.out.print(key + " - ");
                System.out.println(map.get(key));

            }

            String input = scanner.nextLine().trim();

            if (map.containsKey(input)) {

                return map.get(input);

            } else {

                System.out.println("Invalid selection. Please try again.");

            }
        }
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
                String toppingName = scanner.nextLine().toLowerCase().trim();

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
