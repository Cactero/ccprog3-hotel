package createReservation;

import Model.CentralModel;
import Model.Client;
import Model.Hotel;
import main.AbstractModel;
import main.MainFrame;
import mainMenu.MainMenuController;
import mainMenu.MainMenuModel;

import javax.swing.*;
import java.util.ArrayList;

/**
 * The Model for Create Reservation
 * @author Angela Domingo
 */
public class CreateReservationModel extends AbstractModel {

    private Hotel selectedHotel;

    public CreateReservationModel(CentralModel centralModel, MainFrame frame, Hotel selectedHotel){
        super(centralModel);
        this.selectedHotel = selectedHotel;
        controller = new CreateReservationController(this, frame);
    }

    /**
     * Return the user's selected Hotel.
     * @return the Hotel the user selected
     */
    public Hotel getSelectedHotel(){
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
     */
    public AbstractModel mainMenu(){
        return centralModel.getModel(CentralModel.MAIN_MENU);
    }

}
