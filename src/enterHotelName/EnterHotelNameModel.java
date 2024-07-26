package enterHotelName;

import Model.*;
import createRoom.CreateRoomModel;
import main.AbstractModel;
import main.MainFrame;
import shared.SelectableHotel;

/**
 * The Model for Enter Hotel Name
 * @author Angela Domingo
 */
public class EnterHotelNameModel extends AbstractModel implements SelectableHotel {

    private boolean fromCreateHotel;
    private CreateRoomModel createRoomModel;
    private Hotel selectedHotel;

    public EnterHotelNameModel(CentralModel centralModel, MainFrame frame, boolean fromCreateHotel){
        super(centralModel);
        createRoomModel = new CreateRoomModel(centralModel, frame, fromCreateHotel);
        controller = new EnterHotelNameController(this, frame);
    }

    /**
     * Checks if the Create Room instance is from Create Hotel.
     * @param fromCreateHotel true if the current context is from Create Hotel; false otherwise.
     */
    public void setFromCreateHotel(boolean fromCreateHotel) {
        this.fromCreateHotel = fromCreateHotel;
    }

    /**
     * Checks if the Create Room instance is from Create Hotel.
     * @return true if the current context is from Create Hotel; false otherwise.
     */
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

    public void renameHotel(String newName){
        int index = centralModel.getHotels().indexOf(selectedHotel);
        centralModel.getHotels().get(index).setName(newName);
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

    /**
     * The Model of Create Room that is created when the user clicks the Create Hotel button
     * @param hotel the new Hotel created
     */
    public AbstractModel createRoom(Hotel hotel){
        createRoomModel.setSelectedHotel(hotel);
        return createRoomModel;
    }

    /**
     * Sets the selected hotel the user chose previously in the Choose Hotel screen
     * @param hotel the selected Hotel
     */
    @Override
    public void setSelectedHotel(Hotel hotel) {
        this.selectedHotel = hotel;
    }

    /**
     * Gets the selected hotel the user chose previously in the Choose Hotel screen
     * @return the selected Hotel
     */
    @Override
    public Hotel getSelectedHotel() {
        return selectedHotel;
    }
}
