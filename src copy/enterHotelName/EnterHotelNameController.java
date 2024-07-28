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
        String hotelName;

        if(((EnterHotelNameModel) model).isFromCreateHotel() == 2){
            hotelName = JOptionPane.showInputDialog("Enter hotel name (" + ((EnterHotelNameModel) model).getSelectedHotel().getName() + ") to confirm:");
        }
        else { hotelName = JOptionPane.showInputDialog("Enter your hotel name:"); }

        if (hotelName == null){
            if (((EnterHotelNameModel) model).isFromCreateHotel() == 1)
                frame.switchView(((EnterHotelNameModel) model).mainMenu());
            else
                frame.switchView(((EnterHotelNameModel) model).manageHotel());

        } else if (hotelName.isEmpty()){
            JOptionPane.showMessageDialog(null, "Enter a hotel name.", "No hotel name", JOptionPane.PLAIN_MESSAGE);
            promptUser();

        } else {
            hasConflict = model.getHotels().stream().anyMatch(hotel -> hotel.getName().equals(hotelName));

            if (!hasConflict){
                if (((EnterHotelNameModel) model).isFromCreateHotel() == 1){
                    Hotel hotel = new Hotel(hotelName);
                    ((EnterHotelNameModel) model).addHotel(hotel);
                    JOptionPane.showMessageDialog(null, "Successfully added new hotel!", "Hotel " + hotelName + " added", JOptionPane.PLAIN_MESSAGE);
                    frame.switchView(((EnterHotelNameModel) model).createRoom(hotel));
                }
                else if(((EnterHotelNameModel) model).isFromCreateHotel() == 2){
                    JOptionPane.showMessageDialog(null, "Hotel names do not match, try again.", "Invalid Hotel Name", JOptionPane.PLAIN_MESSAGE);
                    promptUser();
                }
                else {
                    String originalName = ((EnterHotelNameModel) model).getSelectedHotel().getName();
                    ((EnterHotelNameModel) model).renameHotel(hotelName);
                    String message = String.format("Successfully renamed Hotel %s to %s!", originalName, hotelName);
                    JOptionPane.showMessageDialog(null, message, "Renamed hotel", JOptionPane.PLAIN_MESSAGE);
                    frame.switchView(((EnterHotelNameModel) model).manageHotel());
                }

            } else {
                if(((EnterHotelNameModel) model).isFromCreateHotel() == 2) { // From Remove Hotel
                    String inputtedHotel = ((EnterHotelNameModel) model).getSelectedHotel().getName();
                    ((EnterHotelNameModel) model).removeHotel(inputtedHotel);
                    String message = String.format("Successfully removed Hotel %s! Going back to main menu.", inputtedHotel);
                    JOptionPane.showMessageDialog(null, message, "Removed hotel", JOptionPane.PLAIN_MESSAGE);
                    frame.switchView(((EnterHotelNameModel) model).mainMenu());
                }

                else {
                    JOptionPane.showMessageDialog(null, "A hotel with the same name already exists.", "Invalid Hotel Name", JOptionPane.PLAIN_MESSAGE);
                    promptUser();
                }
            }
        }
    }

}
