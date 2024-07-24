package viewHotel;

import Model.Room;
import Model.Utilities;
import main.AbstractController;
import main.MainFrame;
import mainMenu.MainMenuModel;
import mainMenu.MainMenuView;

import javax.swing.*;

/**
 * The Controller for View Hotel
 * @author Angela Domingo
 * @author Ryan Gemal
 */
public class ViewHotelController extends AbstractController {

    public ViewHotelController(ViewHotelModel model, MainFrame frame) {
        super(model, frame);
        this.view = new ViewHotelView();
        ((ViewHotelView) view).addMainMenuButtonListener();
    }

    public void viewHotel(){
        boolean hasConflict = false;

        try {
            String newRoomFloor = viewHotelView.getRoomFloor();
            int newRoomNumber = Integer.parseInt(viewHotelView.getRoomNumber());
            String newRoomType = viewHotelView.getRoomType();

            for (Room room : viewHotelModel.getSelectedHotel().getRooms()){
                if (room != null){
                    if (Utilities.roomsMatch(room.getRoomFloor(), room.getRoomNumber(), newRoomFloor, newRoomNumber)){
                        hasConflict = true;
                    }
                }
            }

            if (!hasConflict){
                Room newRoom = new Room(newRoomFloor, newRoomNumber, viewHotelModel.getSelectedHotel().getBasePrice());
                newRoom.setRoomType(newRoomType);
                //viewHotelModel.addRoom(newRoom);
                JOptionPane.showMessageDialog(null, "Successfully added new room!", "New room added", JOptionPane.PLAIN_MESSAGE);
                viewHotelView.resetInputFields();
            } else {
                JOptionPane.showMessageDialog(null, "A room with the same name was found.", "Duplicate room name found", JOptionPane.PLAIN_MESSAGE);
                viewHotelView.resetInputFields();
            }

        } catch (NumberFormatException _){
            JOptionPane.showMessageDialog(null, "Room number is not a number.", "Incorrect room number input", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
