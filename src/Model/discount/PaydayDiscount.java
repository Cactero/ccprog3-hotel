package Model.discount;

import Model.*;

/**
 * Represents a discount for clients whose booked dates cover the 15th or 30th (excluding check out).
 * Implements the {@link Discount} interface.
 * @author Ryan Gemal
 */
public class PaydayDiscount implements Discount {

    /**
     * Returns the name of this discount.
     * @return a String representing the name of the discount, "Payday"
     */
    public String getDiscountName() {
        return "Payday";
    }

    /**
     * Calculates a 7% discount if the client's booked dates cover (but not check out) the 15th or 30th.
     * @param client the Client where the discount will be applied to
     * @param price the price of the reservation before the discount
     * @return the new reservation price of the Client
     */
    @Override
    public float applyDiscount(Client client, float price) {
        float discount = price * (1-0.07F);

        if(Utilities.isPaydayDay(client)){
            return discount;
        }
        return price;
    }
}
