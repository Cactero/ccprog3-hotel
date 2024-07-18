package manageHotel;

import app.Hotel;
import chooseHotel.ChooseHotelModel;
import mainMenu.MainMenuModel;

import java.util.ArrayList;

/**
 * The Model for Manage Hotel
 * @author Angela Domingo
 */
public class ManageHotelModel {
    private ArrayList<Hotel> hotels;

    public ManageHotelModel(ArrayList<Hotel> hotels){
        this.hotels = hotels;
        new ManageHotelController(this);
    }

    /**
     * Returns an ArrayList of hotels present in the system.
     * @return the ArrayList of hotels
     */
    public ArrayList<Hotel> getHotels(){
        return this.hotels;
    }

    /**
     * The Model of Main Menu that is created when the user clicks the Cancel button
     */
    public void mainMenu(){
        new MainMenuModel(hotels);
    }

    /**
     * The Model of Choose Hotel that is created when the user clicks one of the buttons
     */
    public void chooseHotel(){
        new ChooseHotelModel(hotels, false);
    }
}
