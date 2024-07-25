package enterHotelName;

import javax.swing.*;

import Model.*;
import main.AbstractController;
import main.MainFrame;
import shared.PopupScreen;

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
            if (((EnterHotelNameModel) model).isFromCreateHotel())
                frame.switchView(((EnterHotelNameModel) model).mainMenu());
            else
                frame.switchView(((EnterHotelNameModel) model).manageHotel());

        } else if (hotelName.isEmpty()){
            JOptionPane.showMessageDialog(null, "Enter a hotel name.", "No hotel name", JOptionPane.PLAIN_MESSAGE);
            promptUser();

        } else {
            hasConflict = model.getHotels().stream().anyMatch(hotel -> hotel.getName().equals(hotelName));

            if (!hasConflict){
                if (((EnterHotelNameModel) model).isFromCreateHotel()){
                    Hotel hotel = new Hotel(hotelName);
                    ((EnterHotelNameModel) model).addHotel(hotel);
                    JOptionPane.showMessageDialog(null, "Successfully added new hotel!", "Hotel " + hotelName + " added", JOptionPane.PLAIN_MESSAGE);
                    frame.switchView(((EnterHotelNameModel) model).createRoom(hotel));
                } else {
                    String originalName = ((EnterHotelNameModel) model).getSelectedHotel().getName();
                    ((EnterHotelNameModel) model).renameHotel(hotelName);
                    String message = String.format("Successfully renamed Hotel %s to %s!", originalName, hotelName);
                    JOptionPane.showMessageDialog(null, message, "Renamed hotel", JOptionPane.PLAIN_MESSAGE);
                    frame.switchView(((EnterHotelNameModel) model).manageHotel());
                }

            } else {
                JOptionPane.showMessageDialog(null, "A hotel with the same name already exists.", "Invalid Hotel Name", JOptionPane.PLAIN_MESSAGE);
                promptUser();
            }
        }
    }

}
