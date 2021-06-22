package com.tw.academy.basic.$7_long_method;

import static com.tw.academy.basic.$7_long_method.OrderReceiptConstant.NEW_LINE;
import static com.tw.academy.basic.$7_long_method.OrderReceiptConstant.TAB;

public class LineItem {
	private String description;
	private double price;
	private int quantity;

	public LineItem(String description, double price, int quantity) {
		super();
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}

	double totalAmount() {
        return price * quantity;
    }

	public String generateReceipt() {
		return description + TAB
				+ price + TAB
				+ quantity + TAB
				+ totalAmount() + NEW_LINE;
	}

	public double getSalesTax() {
		final double TEN_PERCENT = .10;
		return totalAmount() * TEN_PERCENT;
	}

	public double getTotalCost() {
		return totalAmount() + getSalesTax();
	}
}