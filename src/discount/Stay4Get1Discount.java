package discount;

import app.*;

public class Stay4Get1Discount implements Discount {

    public String getDiscountName() {
        return "Stay 4 Get 1";
    }

    @Override
    public float applyDiscount(Client client) {
        float discount = client.getNormalPrice() - client.getBookedRoom().getBasePrice();
        if(client.getNightsBooked() >= 5){
            client.setFinalPrice(discount);
            return discount;
        }
        return 0F;
    }
}