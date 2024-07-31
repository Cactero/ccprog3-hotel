package datePriceModifier;

import shared.AbstractController;
import shared.AbstractModel;
import Model.MainFrame;

import javax.swing.*;
import java.util.ArrayList;

/**
 * The Controller for Date Price Modifier.
 * @author Angela Domingo
 */
public class DPMController extends AbstractController {

    /**
     * The Constructor for DPM Controller
     * @param model the Model object of DPM
     * @param frame the main frame of the program
     */
    public DPMController(AbstractModel model, MainFrame frame) {
        super(model, frame);
        view = new DPMView();

        ((DPMView) view).addMainMenuButtonListener(_ -> cancel());
        ((DPMView) view).addAddDPMButtonListener(_ -> createDPM());
    }

    /**
     * Brings the user back to the Manage Hotel screen when the Cancel button is clicked.
     */
    public void cancel(){
        frame.switchView(((DPMModel) model).manageHotel());
    }

    /**
     * Generates the date price modifiers to be added to the Hotel.
     */
    public void createDPM(){
        try {
            String discountName = ((DPMView) view).getDiscountName();
            boolean isRange = ((DPMView) view).isRangeSelected();
            int startRangeDay = ((DPMView) view).getStartRangeDay();
            int endRangeDay = ((DPMView) view).getEndRangeDay();
            float discountMultiplier = Float.parseFloat(((DPMView) view).getDiscountMultiplier());

            ArrayList<Integer> range = new ArrayList<>();
            range.add(startRangeDay);

            if (isRange){
                for (int i = startRangeDay + 1; i <= endRangeDay; i++) {
                    range.add(i);
                }
            }

            if (discountName.isEmpty()){
                JOptionPane.showMessageDialog(null, "Please enter a discount name.", "Empty discount name field", JOptionPane.PLAIN_MESSAGE);
            } else {
                ((DPMModel) model).addDPM(discountName, range, discountMultiplier);
                JOptionPane.showMessageDialog(null, "Added date price modifier " + discountName, "New DPM added", JOptionPane.PLAIN_MESSAGE);
                ((DPMView) view).resetInputFields();
            }

        } catch (NumberFormatException _) {
            JOptionPane.showMessageDialog(null, "Discount multiplier is not a floating point number.", "Incorrect discount multiplier input", JOptionPane.PLAIN_MESSAGE);
        }

    }

}
