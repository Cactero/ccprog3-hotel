package createRoom;

import Model.CentralModel;
import Model.Hotel;
import Model.Room;
import main.AbstractModel;
import main.MainFrame;
import shared.SelectableHotel;

/**
 * The Model for Create Room
 * @author Angela Domingo
 */
public class CreateRoomModel extends AbstractModel implements SelectableHotel {

    private Hotel selectedHotel;
    private int status;

    public CreateRoomModel(CentralModel centralModel, MainFrame frame, int status){
        super(centralModel);
        this.status = status;
        controller = new CreateRoomController(this, frame);
    }

    public int isFromCreateHotel() {
        return status;
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
