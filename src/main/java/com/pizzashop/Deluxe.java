package com.pizzashop;

public class Deluxe extends Pizza{
    private static final double SMALL_PRICE = 12.99;
    private static final int MIN_TOPPINGS = 5;
    public Deluxe() {
        toppings.add(Topping.PINEAPPLE);
        toppings.add(Topping.HAM);
        toppings.add(Topping.GREEN_PEPPER);
        toppings.add(Topping.ONION);
        toppings.add(Topping.MUSHROOM);
        size = Size.SMALL;
    }
    public double price() {
        double sizePrice = 0;
        switch (size) {
            case SMALL -> sizePrice = SMALL_PRICE;
            case MEDIUM -> sizePrice = SMALL_PRICE + SIZE_INCREASE_PRICE;
            case LARGE -> sizePrice = SMALL_PRICE + SIZE_INCREASE_PRICE + SIZE_INCREASE_PRICE;
        }
        int temp = toppings.size() - MIN_TOPPINGS;
        if (temp < 0) temp = 0;
        return sizePrice + (temp) * TOPPING_PRICE;
    }
    @Override
    public String toString() {
        String pizzaString = "Deluxe Pizza\n";
        pizzaString += this.toppingsString();
        return pizzaString;
    }
}
