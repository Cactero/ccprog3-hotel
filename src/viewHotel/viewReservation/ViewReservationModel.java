package viewHotel.viewReservation;

import Model.CentralModel;
import Model.Client;
import Model.Hotel;
import Model.MainFrame;
import chooseHotel.ChooseHotelModel;
import shared.AbstractModel;
import shared.SelectableReservation;
import viewHotel.ViewHotelModel;
import viewHotel.viewLowLevel.ViewLowLevelModel;

/**
 * The Model for View Room Availability
 * @author Ryan Gemal
 */
public class ViewReservationModel extends AbstractModel implements SelectableReservation {

    private Client selectedClient;
    private ViewLowLevelModel viewLowLevelModel;

    public ViewReservationModel(ViewLowLevelModel viewLowLevelModel, CentralModel centralModel, MainFrame frame){
        super(centralModel);
        this.viewLowLevelModel = viewLowLevelModel;
        selectedClient = getSelectedReservation();
        controller = new ViewReservationController(this, frame);
        setSelectedReservation(selectedClient);
    }

    public AbstractModel mainMenu() {
        return centralModel.getModel(CentralModel.MAIN_MENU);
    }

    /**
     * Sets the selected client the user chose previously in the View Low Level screen
     * @param client the selected Client
     */
    @Override
    public void setSelectedReservation(Client client) {
        this.selectedClient = client;
        ((ViewReservationController) controller).updateText(selectedClient);
    }

    /**
     * Gets the selected client the user chose previously in the View Low Level screen
     * @return the selected Client
     */
    @Override
    public Client getSelectedReservation() {
        return selectedClient;
    }
}
