package com.pizzashop;

import java.util.ArrayList;

public class StoreOrders {
    ArrayList<Order> orders;
    public StoreOrders() {
         orders = new ArrayList<Order>();
    }
    public boolean checkOrder(Order order) {
        if (orders.contains(order)) return false;
        return true;
    }
    public void add(Order order) {
        orders.add(order);
    }
    public void remove(Order order) {
        orders.remove(order);
    }

    @Override
    public String toString() {
        String storeOrdersString = "";
        for (int i = 0; i < orders.size(); i++) {
            storeOrdersString += orders.get(i).toString();
        }
        return storeOrdersString;
    }
}
