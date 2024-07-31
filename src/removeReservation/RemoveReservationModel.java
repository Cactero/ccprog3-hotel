package removeReservation;

import Model.CentralModel;
import Model.Client;
import Model.Hotel;
import manageHotel.ManageHotelModel;
import shared.AbstractModel;
import Model.MainFrame;
import shared.SelectableHotel;

/**
 * The Model for Remove Room.
 * @author Angela Domingo
 */
public class RemoveReservationModel extends AbstractModel implements SelectableHotel {

    private Hotel selectedHotel;

    /**
     * The Constructor for Remove Reservation Model
     * @param centralModel the object of the Central Model
     * @param frame the main frame of the program
     */
    public RemoveReservationModel(CentralModel centralModel, MainFrame frame) {
        super(centralModel);
        controller = new RemoveReservationController(this, frame);
    }

    /**
     * Removes the client from the selected Hotel.
     * @param client the Client to be removed
     */
    public void removeReservation(Client client){
        int index = centralModel.getHotels().indexOf(selectedHotel);
        centralModel.getHotel(index).removeClient(client);
    }

    /**
     * Retrieves the model associated with the key for managing hotels.
     * @return the Model for Manage Hotel.
     */
    public ManageHotelModel manageHotel() {
        return (ManageHotelModel) centralModel.getModel(CentralModel.MANAGE_HOTEL);
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
