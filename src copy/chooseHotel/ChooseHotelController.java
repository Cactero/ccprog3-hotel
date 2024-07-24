package chooseHotel;

import Model.Hotel;
import main.AbstractController;
import main.MainFrame;
import mainMenu.MainMenuModel;
import mainMenu.MainMenuView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Controller for Choose Hotel.
 * @author Angela Domingo
 */
public class ChooseHotelController extends AbstractController {

    private String selectedHotelName;

    public ChooseHotelController(ChooseHotelModel model, MainFrame frame) {
        super(model, frame);
        this.view = new ChooseHotelView(model.getHotels());

        selectedHotelName = ((ChooseHotelView) view).getHotelName();
        selectHotel();
    }

    public void selectHotel(){
        Hotel selectedHotel = null;
        for (Hotel hotel : model.getHotels()){
            if (hotel.getName().equals(selectedHotelName))
                selectedHotel = hotel;
        }


    }

}
