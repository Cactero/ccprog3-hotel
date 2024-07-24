package createRoom;

import Model.Hotel;
import Model.Room;
import mainMenu.MainMenuModel;
import manageHotel.ManageHotelModel;

import java.util.ArrayList;

/**
 * The Model for Create Room
 * @author Angela Domingo
 */
public class CreateRoomModel {

    private ArrayList<Hotel> hotels;
    private Hotel selectedHotel;

    public CreateRoomModel(ArrayList<Hotel> hotels, Hotel selectedHotel, boolean fromCreateHotel){
        this.hotels = hotels;
        this.selectedHotel = selectedHotel;
        new CreateRoomController(this, fromCreateHotel);
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
     * Adds a room to the selected Hotel's list of rooms
     * @param room the Room to be added
     */
    public void addRoom(Room room){
        selectedHotel.addRoom(room);
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
