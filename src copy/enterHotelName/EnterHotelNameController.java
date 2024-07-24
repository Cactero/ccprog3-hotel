package enterHotelName;

import javax.swing.*;

import Model.*;
import main.AbstractController;
import main.MainFrame;
import main.PopupScreen;

import java.util.ArrayList;

/**
 * The Controller for Enter Hotel Name
 * @author Angela Domingo
 */
public class EnterHotelNameController extends AbstractController implements PopupScreen {

    public EnterHotelNameController(EnterHotelNameModel model, MainFrame frame) {
        super(model, frame);
        this.view = new EnterHotelNameView();
    }

    @Override
    public void promptUser(){
        boolean hasConflict;
        String hotelName = JOptionPane.showInputDialog("Enter your hotel name:");

        if (hotelName == null){
            frame.switchView(((EnterHotelNameModel) model).mainMenu());
        } else if (hotelName.isEmpty()){
            JOptionPane.showMessageDialog(null, "Enter a hotel name.", "No hotel name", JOptionPane.PLAIN_MESSAGE);
            promptUser();
        } else {
            ArrayList<Hotel> hotels = model.getHotels();
            hasConflict = hotels.stream().anyMatch(hotel -> hotel.getName().equals(hotelName));

            if (!hasConflict){
                Hotel hotel = new Hotel(hotelName);
                ((EnterHotelNameModel) model).addHotel(hotel);
                frame.switchView(((EnterHotelNameModel) model).createRoom(hotel));
            } else {
                JOptionPane.showMessageDialog(null, "A hotel with the same name already exists.", "Invalid Hotel Name", JOptionPane.PLAIN_MESSAGE);
                promptUser();
            }
        }
    }

}
