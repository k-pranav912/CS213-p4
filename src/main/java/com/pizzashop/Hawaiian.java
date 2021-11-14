package com.pizzashop;

public class Hawaiian extends Pizza{
    private static final double SMALL_PRICE = 10.99;
    private static final int MIN_TOPPINGS = 2;
    public Hawaiian() {
        toppings.add(Topping.HAM);
        toppings.add(Topping.PINEAPPLE);
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
        String pizzaString = "Hawaiian Pizza\n";
        pizzaString += this.toppingsString();
        return pizzaString;
    }
}