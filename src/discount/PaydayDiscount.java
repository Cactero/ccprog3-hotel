package discount;

import app.*;

public class PaydayDiscount implements Discount {

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
