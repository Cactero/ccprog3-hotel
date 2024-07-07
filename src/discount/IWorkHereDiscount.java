package discount;

import app.*;

public class IWorkHereDiscount implements Discount {
    @Override
    public float applyDiscount(Client client) {
        float discount = client.getReservationCost() * 0.1F;
        client.setDiscountPrice(discount);
        return discount;
    }
}
