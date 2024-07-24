package createReservation;

import Model.Client;
import Model.Hotel;
import mainMenu.MainMenuModel;
import manageHotel.ManageHotelModel;

import java.util.ArrayList;

/**
 * The Model for Create Reservation
 * @author Angela Domingo
 */
public class CreateReservationModel {
    private ArrayList<Hotel> hotels;
    private Hotel selectedHotel;

    public CreateReservationModel(ArrayList<Hotel> hotels, Hotel selectedHotel){
        this.hotels = hotels;
        this.selectedHotel = selectedHotel;
        new CreateReservationController(this);
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
     * Adds a Client to the selected Hotel.
     * @param client the Client to be added
     */
    public void addClient(Client client){
        selectedHotel.addClient(client);
    }

    /**
     * The Model of Main Menu that is created when the user clicks the Cancel button
     */
    public void mainMenu(){
        new MainMenuModel(this.hotels);
    }

}
