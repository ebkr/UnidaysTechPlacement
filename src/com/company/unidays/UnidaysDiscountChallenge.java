package com.company.unidays;

import java.util.ArrayList;
import java.util.HashMap;

public class UnidaysDiscountChallenge {

    private HashMap<String, PricingRule> pricingRules;
    private ArrayList<String> basketTracker;

    public UnidaysDiscountChallenge(HashMap<String, PricingRule> pricingRules) {
        this.pricingRules = pricingRules;
        basketTracker = new ArrayList<>();
    }

    public void addToBasket(String item) {
        if (pricingRules.containsKey(item)) {
            basketTracker.add(item);
        } else {
            throw(new RuntimeException("Item does not exist"));
        }
    }

    public BasketResult calculateTotalPrice() {
        double total = 0;
        int unique = 0;
        String[] calculatedItems = new String[basketTracker.size()];
        for (String item : basketTracker) {
            if (!isInArray(item, calculatedItems)) {
                calculatedItems[unique] = item;
                unique += 1;
                total += generateItemCost(getItemCount(item), pricingRules.get(item));
            }
        }
        return new BasketResult(total);
    }

    private boolean isInArray(String toFind, String[] search) {
        for (String s : search) {
            if (toFind == s) {
                return true;
            }
        }
        return false;
    }

    private int getItemCount(String item) {
        int count = 0;
        for (String s : basketTracker) {
            if (item == s) {
                count += 1;
            }
        }
        return count;
    }

    private int generateItemCost(int amount, PricingRule rule) {
        int cost = 0;
        int full = amount/rule.getQuantity();
        int remain = amount % rule.getQuantity();

        cost += (rule.getDiscount() * full) + (remain * rule.getPrice());
        return cost;
    }

}