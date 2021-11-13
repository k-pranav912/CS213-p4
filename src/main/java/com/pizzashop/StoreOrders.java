package com.pizzashop;

import java.util.ArrayList;

public class StoreOrders {
    ArrayList<Order> orders;
    public StoreOrders() {
         orders = new ArrayList<Order>();
    }

    public boolean checkOrder(Order order) {
        for (Order x: orders) {
            if (x.getPhoneNumber() == order.getPhoneNumber()) return true;
        }
        return false;
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

    public static void main(String[] args) {
        StoreOrders list = new StoreOrders();

        Order a1 = new Order(12345);
        list.add(a1);

        Order a2 = new Order(12345);

        System.out.println(list.checkOrder(a2));
    }
}
