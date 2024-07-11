package app;

import discount.DatePriceModifier;
import mainMenu.MainMenuModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public class DriverGUI {
    ArrayList<Hotel> hotels = new ArrayList<Hotel>();

    public static void main(String[] args) {
        Client client = new Client("Ryan", "Gemal", 5, 9, new Room("F", 27, 1000f));

        ArrayList<Integer> range = new ArrayList<>();
        range.add(5);
        range.add(6);

        ArrayList<Integer> nine = new ArrayList<>();
        nine.add(8);

        float modifiedRate = 1.1f;

        DatePriceModifier dpm = new DatePriceModifier();
        dpm.addAffectedDates("Tester", range, modifiedRate);
        dpm.addAffectedDates("tester2", nine, 0.9f);

        System.out.println(client.getNormalPrice());
        System.out.println(dpm.applyDiscount(client));
    }
}