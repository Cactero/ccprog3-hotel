package enterHotelName;

import Model.*;
import createRoom.CreateRoomModel;
import main.AbstractModel;
import main.MainFrame;
import mainMenu.MainMenuController;
import mainMenu.MainMenuModel;

import javax.swing.*;
import java.util.ArrayList;

/**
 * The Model for Enter Hotel Name
 * @author Angela Domingo
 */
public class EnterHotelNameModel extends AbstractModel {

    public EnterHotelNameModel(CentralModel centralModel, MainFrame frame){
        super(centralModel);
        new EnterHotelNameController(this, frame);
    }

    /**
     * Adds a hotel to the ArrayList of hotels.
     * @param hotel the new Hotel to be added
     */
    public void addHotel(Hotel hotel){
        this.hotels.add(hotel);
    }

    /**
     * The Model of Main Menu that is created when the user clicks the Cancel button
     */
    public void mainMenu(){
        new MainMenuModel(this.hotels);
    }

    /**
     * The Model of Create Room that is created when the user clicks the Create Hotel button
     * @param hotel the new Hotel created
     * @param fromCreateHotel checks if the call is made from Create Room MVC
     */
    public void createRoom(Hotel hotel, boolean fromCreateHotel){
        new CreateRoomModel(this.hotels, hotel, fromCreateHotel);
    }

    public void enterHotelName(){

    }
}
