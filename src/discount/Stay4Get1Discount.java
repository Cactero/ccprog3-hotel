package discount;

import app.*;

public class Stay4Get1Discount implements Discount {
    @Override
    public float applyDiscount(Client client) {
        float discount = client.getBookedRoom().getTotalPrice();
        if(client.getDaysBooked() >= 5){
            client.setDiscountPrice(discount);
            return discount;
        }
        return 0F;
    }
}
