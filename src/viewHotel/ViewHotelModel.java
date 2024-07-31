package viewHotel;

import Model.CentralModel;
import Model.Hotel;
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

    public ViewHotelModel(CentralModel centralModel, MainFrame frame) {
        super(centralModel);
        controller = new ViewHotelController(this, frame);
    }

    public void setSelectedHotel(Hotel selectedHotel) {
        this.selectedHotel = selectedHotel;
    }

    /**
     * Return the user's selected Hotel.
     *
     * @return the Hotel the user selected
     */
    public Hotel getSelectedHotel() {
        return selectedHotel;
    }

    /**
     * The Model of Main Menu that is created when the user clicks the Cancel button
     */
    public AbstractModel mainMenu() {
        return centralModel.getModel(CentralModel.MAIN_MENU);
    }

}
