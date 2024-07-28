package viewHotel;

import Model.Client;
import Model.Hotel;
import Model.Room;
import Model.Utilities;
import chooseHotel.ChooseHotelModel;
import createReservation.CreateReservationModel;
import main.AbstractController;
import main.MainFrame;
import mainMenu.MainMenuModel;
import mainMenu.MainMenuView;
import manageHotel.ManageHotelModel;
import removeRoom.RemoveRoomModel;
import viewRoomAvailability.ViewRoomAvailabilityModel;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.util.ArrayList;

/**
 * The Controller for View Hotel
 * @author Angela Domingo
 * @author Ryan Gemal
 */
public class ViewHotelController extends AbstractController {

    public ViewHotelController(ViewHotelModel model, MainFrame frame) {
        super(model, frame);
        this.view = new ViewHotelView(model.getSelectedHotel());
        ((ViewHotelView) view).addHighLevelButtonListener(_ -> viewHighLevelInformation());
        ((ViewHotelView) view).addLowLevelButtonListener(_ -> viewLowLevelInformation());
        ((ViewHotelView) view).addMainMenuButtonListener(_ -> mainMenu());
    }

    public void mainMenu(){
        frame.switchView(((ViewHotelModel) model).mainMenu());
    }

    public void viewLowLevelInformation(){
        int option = chooseLowLevelOption();
        if(option == 0) {
            System.out.println("Number of available and booked rooms");
            int date = viewSelectedDate();
        }
        else if(option == 1){
            System.out.println("Selected room");
            viewRoomAvailability();
        }
        else if(option == 2){
            System.out.println("Selected reservation");
        }
    }

    public int chooseLowLevelOption() {
        String selectedOptionString;
        ArrayList<String> options = new ArrayList<>();
        options.add("Total number of available and booked rooms for a selected date");
        options.add("Information about a selected room");
        options.add("Information about a selected reservation");

        String[] optionsNames = options.toArray(new String[0]);

        selectedOptionString = (String) JOptionPane.showInputDialog(null, "Select an option", "Low-level Information", JOptionPane.PLAIN_MESSAGE, null, optionsNames, optionsNames[0]);

        if (selectedOptionString != null) {
            return options.indexOf(selectedOptionString);
        } else {
            return -1; // If no option is selected, return -1 or another value indicating no selection
        }
    }

    public void viewHighLevelInformation(){
        Hotel selectedHotel = ((ViewHotelModel) model).getSelectedHotel();
        JPanel highLevelPanel = new JPanel(new GridLayout(5,2));
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

        JOptionPane.showMessageDialog(null,highLevelPanel,"High-level Information",JOptionPane.INFORMATION_MESSAGE);

    }

    public int viewSelectedDate(){
        Hotel hotel = ((ViewHotelModel) model).getSelectedHotel();
        int bookedRooms = 0;

        JPanel viewDatePanel = new JPanel(new GridLayout(3,2));
        viewDatePanel.add(new JLabel("Hotel name: "));
        viewDatePanel.add(new JLabel(hotel.getName()));

        SpinnerNumberModel sModel = new SpinnerNumberModel(1, 1, 31, 1);
        JSpinner date = new JSpinner(sModel);

        int option = JOptionPane.showOptionDialog(null, date, "Enter date", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        if (option == JOptionPane.CANCEL_OPTION)
        {
            return 0;
        }
        else if (option == JOptionPane.OK_OPTION)
        {
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

            JOptionPane.showMessageDialog(null,viewDatePanel,"Selected date",JOptionPane.INFORMATION_MESSAGE);

            return option;
        }
        return 0;
    }

    public void viewRoomAvailability() {
        ViewHotelModel viewHotelModel = (ViewHotelModel) model;
        ViewRoomAvailabilityModel viewRoomAvailabilityModel = (ViewRoomAvailabilityModel) viewHotelModel.viewRoomAvailability();
        viewRoomAvailabilityModel.setSelectedHotel(viewHotelModel.getSelectedHotel());
        frame.switchView(viewRoomAvailabilityModel);
    }

}
