package createRoom;

import Model.CentralModel;
import Model.Hotel;
import Model.Room;
import shared.AbstractModel;
import Model.MainFrame;
import shared.SelectableHotel;

/**
 * The Model for Create Room
 * @author Angela Domingo
 */
public class CreateRoomModel extends AbstractModel implements SelectableHotel {

    private Hotel selectedHotel;
    private boolean fromCreateHotel;

    public CreateRoomModel(CentralModel centralModel, MainFrame frame, boolean fromCreateHotel){
        super(centralModel);
        this.fromCreateHotel = fromCreateHotel;
        controller = new CreateRoomController(this, frame);
    }

    /**
     * Checks if the Create Room instance is from Create Hotel.
     * @return true if the current context is from Create Hotel; false otherwise.
     */
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
     * Returns the user's selected Hotel.
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
     * @return the Model of Main Menu
     */
    public AbstractModel mainMenu(){
        return centralModel.getModel(CentralModel.MAIN_MENU);
    }

    /**
     * The Model of Manage Hotel that is created when the user clicks the Choose Hotel button
     * @return the Model of Manage Hotel
     */
    public AbstractModel manageHotel(){
        return centralModel.getModel(CentralModel.MANAGE_HOTEL);
    }

}
