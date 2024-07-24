package Model.discount;

import Model.*;

public class IWorkHereDiscount implements Discount {

    public String getDiscountName() {
        return "I Work Here";
    }

    @Override
    public float applyDiscount(Client client) {
        // apply app.discount to final price
        float discount = client.getFinalPrice() * 0.1F;
        client.setFinalPrice(discount);
        return discount;
    }
}
