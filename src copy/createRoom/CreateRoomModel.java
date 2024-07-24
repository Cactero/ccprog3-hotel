package createRoom;

import Model.CentralModel;
import Model.Hotel;
import Model.Room;
import main.AbstractModel;
import main.MainFrame;
import mainMenu.MainMenuController;
import mainMenu.MainMenuModel;
import manageHotel.ManageHotelModel;

import javax.swing.*;
import java.util.ArrayList;

/**
 * The Model for Create Room
 * @author Angela Domingo
 */
public class CreateRoomModel extends AbstractModel {

    private Hotel selectedHotel;
    private boolean fromCreateHotel;

    public CreateRoomModel(CentralModel centralModel, MainFrame frame){
        super(centralModel);
        controller = new CreateRoomController(this, frame);
    }

    public void setFromCreateHotel(boolean fromCreateHotel) {
        this.fromCreateHotel = fromCreateHotel;
    }

    public boolean isFromCreateHotel() {
        return fromCreateHotel;
    }

    /**
     * Sets the selected hotel.
     * @param selectedHotel the selected Hotel
     */
    public void setSelectedHotel(Hotel selectedHotel) {
        this.selectedHotel = selectedHotel;
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
    public AbstractModel mainMenu(){
        return centralModel.getModel(CentralModel.MAIN_MENU);
    }

    /**
     * The Model of Manage Hotel that is created when the user clicks the Cancel button
     */
    public AbstractModel manageHotel(){
        return centralModel.getModel(CentralModel.MANAGE_HOTEL);
    }

}
