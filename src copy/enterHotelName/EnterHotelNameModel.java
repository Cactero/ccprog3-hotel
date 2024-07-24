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

    private boolean fromCreateHotel;
    private CreateRoomModel createRoomModel;

    public EnterHotelNameModel(CentralModel centralModel, MainFrame frame){
        super(centralModel);
        createRoomModel = new CreateRoomModel(centralModel, frame, true);
        controller = new EnterHotelNameController(this, frame);
    }

    public void setFromCreateHotel(boolean fromCreateHotel) {
        this.fromCreateHotel = fromCreateHotel;
    }

    public boolean isFromCreateHotel() {
        return fromCreateHotel;
    }

    /**
     * Adds a hotel to the ArrayList of hotels.
     * @param hotel the new Hotel to be added
     */
    public void addHotel(Hotel hotel){
        centralModel.addHotel(hotel);
    }

    /**
     * The Model of Main Menu that is created when the user clicks the Cancel button
     */
    public AbstractModel mainMenu(){
        return centralModel.getModel(CentralModel.MAIN_MENU);
    }

    /**
     * The Model of Create Room that is created when the user clicks the Create Hotel button
     * @param hotel the new Hotel created
     */
    public AbstractModel createRoom(Hotel hotel){
        createRoomModel.setSelectedHotel(hotel);
        return createRoomModel;
    }

}
