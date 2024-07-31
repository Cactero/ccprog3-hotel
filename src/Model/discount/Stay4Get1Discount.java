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
     * @param price the price of the reservation before the discount
     * @return the new reservation price of the Client
     */
    @Override
    public float applyDiscount(Client client, float price) {
        float pricePerDay = price / client.getNightsBooked();
        float discount = price - pricePerDay;
        if(client.getNightsBooked() + 1 >= 5){
            return discount;
        }
        return price;
    }
}