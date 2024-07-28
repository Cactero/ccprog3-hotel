package viewHotel;

import Model.Hotel;
import main.AbstractController;
import main.MainFrame;
import viewLowLevel.ViewLowLevelModel;

import javax.swing.*;
import java.awt.*;

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
        ViewHotelModel viewHotelModel = (ViewHotelModel) model;
        ViewLowLevelModel viewLowLevelModel = (ViewLowLevelModel) viewHotelModel.viewRoomAvailability();
        viewLowLevelModel.setSelectedHotel(viewHotelModel.getSelectedHotel());
        frame.switchView(viewLowLevelModel);
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
}
