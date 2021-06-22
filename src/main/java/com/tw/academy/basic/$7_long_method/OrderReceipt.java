package com.tw.academy.basic.$7_long_method;

import java.util.stream.Collectors;

import static com.tw.academy.basic.$7_long_method.OrderReceiptConstant.*;

/**
 * This class is a example for bad smell;
 *
 * @author  Thoughtworks
 * @version 1.0
 * @since   2018-1-1
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String getCustomerName() {
        return order.getCustomerName();
    }

    public String generateReceipt() {
        StringBuilder output = new StringBuilder();

        final String header = PRINT_ORDERS + NEW_LINE;
        output.append(header);
        output.append(order.generateReceipt());
        output.append(generateFooter(order.getTotalSalesTax(), order.getTotal()));

        return output.toString();
    }

    private String generateFooter(double totalSalesTax, double total) {
        return SALES_TAX + TAB
                + totalSalesTax + TOTAL_AMOUNT + TAB
                + total;
    }
}