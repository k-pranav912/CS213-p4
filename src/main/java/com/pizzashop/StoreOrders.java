package com.pizzashop;

import java.util.ArrayList;
import java.text.DecimalFormat;

public class StoreOrders {
    ArrayList<Order> orders;
    private static final DecimalFormat df = new DecimalFormat("0.00");
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

    public double calculateSubtotal() {
        double subTotal = 0;
        for (Order x: orders) {
            subTotal += x.getSubTotal();
        }
        return subTotal;
    }

    public double calculateSalesTax() {
        double salesTax = 0;
        for (Order x: orders) {
            salesTax += x.getSalesTax();
        }
        return salesTax;
    }

    public double calculateTotal() {
        return this.calculateSalesTax() + this.calculateSubtotal();
    }

    @Override
    public String toString() {
        String storeOrdersString = "*************************************\n";
        for (int i = 0; i < orders.size(); i++) {
            storeOrdersString += orders.get(i).toString() + "Price of Order: $"
                                                + df.format(orders.get(i).getTotal()) +"\n";
            storeOrdersString += "*************************************\n";
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
