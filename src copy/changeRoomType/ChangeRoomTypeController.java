package changeRoomType;

import Model.Hotel;
import Model.Room;
import Model.Utilities;
import main.AbstractController;
import main.MainFrame;
import removeRoom.RemoveRoomModel;
import shared.PopupScreen;
import viewLowLevel.ViewLowLevelModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * The Controller for Change Room Type
 * @author Ryan Gemal
 */
public class ChangeRoomTypeController extends AbstractController implements PopupScreen {

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
                .filter(room -> room != null)
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
            return;
        }

        Room selectedRoom = Arrays.stream(roomsArray)
                .filter(room -> room != null && room.getFormattedName().equals(selectedRoomName))
                .findFirst()
                .orElse(null);

        if (selectedRoom == null) {
            JOptionPane.showMessageDialog(null, "Room not found", "Error", JOptionPane.ERROR_MESSAGE);
            frame.switchView(((ChangeRoomTypeModel) model).manageHotel());
            return;
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