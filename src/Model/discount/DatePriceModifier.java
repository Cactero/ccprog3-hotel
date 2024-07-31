package Model.discount;

import Model.Client;

import java.util.ArrayList;

/**
 * The Date Price Modifier class where details regarding the hotel's DPM alterations are held.
 * Implements the {@link Discount} interface.
 * @author Angela Domingo
 */
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

    /**
     * Adds affected dates and their corresponding modified rates to the discount data.
     * This method updates the modified rate for each affected date and records the discount name.
     * @param discountName the name of the discount to be associated with the affected dates
     * @param affectedDates an {@link ArrayList} of integers representing the dates affected by the discount
     * @param modifiedRate the rate to be applied to the affected dates
     */
    public void addAffectedDates(String discountName, ArrayList<Integer> affectedDates, float modifiedRate){
        for (int affectedDate : affectedDates){
            modifiedRates[affectedDate-1] = modifiedRate;
        }
        dpmNames.add(discountName);
    }

    /**
     * Calculates the new reservation price of the Client based on the Hotel's date price modifiers.
     * @param client the Client where the discount will be applied to
     * @param price the price of the reservation before the discount
     * @return the new reservation price of the Client
     */
    @Override
    public float applyDiscount(Client client, float price){
        float finalPrice = 0f;
        float pricePerDay = client.getBookedRoom().getBasePrice();

        for (int i = client.getCheckInDay(); i < client.getCheckOutDay(); i++) {
            finalPrice += (pricePerDay * modifiedRates[i-1]);
        }

        client.addDiscountsUsed(this.dpmNames);
        return finalPrice;
    }
}
