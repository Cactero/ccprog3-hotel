package app;

import discount.DatePriceModifier;
import mainMenu.MainMenuModel;

import java.util.ArrayList;
import java.util.Date;

public class DriverGUI {
    ArrayList<Hotel> hotels = new ArrayList<Hotel>();

    public static void main(String[] args) {
        Client client = new Client("Ryan", "Gemal", 15, 20, new Room("F", 27, 1000f));

        ArrayList<Integer> range = new ArrayList<>();
        range.add(16);
        range.add(17);
        range.add(18);
        range.add(19);
        DatePriceModifier dpm = new DatePriceModifier(range, 1.1f);

        System.out.println(dpm.applyDiscount(client));
    }
}