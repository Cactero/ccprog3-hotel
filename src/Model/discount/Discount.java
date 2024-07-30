package Model.discount;

import Model.Client;

/**
 * The interface for any price altering classes in the program (discount codes and date price modifier).
 * @author Ryan Gemal
 */
public interface Discount {

    /**
     * Interface method for applying a discount.
     * @param client the Client where the discount will be applied to
     * @param price the current calculated price before applying the discount
     * @return the new reservation price of the Client
     */
    float applyDiscount(Client client, float price);
}
