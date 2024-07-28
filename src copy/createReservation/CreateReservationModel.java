package createReservation;

import Model.CentralModel;
import Model.Client;
import Model.Hotel;
import main.AbstractModel;
import main.MainFrame;
import shared.SelectableHotel;

public class CreateReservationModel extends AbstractModel implements SelectableHotel {

    private Hotel selectedHotel;

    public CreateReservationModel(CentralModel centralModel, MainFrame frame){
        super(centralModel);

        // Attempt to get the selected hotel, if available
        this.selectedHotel = getSelectedHotel();

        // Handle case where no hotel is available
        if (this.selectedHotel == null) {
            // Consider how your application should behave in this case
            System.out.println("No hotels available for reservation.");
            // You might want to set a flag, throw an exception, or navigate to a different view
        } else {
            // Proceed with the usual flow if a hotel is available
        }
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
        return centralModel.getHotels().get(0);
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
