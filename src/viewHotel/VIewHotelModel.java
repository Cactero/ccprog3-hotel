package viewHotel;

import Model.Hotel;
import Model.Room;
import mainMenu.MainMenuModel;
import manageHotel.ManageHotelModel;

import java.util.ArrayList;

/**
 * The Model for Create Room
 * @author Angela Domingo
 */
public class VIewHotelModel {

    private ArrayList<Hotel> hotels;
    private Hotel selectedHotel;

    public VIewHotelModel(ArrayList<Hotel> hotels, Hotel selectedHotel){
        this.hotels = hotels;
        this.selectedHotel = selectedHotel;
        new ViewHotelController(this);
    }

    /**
     * Returns an ArrayList of hotels present in the system.
     * @return the ArrayList of hotels
     */
    public ArrayList<Hotel> getHotels(){
        return this.hotels;
    }

    /**
     * Return the user's selected Hotel.
     * @return the Hotel the user selected
     */
    public Hotel getSelectedHotel(){
        return selectedHotel;
    }

    /**
     * The Model of Main Menu that is created when the user clicks the Cancel button
     */
    public void mainMenu(){
        new MainMenuModel(this.hotels);
    }

    /**
     * The Model of Manage Hotel that is created when the user clicks the Cancel button
     */
    public void manageHotel(){
        new ManageHotelModel(hotels);
    }

}
