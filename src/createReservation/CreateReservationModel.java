package createReservation;

import Model.CentralModel;
import Model.Client;
import Model.Hotel;
import shared.AbstractModel;
import Model.MainFrame;
import shared.SelectableHotel;

public class CreateReservationModel extends AbstractModel implements SelectableHotel {

    private Hotel selectedHotel;

    public CreateReservationModel(CentralModel centralModel, MainFrame frame){
        super(centralModel);

        // Attempt to get the selected hotel, if available
        this.selectedHotel = getSelectedHotel();
        controller = new CreateReservationController(this, frame);
    }

    @Override
    public void setSelectedHotel(Hotel selectedHotel) {
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

    public void addClient(Client client){
        for (Hotel hotel : centralModel.getHotels()){
            if (hotel.equals(selectedHotel))
                hotel.addClient(client);
        }
    }

    public AbstractModel mainMenu(){
        return centralModel.getModel(CentralModel.MAIN_MENU);
    }
}
