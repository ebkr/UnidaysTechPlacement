package com.company.unidays;

public class BasketResult {

    private double totalCost;
    private double deliveryCharge = 0;

    /**
     * Result object to provide basket information.
     * Numbers are compared as doubles to ensure it's easy to read. (50.00 = £50.00).
     * @param total Total cost of order.
     */
    public BasketResult(double total) {
        totalCost = total;
        if (total < 50.00 && total > 0) {
            deliveryCharge = 7.00;
        }
    }

    /**
     * Returns the total cost generated in UnidaysDiscountChallenge::CalculateTotalPrice().
     * @return Returns the total cost.
     */
    public double getTotal() {
        return totalCost;
    }

    public double getDeliveryCharge() {
        return deliveryCharge;
    }
}