# UnidaysTechPlacement
 
 
## The repository contains a batch file to compile and run the Main class.


### Discounts


I approached the solution by working on how I'd enable discounts first.

It took several iterations, but I came up with a method that would work perfectly.

This method is the PricingRule class, and is initialised by {normalPrice, quantityToApplyDiscount, discountPrice}.

### Pricing


Once items are added to the basket, they have their price calculated. This works by finding how many of each item there are stored, and applying the discount based on the quantity.

For example, 5 items, with a rule of {2, 2, 1} would be:

2 groups of 2 match required quantity. Therefore, total += 2*discountPrice.

There is 1 item remaining, Therefore, total += 1*normalPrice.

## Total

I've used a BasketResult class to display the total cost, and the delivery charge.
