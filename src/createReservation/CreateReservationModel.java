package createReservation;

import Model.CentralModel;
import Model.Client;
import Model.Hotel;
import mainMenu.MainMenuModel;
import shared.AbstractModel;
import Model.MainFrame;
import shared.SelectableHotel;

/**
 * The Model for Create Reservation.
 * @author Angela Domingo
 */
public class CreateReservationModel extends AbstractModel implements SelectableHotel {

    private Hotel selectedHotel;

    /**
     * The Constructor for Create Reservation Model
     * @param centralModel the object of the Central Model
     * @param frame the main frame of the program
     */
    public CreateReservationModel(CentralModel centralModel, MainFrame frame){
        super(centralModel);

        // Attempt to get the selected hotel, if available
        this.selectedHotel = getSelectedHotel();
        controller = new CreateReservationController(this, frame);
        setSelectedHotel(selectedHotel);
    }

    @Override
    public void setSelectedHotel(Hotel selectedHotel) {
        ((CreateReservationController) controller).updateRoomComboBox();
        this.selectedHotel = selectedHotel;
    }

    @Override
    public Hotel getSelectedHotel(){
        if (selectedHotel != null) {
            return selectedHotel;
        }

        // Check if there are any hotels available
        if (centralModel.getHotels().isEmpty()) {
            return null; // No hotels available
        }

        // Fallback to the first hotel in the list if selectedHotel is not set
        return centralModel.getHotels().getFirst();
    }

    /**
     * Adds a new client to the selected Hotel.
     * @param client the new Client
     */
    public void addClient(Client client){
        int index = getHotels().indexOf(selectedHotel);
        getHotels().get(index).addClient(client);
    }

    /**
     * The Main Menu Model that is retrieved from the Central Model
     * @return Main Menu Model
     */
    public MainMenuModel mainMenu(){
        return (MainMenuModel) centralModel.getModel(CentralModel.MAIN_MENU);
    }
}
