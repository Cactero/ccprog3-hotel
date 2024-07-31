package viewHotel;

import Model.CentralModel;
import Model.Hotel;
import mainMenu.MainMenuModel;
import shared.AbstractModel;
import Model.MainFrame;
import shared.SelectableHotel;

/**
 * The Model for View Hotel
 * @author Angela Domingo
 * @author Ryan Gemal
 */
public class ViewHotelModel extends AbstractModel implements SelectableHotel {

    private Hotel selectedHotel;

    /**
     * The Constructor for Update Base Price Model
     * @param centralModel the object of the Central Model
     * @param frame the main frame of the program
     */
    public ViewHotelModel(CentralModel centralModel, MainFrame frame) {
        super(centralModel);
        controller = new ViewHotelController(this, frame);
    }

    /**
     * Sets the user's selected Hotel.
     * @param selectedHotel the selected Hotel
     */
    public void setSelectedHotel(Hotel selectedHotel) {
        this.selectedHotel = selectedHotel;
    }

    /**
     * Return the user's selected Hotel.
     * @return the Hotel the user selected
     */
    public Hotel getSelectedHotel() {
        return selectedHotel;
    }

    /**
     * The Model of Main Menu that is created when the user clicks the Cancel button
     * @return the Model of Main Menu
     */
    public MainMenuModel mainMenu() {
        return (MainMenuModel) centralModel.getModel(CentralModel.MAIN_MENU);
    }

}
