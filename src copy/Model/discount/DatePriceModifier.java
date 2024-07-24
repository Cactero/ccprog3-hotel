package Model.discount;

import Model.Client;

import java.util.ArrayList;

public class DatePriceModifier implements Discount {
    private float[] modifiedRates;
    private ArrayList<String> dpmNames;

    public DatePriceModifier(){
        this.dpmNames = new ArrayList<>();
        this.modifiedRates = new float[31];

        for (int i = 0; i < 31; i++) {
            this.modifiedRates[i] = 1f;
        }
    }

    public ArrayList<String> getDpmNames(){
        return dpmNames;
    }

    public void addAffectedDates(String discountName, ArrayList<Integer> affectedDates, float modifiedRate){
        for (int affectedDate : affectedDates){
            modifiedRates[affectedDate-1] = modifiedRate;
        }
        dpmNames.add(discountName);
    }

    @Override
    public float applyDiscount(Client client){
        float baseRate = client.getBookedRoom().getBasePrice();
        float finalPrice = 0f;

        for (int i = client.getCheckInDay(); i < client.getCheckOutDay(); i++) {
            finalPrice += (baseRate * modifiedRates[i-1]);
        }

        client.addDiscountsUsed(this.dpmNames);
        return finalPrice;
    }
}
