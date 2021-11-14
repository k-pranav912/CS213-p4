package com.pizzashop;

import java.util.ArrayList;

public class Order {
    private long phoneNumber;
    private ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
    private static final double SALES_TAX = .06625;

    public Order(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void add(Pizza pizza) {
        pizzas.add(pizza);
    }
    public void remove(Pizza pizza) {
        pizzas.remove(pizza);
    }

    public double getSubTotal() {
        double subTotal = 0;
        for (int i = 0; i < pizzas.size(); i++) {
            subTotal += pizzas.get(i).price();
        }
        return subTotal;
    }
    public double getSalesTax() {
        return this.getSubTotal() * SALES_TAX;
    }

    //Might be not needed
    public double getTotal() {
        return this.getSubTotal() + this.getSalesTax();
    }

    public long getPhoneNumber() {return this.phoneNumber;}

    public ArrayList<Pizza> getList() {return this.pizzas;}

    @Override
    public String toString() {
        String orderString = "Phone #: " + phoneNumber + "\n";
        for (int i = 0; i < pizzas.size(); i++) {
            orderString += (i + 1) + ". " + pizzas.get(i).toString();
        }
        return orderString;
    }
}
