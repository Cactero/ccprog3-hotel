package viewLowLevel;

import Model.Client;
import Model.Hotel;
import Model.Room;
import Model.Utilities;
import main.AbstractController;
import main.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * The Controller for View Room Availability.
 * @author Ryan Gemal
 */
public class ViewLowLevelController extends AbstractController {

    public ViewLowLevelController(ViewLowLevelModel model, MainFrame frame) {
        super(model, frame);
        this.view = new ViewLowLevelView();

        ((ViewLowLevelView) view).addMainMenuButtonListener(_ -> mainMenu());
        ((ViewLowLevelView) view).addViewDateButtonListener(_ -> viewDate());
        ((ViewLowLevelView) view).addViewRoomButtonListener(_ -> promptRoom());
        ((ViewLowLevelView) view).addViewReservationListener(_ -> viewReservation());
    }

    public void mainMenu() {
        frame.switchView(((ViewLowLevelModel) model).mainMenu());
    }

    public void viewDate() {
        Hotel hotel = ((ViewLowLevelModel) model).getSelectedHotel();
        int bookedRooms = 0;

        JPanel viewDatePanel = new JPanel(new GridLayout(3,2));
        viewDatePanel.add(new JLabel("Hotel name: "));
        viewDatePanel.add(new JLabel(hotel.getName()));

        SpinnerNumberModel sModel = new SpinnerNumberModel(1, 1, 31, 1);
        JSpinner date = new JSpinner(sModel);

        int option = JOptionPane.showOptionDialog(null, date, "Enter date", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        if (option == JOptionPane.CANCEL_OPTION)
        {
            // do nothing
        }
        else if (option == JOptionPane.OK_OPTION) {
            // user entered a number
            //return option;

            for (Client client : hotel.getClients()) {
                if ((client.getCheckInDay() <= option && option <= client.getCheckOutDay())) {
                    bookedRooms++;
                }
            }

            viewDatePanel.add(new JLabel("Available Rooms: "));
            viewDatePanel.add(new JLabel(Integer.toString(hotel.getRoomCount() - bookedRooms)));

            viewDatePanel.add(new JLabel("Booked Rooms: "));
            viewDatePanel.add(new JLabel(Integer.toString(bookedRooms)));

            JOptionPane.showMessageDialog(null, viewDatePanel, "Selected date", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    public void promptRoom() {
        String selectedRoomName;
        Hotel hotel = ((ViewLowLevelModel) model).getSelectedHotel();

        Room[] roomsArray = hotel.getRooms();
        if (roomsArray == null) {
            JOptionPane.showMessageDialog(null, "No rooms available", "Error", JOptionPane.ERROR_MESSAGE);
            //frame.switchView(((viewLowLevelModel) model).viewHotel());
            return;
        }

        ArrayList<Room> rooms = new ArrayList<>(Arrays.asList(roomsArray));

        String[] roomNames = rooms.stream()
                .filter(room -> room != null)
                .map(Room::getFormattedName)
                .toArray(String[]::new);

        if (roomNames.length == 0) {
            JOptionPane.showMessageDialog(null, "No rooms available", "Error", JOptionPane.ERROR_MESSAGE);
            //frame.switchView(((viewLowLevelModel) model).viewHotel());
            return;
        }

        selectedRoomName = (String) JOptionPane.showInputDialog(null, "Select a room", "Choose Room", JOptionPane.PLAIN_MESSAGE, null, roomNames, roomNames[0]);

        if (selectedRoomName == null) {
            // User canceled the input dialog
            //frame.switchView(((viewLowLevelModel) model).viewHotel());
            return;
        }

        Room selectedRoom = Arrays.stream(roomsArray)
                .filter(room -> room != null && room.getFormattedName().equals(selectedRoomName))
                .findFirst()
                .orElse(null);

        if (selectedRoom == null) {
            JOptionPane.showMessageDialog(null, "Room not found", "Error", JOptionPane.ERROR_MESSAGE);
            //frame.switchView(((viewLowLevelModel) model).viewHotel());
            return;
        }

        viewRoom(selectedRoom);
        //JOptionPane.showMessageDialog(null, "Successfully removed " + selectedRoomName, "Room removed", JOptionPane.PLAIN_MESSAGE);
        //frame.switchView(((viewLowLevelModel) model).viewHotel());
    }

    public void viewRoom(Room room) {
        Hotel hotel = ((ViewLowLevelModel) model).getSelectedHotel();

        JPanel overallPanel = new JPanel(new BorderLayout(5, 4));

        JPanel labels = new JPanel(new GridLayout(4, 2));
        labels.add(new JLabel("Hotel name:"));
        labels.add(new JLabel(hotel.getName()));

        labels.add(new JLabel("Room name:"));
        labels.add(new JLabel(room.getFormattedName()));

        labels.add(new JLabel("Room type:"));
        labels.add(new JLabel(room.getType()));

        labels.add(new JLabel("Price per night:"));
        labels.add(new JLabel(String.format("$%.2f", room.getBasePrice())));

        JPanel calendarPanel = new JPanel(new GridLayout(5, 7, 8, 2)); // 5 rows, 7 columns, with spacing

        for (int i = 0; i < 31; i++) {
            int day = i + 1;
            String dayLabel = String.format("%02d: ", day); // Add leading zero
            boolean isBooked = Utilities.isRoomOccupied(hotel, room, day);
            String availability = isBooked ? "B" : "A";

            // Create a panel to hold day number and availability status
            JPanel dayPanel = new JPanel(new BorderLayout());
            dayPanel.add(new JLabel(dayLabel), BorderLayout.WEST);

            JLabel availabilityLabel = new JLabel(availability, JLabel.CENTER);
            availabilityLabel.setOpaque(true);

            // Set color based on availability
            if (isBooked) {
                availabilityLabel.setForeground(Color.RED);
            } else {
                availabilityLabel.setForeground(Color.GREEN);
            }

            dayPanel.add(availabilityLabel, BorderLayout.CENTER);
            calendarPanel.add(dayPanel);
        }

        overallPanel.add(labels, BorderLayout.NORTH);
        overallPanel.add(calendarPanel, BorderLayout.CENTER);

        JOptionPane.showMessageDialog(null, overallPanel, "View Room", JOptionPane.INFORMATION_MESSAGE);
    }

    public void viewReservation(){

    }
}
