package com.tw.academy.basic.$7_long_method;

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

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        final String header = PRINT_ORDERS + NEW_LINE;
        output.append(header);
        output.append(order.generateReceipt());

        // prints lineItems
        double totalSalesTax = 0d;
        double total = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            output.append(lineItem.generateReceipt());

            // calculate sales tax @ rate of 10%
            double salesTax = lineItem.totalAmount() * .10;
            totalSalesTax += salesTax;

            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            total += lineItem.totalAmount() + salesTax;
        }

        // prints the state tax
        output.append(SALES_TAX).append(TAB).append(totalSalesTax);

        // print total amount
        output.append(TOTAL_AMOUNT).append(TAB).append(total);
        return output.toString();
    }
}