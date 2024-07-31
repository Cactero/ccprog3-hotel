package changeRoomType;

import Model.Hotel;
import Model.Room;
import shared.AbstractController;
import Model.MainFrame;
import shared.PopupScreen;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * The Controller for Change Room Type
 * @author Ryan Gemal
 */
public class ChangeRoomTypeController extends AbstractController implements PopupScreen {

    /**
     * The Constructor for Change Room Type Controller
     * @param model the Model object of Change Room Type
     * @param frame the main frame of the program
     */
    public ChangeRoomTypeController(ChangeRoomTypeModel model, MainFrame frame) {
        super(model, frame);
        this.view = new ChangeRoomTypeView();
    }

    /**
     * The implementation of promptUser in PopupScreen for Change Room Type.
     */
    @Override
    public void promptUser() {
        String selectedRoomName;
        Hotel hotel = ((ChangeRoomTypeModel) model).getSelectedHotel();

        Room[] roomsArray = hotel.getRooms();
        if (roomsArray == null) {
            JOptionPane.showMessageDialog(null, "No rooms available", "Error", JOptionPane.ERROR_MESSAGE);
            frame.switchView(((ChangeRoomTypeModel) model).manageHotel());
            return;
        }

        ArrayList<Room> rooms = new ArrayList<>(Arrays.asList(roomsArray));

        String[] roomNames = rooms.stream()
                .filter(Objects::nonNull)
                .map(Room::getFormattedName)
                .toArray(String[]::new);

        if (roomNames.length == 0) {
            JOptionPane.showMessageDialog(null, "No rooms available", "Error", JOptionPane.ERROR_MESSAGE);
            frame.switchView(((ChangeRoomTypeModel) model).manageHotel());
            return;
        }

        selectedRoomName = (String) JOptionPane.showInputDialog(null, "Select a room", "Choose Room", JOptionPane.PLAIN_MESSAGE, null, roomNames, roomNames[0]);

        if (selectedRoomName == null) {
            // User canceled the input dialog
            frame.switchView(((ChangeRoomTypeModel) model).manageHotel());
        }

        Room selectedRoom = Arrays.stream(roomsArray)
                .filter(room -> room != null && room.getFormattedName().equals(selectedRoomName))
                .findFirst()
                .orElse(null);

        if (selectedRoom == null) {
            JOptionPane.showMessageDialog(null, "Room not found", "Error", JOptionPane.ERROR_MESSAGE);
            frame.switchView(((ChangeRoomTypeModel) model).manageHotel());
        }

        String[] roomTypes = {"Standard", "Deluxe", "Executive"};

        String selectedType = (String) JOptionPane.showInputDialog(null, "Select a room type", "Choose Room Type", JOptionPane.PLAIN_MESSAGE, null, roomTypes, roomTypes[0]);

        if(!selectedRoom.getType().equals(selectedType)){
            ((ChangeRoomTypeModel) model).setRoomType(selectedRoom, selectedType);
            JOptionPane.showMessageDialog(null, "Successfully changed " + selectedRoomName + "'s type to " + selectedType + ".", "Room type changed", JOptionPane.PLAIN_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, selectedRoomName + "'s type is already " + selectedType + ".", "Room type", JOptionPane.PLAIN_MESSAGE);
        }
        frame.switchView(((ChangeRoomTypeModel) model).manageHotel());
    }
}