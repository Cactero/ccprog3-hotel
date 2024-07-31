package Model.discount;

import Model.*;

/**
 * Represents a discount for clients who work at the company. Applies a 10% reduction to the final price of a client's purchase.
 * Implements the {@link Discount} interface.
 * @author Ryan Gemal
 */
public class IWorkHereDiscount implements Discount {

    /**
     * Returns the name of this discount.
     * @return a String representing the name of the discount, "I Work Here"
     */
    public String getDiscountName() {
        return "I Work Here";
    }

    /**
     * Applies the discount to the client's final price.
     * This method calculates a 10% discount on the client's current final price and updates the final price accordingly.
     * @param client the Client where the discount will be applied to
     * @param price the price of the reservation before the discount
     * @return the new reservation price of the Client
     */
    @Override
    public float applyDiscount(Client client, float price) {
        return price * 0.9F;
    }
}
