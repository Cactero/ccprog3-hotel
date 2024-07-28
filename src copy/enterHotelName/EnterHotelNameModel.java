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

    private int status; // 1 = fromCreateHotel, 2 = removeHotel, 0 otherwise.
    private CreateRoomModel createRoomModel;
    private Hotel selectedHotel;

    public EnterHotelNameModel(CentralModel centralModel, MainFrame frame, int status){
        super(centralModel);
        this.status = status;
        createRoomModel = new CreateRoomModel(centralModel, frame, status);
        controller = new EnterHotelNameController(this, frame);
    }

    public void setFromCreateHotel(int status) {
        this.status = status;
    }

    public int isFromCreateHotel() {
        return status;
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

    public void removeHotel(String hotelName){
        int index = centralModel.getHotels().indexOf(selectedHotel);
        centralModel.getHotels().remove(index);
    }

    /**
     * The Model of Main Menu that is created when the user clicks the Cancel button
     */
    public AbstractModel mainMenu(){
        return centralModel.getModel(CentralModel.MAIN_MENU);
    }

    /**
     * The Model of Main Menu that is created when the user clicks the Cancel button
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
