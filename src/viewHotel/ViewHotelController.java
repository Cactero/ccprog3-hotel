package viewHotel;

import Model.Hotel;
import main.AbstractController;
import main.MainFrame;

import javax.swing.*;
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
        this.view = new ViewHotelView();
        ((ViewHotelView) view).addHighLevelButtonListener(_ -> viewHighLevelInformation());
        ((ViewHotelView) view).addLowLevelButtonListener(_ -> viewLowLevelInformation());
        ((ViewHotelView) view).addMainMenuButtonListener(_ -> cancel());
    }

    public void cancel(){
        frame.switchView(((ViewHotelModel) model).mainMenu());
    }

    public void viewLowLevelInformation(){
        int option = chooseLowLevelOption();
        if(option == 0) {
            System.out.println("Number of available and booked rooms");
        }
        else if(option == 1){
            System.out.println("Selected room");
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

        /*
        System.out.printf("Base Price: $%.2f\n", hotel.getBasePrice());
        System.out.printf("Client Count: %d\n", hotel.getClientCount());
        System.out.printf("Estimated earnings for the month: $%.2f\n\n", hotel.getTotalReservationPrices());
        */

        JOptionPane.showMessageDialog(null,highLevelPanel,"High-level Information",JOptionPane.INFORMATION_MESSAGE);

    }
}
