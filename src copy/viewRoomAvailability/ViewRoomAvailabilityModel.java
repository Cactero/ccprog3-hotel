package viewRoomAvailability;

import Model.CentralModel;
import Model.Hotel;
import Model.Room;
import Model.Utilities;
import chooseHotel.ChooseHotelModel;
import main.AbstractModel;
import main.MainFrame;

import javax.swing.*;
import java.awt.*;

/**
 * The Model for View Room Availability
 * @author Ryan Gemal
 */
public class ViewRoomAvailabilityModel extends AbstractModel {

    private Hotel selectedHotel;

    public ViewRoomAvailabilityModel(CentralModel centralModel, MainFrame frame){
        super(centralModel);
        controller = new ViewRoomAvailabilityController(this, frame);
    }

    public AbstractModel mainMenu() {
        return centralModel.getModel(CentralModel.MAIN_MENU);
    }

    /**
     * The Model of View Hotel that is retrieved when the user clicks the Cancel button
     */
    public AbstractModel viewHotel(){
        return centralModel.getModel(CentralModel.VIEW_HOTEL);
    }

    /**
     * The Model of Choose Hotel that is retrieved when the user clicks one of the buttons
     */
    public AbstractModel chooseHotel(String source){
        ChooseHotelModel model = (ChooseHotelModel) centralModel.getModel(CentralModel.CHOOSE_HOTEL);
        model.setSource(source);
        return model;
    }

    public void viewRoom(Room room) {
        JPanel overallPanel = new JPanel(new BorderLayout());

        JPanel viewRoomPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        viewRoomPanel.add(new JLabel("Hotel name: "));
        viewRoomPanel.add(new JLabel(selectedHotel.getName()));
        viewRoomPanel.add(new JLabel("Room name: "));
        viewRoomPanel.add(new JLabel(room.getFormattedName()));

        JPanel calendarPanel = new JPanel(new GridLayout(5, 7, 5, 5)); // 5 rows, 7 columns, with spacing

        for (int i = 0; i < 31; i++) {
            int day = i + 1;
            String dayLabel = String.format("%02d: ", day); // Add leading zero
            boolean isBooked = Utilities.isRoomOccupied(selectedHotel, room, day);
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

        overallPanel.add(viewRoomPanel, BorderLayout.NORTH);
        overallPanel.add(calendarPanel, BorderLayout.CENTER);

        JOptionPane.showMessageDialog(null, overallPanel, "View Room", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Sets the selected hotel the user chose previously in the Choose Hotel screen
     * @param hotel the selected Hotel
     */
    public void setSelectedHotel(Hotel hotel) {
        this.selectedHotel = hotel;
    }

    /**
     * Gets the selected hotel the user chose previously in the Choose Hotel screen
     * @return the selected Hotel
     */
    public Hotel getSelectedHotel() {
        return selectedHotel;
    }}
