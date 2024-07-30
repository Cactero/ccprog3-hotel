package datePriceModifier;

import shared.AbstractController;
import shared.AbstractModel;
import Model.MainFrame;

import javax.swing.*;
import java.util.ArrayList;

public class DPMController extends AbstractController {
    public DPMController(AbstractModel model, MainFrame frame) {
        super(model, frame);
        view = new DPMView();

        ((DPMView) view).addMainMenuButtonListener(_ -> cancel());
        ((DPMView) view).addAddDPMButtonListener(_ -> createDPM());
    }

    public void cancel(){
        frame.switchView(((DPMModel) model).manageHotel());
    }

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

            ((DPMModel) model).addDPM(discountName, range, discountMultiplier);
            ((DPMView) view).resetInputFields();

        } catch (NumberFormatException _) {
            JOptionPane.showMessageDialog(null, "Discount multiplier is not a floating point number.", "Incorrect discount multiplier input", JOptionPane.PLAIN_MESSAGE);
        }

    }

}
