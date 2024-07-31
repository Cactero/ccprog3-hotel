package removeHotel;

import Model.CentralModel;
import Model.Hotel;
import chooseHotel.ChooseHotelModel;
import mainMenu.MainMenuModel;
import manageHotel.ManageHotelModel;
import shared.AbstractModel;
import Model.MainFrame;
import shared.SelectableHotel;

/**
 * The Model for Remove Room.
 * @author Angela Domingo
 */
public class RemoveHotelModel extends AbstractModel implements SelectableHotel {

    private Hotel selectedHotel;

    /**
     * The Constructor for Manage Hotel Model
     * @param centralModel the object of the Central Model
     * @param frame the main frame of the program
     */
    public RemoveHotelModel(CentralModel centralModel, MainFrame frame) {
        super(centralModel);
        controller = new RemoveHotelController(this, frame);
    }

    /**
     * Removes the currently selected hotel from the CentralModel.
     */
    public void removeHotel() {
        centralModel.removeHotel(selectedHotel);
    }

    /**
     * Retrieves the model associated with the key for managing hotels.
     * @return the Model for Manage Hotel.
     */
    public ManageHotelModel manageHotel() {
        return (ManageHotelModel) centralModel.getModel(CentralModel.MANAGE_HOTEL);
    }

    /**
     * Retrieves the model associated with the key for the main menu.
     * @return the Model for Main Menu.
     */
    public MainMenuModel mainMenu() {
        return (MainMenuModel) centralModel.getModel(CentralModel.MAIN_MENU);
    }

    /**
     * Retrieves the model for choosing a hotel and sets its source to REMOVE_HOTEL.
     * @return the ChooseHotelModel object with the source set to REMOVE_HOTEL.
     */
    public ChooseHotelModel chooseHotel() {
        ChooseHotelModel CHmodel = (ChooseHotelModel) centralModel.getModel(CentralModel.CHOOSE_HOTEL);
        CHmodel.setSource(ChooseHotelModel.REMOVE_HOTEL);
        return CHmodel;
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
