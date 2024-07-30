package chooseHotel;

import Model.Hotel;
import shared.AbstractController;
import Model.MainFrame;
import shared.PopupScreen;

import javax.swing.*;
import java.util.ArrayList;

/**
 * The Controller for Choose Hotel.
 * @author Angela Domingo
 */
public class ChooseHotelController extends AbstractController implements PopupScreen {


    public ChooseHotelController(ChooseHotelModel model, MainFrame frame) {
        super(model, frame);
        this.view = new ChooseHotelView();
    }

    /**
     * The implementation of promptUser in PopupScreen for Choose Hotel.
     */
    @Override
    public void promptUser(){

        String selectedHotelName;
        ArrayList<Hotel> hotels = model.getHotels();

        String[] hotelNames = hotels.stream()
        .map(Hotel::getName)
        .toArray(String[]::new);

        selectedHotelName = (String) JOptionPane.showInputDialog(null, "Select a hotel", "Choose Hotel", JOptionPane.PLAIN_MESSAGE, null, hotelNames, hotelNames[0]);

        if (selectedHotelName == null) {
            if (((ChooseHotelModel) model).getSource().equals(ChooseHotelModel.VIEW_HOTEL) ||
                    ((ChooseHotelModel) model).getSource().equals(ChooseHotelModel.CREATE_RESERVATION)) {
                frame.switchView(((ChooseHotelModel) model).mainMenu());
            } else {
                frame.switchView(((ChooseHotelModel) model).manageHotel());
            }
        } else {
            Hotel selectedHotel = hotels.stream()
                    .filter(hotel -> hotel.getName().equals(selectedHotelName))
                    .findFirst()
                    .orElse(null);

            frame.switchView(((ChooseHotelModel) model).getModel(selectedHotel, ((ChooseHotelModel) model).getSource()));
        }
    }

}
