package com.pluralsight.product;

public class PremiumTopping extends Topping {

    private double price;
    private final String sandwichSize;

    public PremiumTopping(String name, String toppingType, boolean isExtra, String sandwichSize) {

        super(name, toppingType, isExtra);
        this.sandwichSize = sandwichSize;


        setPrice(toppingType, sandwichSize);

    }


    private void setPrice(String toppingType, String sandwichSize) {
        switch (sandwichSize) {
            case "4":
                price = toppingType.equalsIgnoreCase("Meat") ? 1.00 : 0.75;
                break;
            case "8":
                price = toppingType.equalsIgnoreCase("Meat") ? 2.00 : 1.50;
                break;
            case "12":
                price = toppingType.equalsIgnoreCase("Meat") ? 3.00 : 2.25;
                break;
            default:
                throw new IllegalArgumentException("Invalid sandwich size: " + sandwichSize);
        }
    }


    public double getPrice() {

        return price;

    }

    public String getSandwichSize() {

        return sandwichSize;

    }

    public double getTotalPrice() {

        double extraPremiumSurcharge = 0.0;

        if (isExtra()) {
            switch (sandwichSize) {
                case "4":
                    extraPremiumSurcharge = getToppingType().equalsIgnoreCase("Meat") ? 0.50 : 0.30;
                    break;
                case "8":
                    extraPremiumSurcharge = getToppingType().equalsIgnoreCase("Meat") ? 1.00 : 0.60;
                    break;
                case "12":
                    extraPremiumSurcharge = getToppingType().equalsIgnoreCase("Meat") ? 1.50 : 0.90;
                    break;
            }
        }
        return price + extraPremiumSurcharge;

    }

    @Override
    public void displayDetails() {

        System.out.println("For you premium toppings you want...");
        System.out.println("Topping type: " + getToppingType());
        System.out.println("Topping name: " + getName());
        System.out.println("Sandwich size: " + sandwichSize + "\"");
        System.out.println(isExtra() ? "You want extra " + getName() : "No extra " + getName());
        System.out.println("Your total topping price is $" + getTotalPrice());

    }
}
