package datePriceModifier;

import shared.AbstractView;
import shared.TemplateButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class DPMView extends AbstractView {

    private JTextField discountNameField;
    private JRadioButton oneDayButtonField;
    private JRadioButton rangeButtonField;
    private JSpinner startRangeDayField;
    private JSpinner endRangeDayField;
    private JTextField discountMultiplierField;

    private JButton mainMenuButton;
    private JButton addDPMButton;

    public DPMView() {
        super("/assets/LABELS/DATE_PRICE_MODIFIER.png");

        JPanel inputHolder = new JPanel();
        inputHolder.setOpaque(false);
        discountNameField = new JTextField(10);
        oneDayButtonField = new JRadioButton("Apply modifier to one day only");
        oneDayButtonField.setSelected(true);
        rangeButtonField = new JRadioButton("Apply modifier to a range of dates");
        ButtonGroup bg = new ButtonGroup();
        bg.add(oneDayButtonField);
        bg.add(rangeButtonField);
        SpinnerNumberModel ranges = new SpinnerNumberModel(1, 1, 31, 1);
        startRangeDayField = new JSpinner(ranges);
        endRangeDayField = new JSpinner(ranges);
        discountMultiplierField = new JTextField(10);
        inputHolder.add(discountNameField);
        inputHolder.add(oneDayButtonField);
        inputHolder.add(rangeButtonField);
        inputHolder.add(startRangeDayField);
        inputHolder.add(endRangeDayField);
        inputHolder.add(discountMultiplierField);
        contentHolder.add(inputHolder);

        JPanel buttonsHolder = new JPanel();
        buttonsHolder.setOpaque(false);
        mainMenuButton = new TemplateButton("Cancel");
        addDPMButton = new TemplateButton("Add Date Price Modifier");
        buttonsHolder.add(mainMenuButton);
        buttonsHolder.add(addDPMButton);
        contentHolder.add(buttonsHolder, BorderLayout.SOUTH);
    }

    public void addAddDPMButtonListener(ActionListener listener) {
        addDPMButton.addActionListener(listener);
    }

    public void addMainMenuButtonListener(ActionListener listener) {
        mainMenuButton.addActionListener(listener);
    }

    public void resetInputFields(){
        discountNameField.setText("");
        discountMultiplierField.setText("");
        oneDayButtonField.setSelected(true);
        rangeButtonField.setSelected(false);
        startRangeDayField.setValue(1);
        endRangeDayField.setValue(1);
    }

    /**
     * Gets the text from the discount name field.
     * @return the text currently displayed in the discount name field.
     */
    public String getDiscountName() {
        return discountNameField.getText();
    }

    /**
     * Checks if the range button is selected.
     * @return true if the range button is selected, false otherwise.
     */
    public boolean isRangeSelected() {
        return rangeButtonField.isSelected();
    }

    /**
     * Gets the value from the start range day spinner.
     * @return the value of the start range day as an integer.
     */
    public int getStartRangeDay() {
        return (int) startRangeDayField.getValue();
    }

    /**
     * Gets the value from the end range day spinner.
     * @return the value of the end range day as an integer.
     */
    public int getEndRangeDay() {
        return (int) endRangeDayField.getValue();
    }

    /**
     * Gets the text from the discount multiplier field.
     * @return the text currently displayed in the discount multiplier field.
     */
    public String getDiscountMultiplier() {
        return discountMultiplierField.getText();
    }

}
