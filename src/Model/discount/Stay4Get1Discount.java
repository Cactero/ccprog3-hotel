package Model.discount;

import Model.*;

/**
 * Represents a discount for clients who booked 5 days or more.
 * Implements the {@link Discount} interface.
 * @author Ryan Gemal
 */
public class Stay4Get1Discount implements Discount {

    /**
     * Returns the name of this discount.
     * @return a String representing the name of the discount, "Stay 4, Get 1"
     */
    public String getDiscountName() {
        return "Stay 4, Get 1";
    }

    /**
     * Calculates a one-day free discount if the client books 5 days or more.
     * @param client the Client where the discount will be applied to
     * @return the new reservation price of the Client
     */
    @Override
    public float applyDiscount(Client client) {
        float discount = client.getNormalPrice() - client.getBookedRoom().getBasePrice();
        if(client.getNightsBooked() >= 5){
            return discount;
        }
        return 0F;
    }
}