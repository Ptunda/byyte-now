package com.pluralsight.ui;

import com.pluralsight.product.*;
import com.pluralsight.service.Order;

import java.util.*;


public class AddSandwichScreen {

    private final Order order;

    public AddSandwichScreen(Order order) {
        this.order = order;
    }

    public void display() {

        Scanner scanner = new Scanner(System.in);

        String[] sandwiches = {
                "Name: Classic Club\nBread: White\nMeats: Ham, Chicken, Bacon\nCheese: Swiss\nRegular Toppings: Lettuce, Tomatoes, Onions\nSauces: Mayo\nSides: Chips, Coleslaw",
                "Name: Italian Delight\nBread: Wheat\nMeats: Salami, Ham, Roasted Beef\nCheese: Provolone\nRegular Toppings: Peppers, Cucumbers, Pickles\nSauces: Vinaigrette\nSides: Pasta Salad, Garlic Bread",
                "Name: Veggie Supreme\nBread: Rye\nCheese: Provolone\nRegular Toppings: Peppers, Cucumbers, Pickles\nSauces: Vinaigrette\nSides: Fruit Salad, Hummus",
                "Name: Spicy Chicken Ranch\nBread: Wrap\nMeats: Chicken, Bacon\nCheese: American\nRegular Toppings: Lettuce, Onions, Jalapenos\nSauces: Ranch\nSides: Fries, Coleslaw",
                "Name: Steak & Cheese\nBread: White\nMeats: Steak\nCheese: Cheddar\nRegular Toppings: Onions, Peppers, Mushrooms\nSauces: Thousand Islands\nSides: Onion Rings, Potato Salad",
                "Name: Ham & Swiss Delight\nBread: Wheat\nMeats: Ham\nCheese: Swiss\nRegular Toppings: Lettuce, Tomatoes, Cucumbers\nSauces: Mayo\nSides: Chips, Pickle Spear",
                "Name: Roast Beef & Provolone\nBread: Rye\nMeats: Roasted Beef\nCheese: Provolone\nRegular Toppings: Pickles, Onions, Tomatoes\nSauces: Mustard\nSides: Potato Salad, Coleslaw",
                "Name: Chicken & Bacon Ranch\nBread: Wrap\nMeats: Chicken, Bacon\nCheese: American\nRegular Toppings: Lettuce, Tomatoes, Jalapenos\nSauces: Ranch\nSides: Fries, Pickle Spear"
        };

        // Extract the different components from the sandwiches array
        Set<String> meats = new HashSet<>();
        Set<String> cheeses = new HashSet<>();
        Set<String> regularToppings = new HashSet<>();
        Set<String> sauces = new HashSet<>();
        Set<String> sides = new HashSet<>();

        for (String sandwich : sandwiches) {

            String[] lines = sandwich.split("\n");

            for (String line : lines) {

                if (line.startsWith("Meats: ")) {

                    meats.addAll(Arrays.asList(line.substring(7).split(", ")));

                } else if (line.startsWith("Cheese: ")) {

                    cheeses.add(line.substring(8));

                } else if (line.startsWith("Regular Toppings: ")) {

                    regularToppings.addAll(Arrays.asList(line.substring(18).split(", ")));

                } else if (line.startsWith("Sauces: ")) {

                    sauces.add(line.substring(8));

                } else if (line.startsWith("Sides: ")) {
                    // Assuming "Sides" is included in descriptions
                    sides.addAll(Arrays.asList(line.substring(7).split(", ")));

                }

            }

        }

        // Display the predefined sandwiches
        System.out.println("--------Byyte Now Sandwiches---------");
        for (String sandwich : sandwiches) {
            System.out.println(sandwich);
            System.out.println();
        }

        // Display the options for sandwich customization
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

        // Custom sandwich options
        System.out.println("Available Meats: " + meats);
        System.out.println("Available Cheeses: " + cheeses);
        System.out.println("Available Regular Toppings: " + regularToppings);
        System.out.println("Available Sauces: " + sauces);
        System.out.println("Available Sides: " + sides);

        addToppings(scanner, sandwich, meats, cheeses, regularToppings, sauces, sides);

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

    private void addToppings(Scanner scanner, Sandwich sandwich, Set<String> meats, Set<String> cheeses, Set<String> regularToppings, Set<String> sauces, Set<String> sides) {
        boolean addingToppings = true;

        while (addingToppings) {
            System.out.println("Add a topping (meats, cheese, regular, sauce, side) or type 'done' to finish:");
            String toppingType = scanner.nextLine().trim().toLowerCase();

            if (toppingType.equals("done")) {
                addingToppings = false;
            } else {
                switch (toppingType) {
                    case "meats":
                        System.out.println("Available Meats: " + meats);
                        break;
                    case "cheese":
                        System.out.println("Available Cheeses: " + cheeses);
                        break;
                    case "regular":
                        System.out.println("Available Regular Toppings: " + regularToppings);
                        break;
                    case "sauce":
                        System.out.println("Available Sauces: " + sauces);
                        break;
                    case "side":
                        System.out.println("Available Sides: " + sides);
                        break;
                    default:
                        System.out.println("Unknown topping type. Please enter a valid topping type.");
                        continue;
                }

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
