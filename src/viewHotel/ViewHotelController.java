package viewHotel;

import Model.*;
import shared.AbstractController;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * The Controller for View Hotel
 * @author Angela Domingo
 * @author Ryan Gemal
 */
public class ViewHotelController extends AbstractController {

    /**
     * The Constructor for View Hotel Controller
     * @param model the Model object of View Hotel
     * @param frame the main frame of the program
     */
    public ViewHotelController(ViewHotelModel model, MainFrame frame) {
        super(model, frame);
        this.view = new ViewHotelView();
        ((ViewHotelView) view).addHighLevelButtonListener(_ -> viewHighLevelInformation());
        ((ViewHotelView) view).addLowLevelButtonListener(_ -> viewLowLevelInformation());

        ((ViewHotelView) view).addViewDateButtonListener(_ -> viewDate());
        ((ViewHotelView) view).addViewRoomButtonListener(_ -> promptRoom());
        ((ViewHotelView) view).addViewReservationListener(_ -> promptReservation());

        ((ViewHotelView) view).addMainMenuButtonListener(_ -> cancel());
    }

    /**
     * Switches to Main Menu screen when user clicks Cancel button
     */
    public void cancel(){
        frame.switchView(((ViewHotelModel) model).mainMenu());
    }

    /**
     * Displays the high level information of the Hotel.
     */
    public void viewHighLevelInformation(){

        ((ViewHotelView) view).removeLowLevelOptions();

        Hotel selectedHotel = ((ViewHotelModel) model).getSelectedHotel();
        JPanel highLevelPanel = new JPanel(new GridLayout(0,2));
        highLevelPanel.add(new JLabel("Hotel name: "));
        highLevelPanel.add(new JLabel(selectedHotel.getName()));

        highLevelPanel.add(new JLabel("Room count: "));
        highLevelPanel.add(new JLabel(Integer.toString(selectedHotel.getRoomCount())));

        highLevelPanel.add(new JLabel("Base Price: "));
        highLevelPanel.add(new JLabel(String.format("$%.2f", selectedHotel.getBasePrice())));

        highLevelPanel.add(new JLabel("Client Count: "));
        highLevelPanel.add(new JLabel(Integer.toString(selectedHotel.getClientCount())));

        highLevelPanel.add(new JLabel("Estimated monthly earnings: "));
        highLevelPanel.add(new JLabel(String.format("$%.2f", selectedHotel.getTotalReservationPrices())));

        JOptionPane.showMessageDialog(null,highLevelPanel,"High-level Information", JOptionPane.INFORMATION_MESSAGE);

    }

    /**
     * Displays the low level information buttons in the view.
     */
    public void viewLowLevelInformation(){
        ((ViewHotelView) view).showLowLevelOptions();
    }

    /**
     * Displays the low level view date information as a popup.
     */
    public void viewDate() {
        Hotel hotel = ((ViewHotelModel) model).getSelectedHotel();
        int bookedRooms = 0;

        JPanel viewDatePanel = new JPanel(new GridLayout(0,2));
        viewDatePanel.add(new JLabel("Hotel name: "));
        viewDatePanel.add(new JLabel(hotel.getName()));

        JSpinner date = new JSpinner(new SpinnerNumberModel(1, 1, 31, 1));

        int option = JOptionPane.showOptionDialog(null, date, "Enter date", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

        if (option == JOptionPane.OK_OPTION) {

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

    /**
     * Prompts the user to select a room for the information to be displayed
     */
    public void promptRoom() {
        String selectedRoomName;
        Hotel hotel = ((ViewHotelModel) model).getSelectedHotel();

        Room[] roomsArray = hotel.getRooms();

        ArrayList<Room> rooms = new ArrayList<>(Arrays.asList(roomsArray));

        String[] roomNames = rooms.stream()
                .filter(Objects::nonNull)
                .map(Room::getFormattedName)
                .toArray(String[]::new);

        selectedRoomName = (String) JOptionPane.showInputDialog(null, "Select a room", "Choose Room", JOptionPane.PLAIN_MESSAGE, null, roomNames, roomNames[0]);

        Arrays.stream(roomsArray)
                .filter(room -> room != null && room.getFormattedName().equals(selectedRoomName))
                .findFirst().ifPresent(this::viewRoom);

    }

    /**
     * Displays the low level view room information of the selected Room
     * @param room the Room object selected in promptRoom
     */
    private void viewRoom(Room room) {
        Hotel hotel = ((ViewHotelModel) model).getSelectedHotel();

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

    /**
     * Prompts the user to choose a reservation for its information to be displayed.
     */
    public void promptReservation(){
        Hotel hotel = ((ViewHotelModel) model).getSelectedHotel();

        if (hotel.getClientCount() == 0){
            JOptionPane.showMessageDialog(null, "No clients available", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Map<String, Client> clientMap = hotel.getClients().stream()
                    .collect(Collectors.toMap(
                            client -> String.format(
                                    "%s, %s: %s (%d-%d)",
                                    client.getLastName(),
                                    client.getFirstName(),
                                    client.getBookedRoom().getFormattedName(),
                                    client.getCheckInDay(),
                                    client.getCheckOutDay()
                            ),
                            client -> client
                    ));

            String[] clientNames = clientMap.keySet().toArray(new String[0]);

            JComboBox<String> clientList = new JComboBox<>(clientNames);

            int result = JOptionPane.showConfirmDialog(null, clientList, "Select reservation name", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                String selectedClientName = (String) clientList.getSelectedItem();
                Client selectedClient = clientMap.get(selectedClientName);

                viewReservation(selectedClient);
            }
        }
    }

    /**
     * Displays the information of the selected Client from promptReservation.
     * @param selectedClient the selected Client object from promptReservation
     */
    private void viewReservation(Client selectedClient) {
        JPanel contentHolder = new JPanel(new GridLayout(0, 2));

        contentHolder.add(new JLabel("Hotel Name: "));
        contentHolder.add(new JLabel(((ViewHotelModel) model).getSelectedHotel().getName()));

        contentHolder.add(new JLabel("Client name: "));
        contentHolder.add(new JLabel(String.format("%s, %s", selectedClient.getLastName(), selectedClient.getFirstName())));

        contentHolder.add(new JLabel("Booked room: "));
        contentHolder.add(new JLabel(String.format("%s (%s)", selectedClient.getBookedRoom().getFormattedName(), selectedClient.getBookedRoom().getType())));

        contentHolder.add(new JLabel("Booked dates: "));
        contentHolder.add(new JLabel(String.format("%d-%d (%d night/s)", selectedClient.getCheckInDay(), selectedClient.getCheckOutDay(), selectedClient.getNightsBooked())));

        contentHolder.add(new JLabel("Original reservation price: "));
        contentHolder.add(new JLabel(String.format("$%.2f", selectedClient.getNormalPrice())));

        contentHolder.add(new JLabel("Discounts used: "));
        String discountCodes = String.join(", ", selectedClient.getDiscountsUsed());
        contentHolder.add(new JLabel(discountCodes));

        contentHolder.add(new JLabel("Final reservation price: "));
        contentHolder.add(new JLabel(String.format("$%.2f", selectedClient.getFinalPrice())));

        JOptionPane.showMessageDialog(null, contentHolder, "View Reservation", JOptionPane.INFORMATION_MESSAGE);
    }

}
