import java.util.ArrayList;
import java.util.HashMap;

public class UnidaysDiscountChallenge {

    private HashMap<String, PricingRule> pricingRules;
    private ArrayList<String> basketTracker;

    /**
     * Initialise Basket
     * @param pricingRules List of discount rules.
     */
    public UnidaysDiscountChallenge(HashMap<String, PricingRule> pricingRules) {
        this.pricingRules = pricingRules;
        basketTracker = new ArrayList<>();
    }

    /**
     * Adds an item to the basket
     * @param item String associated to discount rule key.
     */
    public void addToBasket(String item) {
        if (pricingRules.containsKey(item)) {
            basketTracker.add(item);
        } else {
            throw(new RuntimeException("Item does not exist"));
        }
    }

    /**
     * Generates the total cost
     * @return BasketResult to contain total and delivery charge.
     */
    public BasketResult calculateTotalPrice() {
        double total = 0;
        int unique = 0;
        String[] calculatedItems = new String[basketTracker.size()];
        // Loop through basket. If item is the first found of its type, determine total of that item, and send through the pricing rule.
        for (String item : basketTracker) {
            // Check if unique.
            if (!isInArray(item, calculatedItems)) {
                calculatedItems[unique] = item;
                unique += 1;
                total += generateItemCost(getItemCount(item), pricingRules.get(item));
            }
        }
        return new BasketResult(total);
    }

    // Check if item exists in the given array.
    private boolean isInArray(String toFind, String[] search) {
        for (String s : search) {
            if (toFind.equals(s)) {
                return true;
            }
        }
        return false;
    }

    // Loop through basket and find count of item.
    private int getItemCount(String item) {
        int count = 0;
        for (String s : basketTracker) {
            if (item.equals(s)) {
                count += 1;
            }
        }
        return count;
    }

    /**
     * Determine discount of total items.
     * @param amount
     * @param rule
     * @return
     */
    private int generateItemCost(int amount, PricingRule rule) {
        int cost = 0;
        // Find amount of items that qualify for the discount.
        int full = amount/rule.getQuantity();
        // Find amount of items that don't qualify.
        int remain = amount % rule.getQuantity();

        // Calculate total cost.
        cost += (rule.getDiscount() * full) + (remain * rule.getPrice());
        return cost;
    }

}