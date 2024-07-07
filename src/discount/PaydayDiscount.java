package discount;

import app.*;

public class PaydayDiscount implements Discount {
    Utilities utilities = new Utilities();

    @Override
    public float applyDiscount(Client client) {
        float discount = client.getReservationCost() * 0.07F;

        if(Utilities.isPaydayDay(client)){
            client.setDiscountPrice(discount);
            return discount;
        }
        return 0F;
    }
}
