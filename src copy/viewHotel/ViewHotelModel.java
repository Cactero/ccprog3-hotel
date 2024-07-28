package viewHotel;

import Model.CentralModel;
import Model.Hotel;
import main.AbstractModel;
import main.MainFrame;
import shared.SelectableHotel;
import viewLowLevel.ViewLowLevelModel;

/**
 * The Model for View Hotel
 *
 * @author Angela Domingo
 * @uthor Ryan Gemal
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

    /**
     * The Model of View Room Availability that is retrieved when the user clicks
     * one of the buttons
     */
    public AbstractModel viewRoomAvailability() {
        ViewLowLevelModel model = (ViewLowLevelModel) centralModel.getModel(CentralModel.VIEW_ROOM_AVAILABILITY);
        model.setSelectedHotel(selectedHotel);
        return model;
    }
}
