package createReservation;

import Model.CentralModel;
import Model.Client;
import Model.Hotel;
import main.AbstractModel;
import main.MainFrame;
import shared.SelectableHotel;

/**
 * The Model for Create Reservation
 * @author Angela Domingo
 */
public class CreateReservationModel extends AbstractModel implements SelectableHotel {

    private Hotel selectedHotel;

    public CreateReservationModel(CentralModel centralModel, MainFrame frame){
        super(centralModel);
        controller = new CreateReservationController(this, frame);
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

    /**
     * Adds a Client to the selected Hotel.
     * @param client the Client to be added
     */
    public void addClient(Client client){
        for (Hotel hotel : centralModel.getHotels()){
            if (hotel.equals(selectedHotel))
                hotel.addClient(client);
        }
    }

    /**
     * The Model of Main Menu that is created when the user clicks the Cancel button
     * @return the Model of Main Menu
     */
    public AbstractModel mainMenu(){
        return centralModel.getModel(CentralModel.MAIN_MENU);
    }

}
