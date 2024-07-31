package enterHotelName;

import Model.*;
import createRoom.CreateRoomModel;
import mainMenu.MainMenuModel;
import manageHotel.ManageHotelModel;
import shared.AbstractModel;
import Model.MainFrame;
import shared.SelectableHotel;

/**
 * The Model for Enter Hotel Name
 * @author Angela Domingo
 */
public class EnterHotelNameModel extends AbstractModel implements SelectableHotel {

    private boolean fromCreateHotel;
    private CreateRoomModel createRoomModel;
    private Hotel selectedHotel;

    /**
     * The Constructor for DPM Model
     * @param centralModel the object of the Central Model
     * @param frame the main frame of the program
     * @param fromCreateHotel checks if the instance is called from Create Hotel
     */
    public EnterHotelNameModel(CentralModel centralModel, MainFrame frame, boolean fromCreateHotel){
        super(centralModel);
        this.fromCreateHotel = fromCreateHotel;
        createRoomModel = new CreateRoomModel(centralModel, frame, fromCreateHotel);
        controller = new EnterHotelNameController(this, frame);
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

    /**
     * Renames the selected Hotel.
     * @param newName the new name of the selected hotel
     */
    public void renameHotel(String newName){
        int index = centralModel.getHotels().indexOf(selectedHotel);
        centralModel.getHotels().get(index).setName(newName);
    }

    /**
     * The Model of Main Menu that is created when the user clicks the Cancel button
     * @return the Model of Main Menu
     */
    public MainMenuModel mainMenu(){
        return (MainMenuModel) centralModel.getModel(CentralModel.MAIN_MENU);
    }

    /**
     * The Model of Manage Hotel that is created when the user clicks the Choose Hotel button
     * @return the Model of Manage Hotel
     */
    public ManageHotelModel manageHotel(){
        return (ManageHotelModel) centralModel.getModel(CentralModel.MANAGE_HOTEL);
    }

    /**
     * The Model of Create Room that is created when the user clicks the Create Hotel button
     * @param hotel the new Hotel created
     * @return a Create Room Model instance
     */
    public CreateRoomModel createRoom(Hotel hotel){
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
