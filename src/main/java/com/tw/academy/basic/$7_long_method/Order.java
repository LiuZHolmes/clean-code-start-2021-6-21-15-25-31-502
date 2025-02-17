package com.tw.academy.basic.$7_long_method;

import java.util.List;
import java.util.stream.Collectors;

public class Order {
    String customerName;
    String address;
    List<LineItem> lineItems;

    public Order(String customerName, String address, List<LineItem> lineItems) {
        this.customerName = customerName;
        this.address = address;
        this.lineItems = lineItems;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String generateReceipt() {
        final String lineItems = this.lineItems.stream()
                .map(LineItem::generateReceipt)
                .collect(Collectors.joining());
        return customerName + address + lineItems;
    }

    public double getTotalSalesTax() {
        return lineItems.stream()
                .mapToDouble(LineItem::getSalesTax)
                .sum();
    }

    public double getTotal() {
        return lineItems.stream()
                .mapToDouble(LineItem::getTotalCost)
                .sum();
    }
}
