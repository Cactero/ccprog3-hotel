package viewRoomAvailability;

import Model.Hotel;
import Model.Room;
import chooseHotel.ChooseHotelModel;
import main.AbstractController;
import main.MainFrame;
import removeRoom.RemoveRoomModel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * The Controller for View Room Availability.
 * @author Ryan Gemal
 */
public class ViewRoomAvailabilityController extends AbstractController {

    public ViewRoomAvailabilityController(ViewRoomAvailabilityModel model, MainFrame frame) {
        super(model, frame);
        this.view = new ViewRoomAvailabilityView();

        ((ViewRoomAvailabilityView) view).addMainMenuButtonListener(_ -> mainMenu());
        ((ViewRoomAvailabilityView) view).addViewCalendarButtonListener(_ -> promptUser());
    }

    public void mainMenu(){
        frame.switchView(((ViewRoomAvailabilityModel) model).mainMenu());
    }

    public void viewCalendar() {

    }

    public void promptUser() {
        String selectedRoomName;
        Hotel hotel = ((ViewRoomAvailabilityModel) model).getSelectedHotel();

        Room[] roomsArray = hotel.getRooms();
        if (roomsArray == null) {
            JOptionPane.showMessageDialog(null, "No rooms available", "Error", JOptionPane.ERROR_MESSAGE);
            frame.switchView(((ViewRoomAvailabilityModel) model).viewHotel());
            return;
        }

        ArrayList<Room> rooms = new ArrayList<>(Arrays.asList(roomsArray));

        String[] roomNames = rooms.stream()
                .filter(room -> room != null)
                .map(Room::getFormattedName)
                .toArray(String[]::new);

        if (roomNames.length == 0) {
            JOptionPane.showMessageDialog(null, "No rooms available", "Error", JOptionPane.ERROR_MESSAGE);
            frame.switchView(((ViewRoomAvailabilityModel) model).viewHotel());
            return;
        }

        selectedRoomName = (String) JOptionPane.showInputDialog(null, "Select a room", "Choose Room", JOptionPane.PLAIN_MESSAGE, null, roomNames, roomNames[0]);

        if (selectedRoomName == null) {
            // User canceled the input dialog
            frame.switchView(((ViewRoomAvailabilityModel) model).viewHotel());
            return;
        }

        Room selectedRoom = Arrays.stream(roomsArray)
                .filter(room -> room != null && room.getFormattedName().equals(selectedRoomName))
                .findFirst()
                .orElse(null);

        if (selectedRoom == null) {
            JOptionPane.showMessageDialog(null, "Room not found", "Error", JOptionPane.ERROR_MESSAGE);
            frame.switchView(((ViewRoomAvailabilityModel) model).viewHotel());
            return;
        }

        ((ViewRoomAvailabilityModel) model).viewRoom(selectedRoom);
        //JOptionPane.showMessageDialog(null, "Successfully removed " + selectedRoomName, "Room removed", JOptionPane.PLAIN_MESSAGE);
        frame.switchView(((ViewRoomAvailabilityModel) model).viewHotel());
    }
}
