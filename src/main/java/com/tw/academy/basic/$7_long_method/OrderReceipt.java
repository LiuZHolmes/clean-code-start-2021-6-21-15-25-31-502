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

        final String NEW_LINE = "\n";
        final String header = PRINT_ORDERS + NEW_LINE;
        output.append(header);

        // print date, bill no, customer name
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());

        // prints lineItems
        double totalSalesTax = 0d;
        double total = 0d;
        final String TAB = "\t";
        for (LineItem lineItem : order.getLineItems()) {
            output.append(lineItem.getDescription());
            output.append(TAB);
            output.append(lineItem.getPrice());
            output.append(TAB);
            output.append(lineItem.getQuantity());
            output.append(TAB);
            output.append(lineItem.totalAmount());
            output.append(NEW_LINE);

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