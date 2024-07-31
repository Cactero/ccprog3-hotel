package updateBasePrice;

import Model.Hotel;
import shared.AbstractController;
import Model.MainFrame;
import shared.PopupScreen;

import javax.swing.*;
import java.awt.*;

/**
 * The Controller for Update Base Price
 * @author Ryan Gemal
 */
public class UpdateBasePriceController extends AbstractController implements PopupScreen {

    /**
     * The Constructor for Update Base Price Controller
     * @param model the Model object of Update Base Price
     * @param frame the main frame of the program
     */
    public UpdateBasePriceController(UpdateBasePriceModel model, MainFrame frame) {
        super(model, frame);
        this.view = new UpdateBasePriceView();
    }

    /**
     * The implementation of promptUser in PopupScreen for Update Base Price.
     */
    @Override
    public void promptUser(){
        Hotel hotel = ((UpdateBasePriceModel) model).getSelectedHotel();

        boolean hasConflict;
        String basePriceString;
        float basePrice;

        if (hotel.getClientCount() > 0){
            JOptionPane.showMessageDialog(null, "Unable to change base price due to existing reservations", "Reservations exist", JOptionPane.PLAIN_MESSAGE);
            frame.switchView(((UpdateBasePriceModel) model).manageHotel());
        } else {
            JPanel updateBasePricePanel = new JPanel(new GridLayout(2, 2, 10, 10));
            updateBasePricePanel.add(new JLabel("Current base price: "));
            updateBasePricePanel.add(new JLabel(String.format("$%.2f", hotel.getBasePrice())));

            updateBasePricePanel.add(new JLabel("Update base price?"));

            int option = JOptionPane.showOptionDialog(null, updateBasePricePanel, "Update base price", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (option == JOptionPane.OK_OPTION) {

                basePriceString = JOptionPane.showInputDialog("Enter new base price:");

                try {
                    basePrice = Float.parseFloat(basePriceString);

                    if (basePriceString.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Enter a new base price.", "No base price", JOptionPane.PLAIN_MESSAGE);
                        promptUser();
                    } else {
                        hasConflict = (hotel.getBasePrice() == basePrice) || basePrice < 100;

                        if (!hasConflict) {
                            ((UpdateBasePriceModel) model).setBasePrice(basePrice);
                            JOptionPane.showMessageDialog(null, "Successfully updated base price to $" + basePriceString + "!", "Hotel " + hotel.getName(), JOptionPane.PLAIN_MESSAGE);
                            frame.switchView(((UpdateBasePriceModel) model).manageHotel());
                        } else if (basePrice < 100) {
                            JOptionPane.showMessageDialog(null, "Base price must be at least $100.", "Invalid base price", JOptionPane.PLAIN_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Base price is already $" + basePriceString + ".", "Invalid base price", JOptionPane.PLAIN_MESSAGE);
                        }
                        promptUser();
                    }
                } catch (NumberFormatException _) {
                    JOptionPane.showMessageDialog(null, "Please enter a number.", "Invalid base price", JOptionPane.PLAIN_MESSAGE);
                    frame.switchView(((UpdateBasePriceModel) model).manageHotel());
                }

            } else {
                frame.switchView(((UpdateBasePriceModel) model).manageHotel());
            }
        }
    }
}
