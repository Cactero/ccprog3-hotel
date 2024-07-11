package discount;

import app.Client;

import java.util.ArrayList;

public class DatePriceModifier implements Discount {
    ArrayList<Integer> affectedDates;
    float modifiedRate;

    public DatePriceModifier(ArrayList<Integer> affectedDates, float modifiedRate){
        this.affectedDates = affectedDates;
        this.modifiedRate = modifiedRate;
    }

    @Override
    public float applyDiscount(Client client){
        float finalPrice = client.getNormalPrice();

        for (int i = client.getCheckInDay(); i <= client.getCheckOutDay(); i++) {
            if (affectedDates.contains(i)){
                finalPrice *= modifiedRate;
            }
        }

        return finalPrice;
    }
}
