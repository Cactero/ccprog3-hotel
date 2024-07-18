package mainMenu;

import app.Hotel;
import chooseHotel.ChooseHotelModel;
import enterHotelName.EnterHotelNameModel;
import manageHotel.ManageHotelModel;

import java.util.ArrayList;

/**
 * The Model for Main Menu.
 * @author Angela Domingo
 * @author Ryan Gemal
 */
public class MainMenuModel {
    private ArrayList<Hotel> hotels;

    public MainMenuModel(ArrayList<Hotel> hotels){
        this.hotels = hotels;
        new MainMenuController(this);
    }

    /**
     * Returns an ArrayList of hotels present in the system.
     * @return the ArrayList of hotels
     */
    public ArrayList<Hotel> getHotels(){
        return this.hotels;
    }

    /**
     * The Model of Enter Hotel Name that is created when the user clicks the Create Hotel button
     */
    public void createHotel(){
        new EnterHotelNameModel(hotels, false);
    }

    /**
     * The Model of Choose Hotel that is created when the user clicks the View Hotel button
     */
    public void viewHotel(){
        new ChooseHotelModel(hotels, false);
    }

    /**
     * The Model of Manage Hotel that is created when the user clicks the Manage Hotel button
     */
    public void manageHotel(){
        new ManageHotelModel(hotels);
    }

    /**
     * The Model of Choose Hotel that is created when the user clicks the Create Reservation button
     */
    public void createReservation(){
         new ChooseHotelModel(hotels, true);
    }

}
