package com.company.unidays;

public class PricingRule {

    private double price;
    private double discount;
    private int quantity;

    public PricingRule(double price) {
        this.price = price;
        discount = price;
        quantity = 1;
    }

    public PricingRule(double price, int quantity, double discountPrice) {
        this.price = price;
        discount = discountPrice;
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public int getQuantity() {
        return quantity;
    }
}