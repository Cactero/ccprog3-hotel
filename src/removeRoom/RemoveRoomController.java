package removeRoom;

import Model.Hotel;
import Model.Room;
import Model.Utilities;
import shared.AbstractController;
import shared.AbstractModel;
import Model.MainFrame;
import shared.PopupScreen;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * The Controller for Remove Room
 * @author Angela Domingo
 */
public class RemoveRoomController extends AbstractController implements PopupScreen {

    /**
     * The Constructor for Remove Room Controller
     * @param model the Model object of Remove Room
     * @param frame the main frame of the program
     */
    public RemoveRoomController(AbstractModel model, MainFrame frame) {
        super(model, frame);
        this.view = new RemoveRoomView();
    }

    /**
     * The implementation of promptUser in PopupScreen for Remove Reservation.
     */
    @Override
    public void promptUser() {
        String selectedRoomName;
        Hotel hotel = ((RemoveRoomModel) model).getSelectedHotel();

        Room[] rooms = hotel.getRooms();

        if(hotel.getRoomCount() == 1){
            JOptionPane.showMessageDialog(null, "You cannot remove the only room in this hotel!", "Error", JOptionPane.ERROR_MESSAGE);
            frame.switchView(((RemoveRoomModel) model).manageHotel());
        } else {
            String[] roomNames = Arrays.stream(rooms)
                    .filter(Objects::nonNull)
                    .map(Room::getFormattedName)
                    .toArray(String[]::new);


            selectedRoomName = (String) JOptionPane.showInputDialog(null, "Select a room", "Choose Room", JOptionPane.PLAIN_MESSAGE, null, roomNames, roomNames[0]);

            if (selectedRoomName == null) {
                // User canceled the input dialog
                frame.switchView(((RemoveRoomModel) model).manageHotel());
            }

            Room selectedRoom = Arrays.stream(rooms)
                    .filter(room -> room != null && room.getFormattedName().equals(selectedRoomName))
                    .findFirst()
                    .orElse(null);

            boolean noReservations = true;
            for(int i = 0; i < 31; i++){
                if(Utilities.isRoomOccupied(hotel, selectedRoom, i+1)){
                    noReservations = false;
                }
            }
            if (!noReservations){
                JOptionPane.showMessageDialog(null, "You cannot remove this room because there is currently a reservation!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                ((RemoveRoomModel) model).removeRoom(selectedRoom);
                JOptionPane.showMessageDialog(null, "Successfully removed " + selectedRoomName, "Room removed", JOptionPane.PLAIN_MESSAGE);
                frame.switchView(((RemoveRoomModel) model).manageHotel());
            }
        }
    }
}
