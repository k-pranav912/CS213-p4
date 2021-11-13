package com.pizzashop;

public enum Topping {
    PEPPERONI, PINEAPPLE, CHICKEN, BEEF, HAM, OLIVES, EXTRA_CHEESE, SAUSAGE, GREEN_PEPPER, ONION, MUSHROOM;

    @Override
    public String toString() {
        switch (this) {
            case PEPPERONI:
                return "Pepperoni";
            case PINEAPPLE:
                return "Pineapple";
            case EXTRA_CHEESE:
                return "Extra Cheese";
            case HAM:
                return "Ham";
            case BEEF:
                return "Beef";
            case ONION:
                return "Onion";
            case OLIVES:
                return "Olives";
            case CHICKEN:
                return "Chicken";
            case SAUSAGE:
                return "Sausage";
            case MUSHROOM:
                return "Mushroom";
            case GREEN_PEPPER:
                return "Green Pepper";
            default:
                return "";
        }
    }
}
