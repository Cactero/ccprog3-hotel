package Model.discount;

import Model.*;

public class PaydayDiscount implements Discount {

    public String getDiscountName() {
        return "Payday";
    }

    @Override
    public float applyDiscount(Client client) {
        float discount = client.getNormalPrice() * 0.07F;

        if(Utilities.isPaydayDay(client)){
            client.setFinalPrice(discount);
            return discount;
        }
        return 0F;
    }
}
