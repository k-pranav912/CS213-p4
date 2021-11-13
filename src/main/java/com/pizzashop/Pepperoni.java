package com.pizzashop;

public class Pepperoni extends Pizza{
    private static final double SMALL_PRICE = 8.99;
    private static final int MIN_TOPPINGS = 1;
    public Pepperoni() {
        toppings.add(Topping.PEPPERONI);
        size = Size.SMALL;
    }
    public double price() {
        double sizePrice = 0;
        switch (size) {
            case SMALL -> sizePrice = SMALL_PRICE;
            case MEDIUM -> sizePrice = SMALL_PRICE + SIZE_INCREASE_PRICE;
            case LARGE -> sizePrice = SMALL_PRICE + SIZE_INCREASE_PRICE + SIZE_INCREASE_PRICE;
        }
        return sizePrice + (toppings.size() - MIN_TOPPINGS) * TOPPING_PRICE;
    }

    @Override
    public String toString() {
        String pizzaString = "Pepperoni Pizza\n";
        pizzaString += this.toppingsString();
        return pizzaString;
    }
}