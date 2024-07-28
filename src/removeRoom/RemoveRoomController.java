package removeRoom;

import Model.Hotel;
import Model.Room;
import main.AbstractController;
import main.AbstractModel;
import main.MainFrame;
import shared.PopupScreen;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

/**
 * The Controller for Remove Room
 * @author Angela Domingo
 */
public class RemoveRoomController extends AbstractController implements PopupScreen {
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

        Room[] roomsArray = hotel.getRooms();
        if (roomsArray == null) {
            JOptionPane.showMessageDialog(null, "No rooms available", "Error", JOptionPane.ERROR_MESSAGE);
            frame.switchView(((RemoveRoomModel) model).manageHotel());
            return;
        }

        else if(hotel.getRoomCount() == 1){
            JOptionPane.showMessageDialog(null, "You cannot remove this room because it is the only room!", "Error", JOptionPane.ERROR_MESSAGE);
            frame.switchView(((RemoveRoomModel) model).manageHotel());
            return;
        }

        ArrayList<Room> rooms = new ArrayList<>(Arrays.asList(roomsArray));

        String[] roomNames = rooms.stream()
                .filter(room -> room != null)
                .map(Room::getFormattedName)
                .toArray(String[]::new);

        if (roomNames.length == 0) {
            JOptionPane.showMessageDialog(null, "No rooms available", "Error", JOptionPane.ERROR_MESSAGE);
            frame.switchView(((RemoveRoomModel) model).manageHotel());
            return;
        }

        selectedRoomName = (String) JOptionPane.showInputDialog(null, "Select a room", "Choose Room", JOptionPane.PLAIN_MESSAGE, null, roomNames, roomNames[0]);

        if (selectedRoomName == null) {
            // User canceled the input dialog
            frame.switchView(((RemoveRoomModel) model).manageHotel());
            return;
        }

        Room selectedRoom = Arrays.stream(roomsArray)
                .filter(room -> room != null && room.getFormattedName().equals(selectedRoomName))
                .findFirst()
                .orElse(null);

        if (selectedRoom == null) {
            JOptionPane.showMessageDialog(null, "Room not found", "Error", JOptionPane.ERROR_MESSAGE);
            frame.switchView(((RemoveRoomModel) model).manageHotel());
            return;
        }

        ((RemoveRoomModel) model).removeRoom(selectedRoom);
        JOptionPane.showMessageDialog(null, "Successfully removed " + selectedRoomName, "Room removed", JOptionPane.PLAIN_MESSAGE);
        frame.switchView(((RemoveRoomModel) model).manageHotel());
    }
}
