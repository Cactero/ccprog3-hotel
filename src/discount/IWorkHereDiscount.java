package discount;

import app.*;

public class IWorkHereDiscount implements Discount {
    @Override
    public float applyDiscount(Client client) {
        // apply discount to final price
        float discount = client.getFinalPrice() * 0.1F;
        client.setFinalPrice(discount);
        return discount;
    }
}
