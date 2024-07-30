package viewHotel.viewLowLevel;

import Model.Client;
import Model.Hotel;
import Model.Room;
import Model.Utilities;
import chooseHotel.ChooseHotelModel;
import shared.AbstractController;
import Model.MainFrame;
import viewHotel.viewReservation.ViewReservationModel;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

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

        if (option == JOptionPane.OK_OPTION) {
            // user entered a number
            //return option;

            for (Client client : hotel.getClients()) {
                if ((client.getCheckInDay() <= (Integer) date.getValue() && (Integer) date.getValue() <= client.getCheckOutDay())) {
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

        ArrayList<Room> rooms = new ArrayList<>(Arrays.asList(roomsArray));

        String[] roomNames = rooms.stream()
                .filter(Objects::nonNull)
                .map(Room::getFormattedName)
                .toArray(String[]::new);

        selectedRoomName = (String) JOptionPane.showInputDialog(null, "Select a room", "Choose Room", JOptionPane.PLAIN_MESSAGE, null, roomNames, roomNames[0]);

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
        Hotel hotel = ((ViewLowLevelModel) model).getSelectedHotel();
        String firstName = "";
        String lastName = "";
        int checkInDay;
        int checkOutDay;
        String discountCode;
        String room;

        JPanel promptPanel = new JPanel(new GridLayout(4, 2));

        JLabel firstNameLabel = new JLabel("First Name");
        JTextField firstNameField = new JTextField();
        promptPanel.add(firstNameLabel);
        promptPanel.add(firstNameField);
        JLabel lastNameLabel = new JLabel("Last Name");
        JTextField lastNameField = new JTextField();
        promptPanel.add(lastNameLabel);
        promptPanel.add(lastNameField);

        JOptionPane.showMessageDialog(null, promptPanel, "Enter reservation name", JOptionPane.INFORMATION_MESSAGE);

        if(firstNameField.getText() != null && lastNameField.getText() != null){
            Client selectedClient = hotel.getClients().stream()
                    .filter(client -> (firstNameField.getText().equals(client.getFirstName()) && lastNameField.getText().equals(client.getLastName())))
                    .findFirst()
                    .orElse(null);

            if(selectedClient == null){
                JOptionPane.showMessageDialog(null, "Client not found, please try again.", "Invalid Client", JOptionPane.ERROR_MESSAGE);
            }
            else{
                frame.switchView(((ViewLowLevelModel) model).getModel(selectedClient, "View Reservation"));
            }

        }
        else{
            JOptionPane.showMessageDialog(null, "Invalid client, try again.", "Invalid", JOptionPane.ERROR_MESSAGE);
        }
    }


}
