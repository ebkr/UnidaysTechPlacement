package com.company.unidays;

import java.util.HashMap;

public class Main {

    /**
     * I'm aware that the method names are not "camel-case" as seen on the the challenge's repository.
     * This was purely to keep conventional naming, however if required, it would not cause a problem to change.
     */

    public static void main(String[] args) {

        HashMap<String, PricingRule> rules = new HashMap<String, PricingRule>() {{
            put("A", new PricingRule(8.00));
            put("B", new PricingRule(12.00, 2, 20.00));
            put("C", new PricingRule(4.00, 3, 10.00));
            put("D", new PricingRule(7.00, 2, 7.00));
            put("E", new PricingRule(5.00, 3, 10.00));
        }};

        UnidaysDiscountChallenge challenge = new UnidaysDiscountChallenge(rules);

        challenge.addToBasket("A");

        BasketResult result = challenge.calculateTotalPrice();
        System.out.println("Total Price: £" + String.format("%.2f", result.getTotal()));
        System.out.println("Delivery Price: £" + String.format("%.2f", result.getDeliveryCharge()));

    }
}