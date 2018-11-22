import java.util.HashMap;
import java.util.Scanner;

public class Main {

    /**
     * I'm aware that the method names are not "camel-case" as seen on the the challenge's repository.
     * This was purely to keep conventional naming, however if required, it would not cause a problem to change.
     */

    public static void main(String[] args) {

        HashMap<String, PricingRule> rules = new HashMap<String, PricingRule>() {{
            // PricingRule: {initial cost, quantity of items required per discount, value of quantity}
            // EG (B): £12.00 normal price, or 3 for £10.00
            put("A", new PricingRule(8.00));
            put("B", new PricingRule(12.00, 2, 20.00));
            put("C", new PricingRule(4.00, 3, 10.00));
            put("D", new PricingRule(7.00, 2, 7.00));
            put("E", new PricingRule(5.00, 3, 10.00));
        }};

        UnidaysDiscountChallenge challenge = new UnidaysDiscountChallenge(rules);

        // Read input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter items to add to basket:");
        addStringToBasket(challenge, scanner.nextLine());

        // Calculate and display
        BasketResult result = challenge.calculateTotalPrice();
        System.out.println("Total Price: \u00A3" + String.format("%.2f", result.getTotal()));
        System.out.println("Delivery Price: \u00A3" + String.format("%.2f", result.getDeliveryCharge()));

        System.out.println();
        System.out.println("Press return to close application");
        scanner.nextLine();
    }

    /**
     * Deal with string insertion.
     * @param basket
     * @param s
     */
    private static void addStringToBasket(UnidaysDiscountChallenge basket, String s) {
        for (int i=0; i<s.length(); i++) {
            try {
                basket.addToBasket(s.substring(i, i+1).toUpperCase());
            } catch (Exception e) {
                System.out.println(s.substring(i, i+1).toUpperCase() + ": " + e.getMessage());
            }
        }
    }
}