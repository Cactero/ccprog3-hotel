package discount;

import app.*;

public class Stay4Get1Discount implements Discount {
    @Override
    public float applyDiscount(Client client) {
        float discount = client.getNormalPrice() - client.getBookedRoom().getBasePrice();
        if(client.getDaysBooked() >= 5){
            client.setFinalPrice(discount);
            return discount;
        }
        return 0F;
    }
}
