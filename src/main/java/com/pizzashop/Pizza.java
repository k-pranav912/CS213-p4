package com.pizzashop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public abstract class Pizza {
    //protected ArrayList<Topping> toppings = new ArrayList<Topping>();
    protected ObservableList<Topping> toppings = FXCollections.observableArrayList();
    protected Size size;

    protected static final double SIZE_INCREASE_PRICE = 2;
    protected static final double TOPPING_PRICE = 1.49;
    protected static final int MAX_TOPPINGS = 7;

    public abstract double price();
    public void setSize(Size newSize) {
        size = newSize;
    }
    public boolean addTopping(Topping topping) {
        if (toppings.size() >= MAX_TOPPINGS) return false;
        toppings.add(topping);
        return true;
    }
    public boolean removeTopping(Topping topping) {
        if (toppings.size() <= 0) return false;
        toppings.remove(topping);
        return true;
    }
    @Override
    public abstract String toString();
    public String toppingsString() {
        String toppingString = "";
        for (int i = 0; i < toppings.size(); i++) {
            toppingString += "\t-" + toppings.get(i) + "\n";
        }
        return toppingString;
    }
    public int getMaxSize() {
        return this.MAX_TOPPINGS;
    }
}
