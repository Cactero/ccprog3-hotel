package datePriceModifier;

import shared.AbstractView;
import shared.TemplateButton;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The View for Date Price Modifier.
 * @author Angela Domingo
 */
public class DPMView extends AbstractView {

    private JTextField discountNameField;
    private JRadioButton oneDayButtonField;
    private JRadioButton rangeButtonField;
    private JSpinner startRangeDayField;
    private JSpinner endRangeDayField;
    private JTextField discountMultiplierField;

    private JButton mainMenuButton;
    private JButton addDPMButton;

    /**
     * The Constructor for DPM View.
     */
    public DPMView() {
        super("/assets/LABELS/DATE_PRICE_MODIFIER.png");

        JPanel inputHolder = new JPanel(new GridLayout(0, 2));
        inputHolder.setBackground(new Color(255, 242, 217));
        inputHolder.setBorder(new CompoundBorder(
                new LineBorder(new Color(234, 183, 55), 10),
                new EmptyBorder(20, 20, 20, 20)
        ));

        JLabel discountNameLabel = new JLabel("Discount Name");
        discountNameField = new JTextField(10);
        inputHolder.add(discountNameLabel);
        inputHolder.add(discountNameField);


        oneDayButtonField = new JRadioButton("Apply modifier to one day only");
        rangeButtonField = new JRadioButton("Apply modifier to a range of dates");
        ButtonGroup bg = new ButtonGroup();
        bg.add(oneDayButtonField);
        bg.add(rangeButtonField);
        oneDayButtonField.setSelected(true);
        inputHolder.add(oneDayButtonField);
        inputHolder.add(rangeButtonField);


        startRangeDayField = new JSpinner(new SpinnerNumberModel(1, 1, 31, 1));
        endRangeDayField = new JSpinner(new SpinnerNumberModel(1, 1, 31, 1));
        inputHolder.add(new JLabel("Start Day"));
        inputHolder.add(startRangeDayField);
        inputHolder.add(new JLabel("End Day"));
        inputHolder.add(endRangeDayField);


        JLabel discountMultiplierLabel = new JLabel("Discount Multiplier");
        JPanel fieldHolder = new JPanel(new BorderLayout());
        fieldHolder.setOpaque(false);
        discountMultiplierField = new JTextField(10);
        fieldHolder.add(discountMultiplierField, BorderLayout.CENTER);
        fieldHolder.add(new JLabel("X"), BorderLayout.EAST);
        inputHolder.add(discountMultiplierLabel);
        inputHolder.add(fieldHolder);

        JPanel centerHolder = new JPanel(new BorderLayout());
        centerHolder.setOpaque(false);
        centerHolder.add(inputHolder, BorderLayout.CENTER);
        centerHolder.setBorder(new EmptyBorder(50, 200, 100, 200));

        contentHolder.add(centerHolder);

        JPanel buttonsHolder = new JPanel();
        buttonsHolder.setOpaque(false);
        mainMenuButton = new TemplateButton("Cancel");
        addDPMButton = new TemplateButton("Add Date Price Modifier");
        buttonsHolder.add(mainMenuButton);
        buttonsHolder.add(addDPMButton);
        contentHolder.add(buttonsHolder, BorderLayout.SOUTH);
    }

    /**
     * Adds a listener to the Add Date Price Modifier button.
     * @param listener the set of actions to be done when the button is clicked
     */
    public void addAddDPMButtonListener(ActionListener listener) {
        addDPMButton.addActionListener(listener);
    }

    /**
     * Adds a listener to the Cancel button.
     * @param listener the set of actions to be done when the button is clicked
     */
    public void addMainMenuButtonListener(ActionListener listener) {
        mainMenuButton.addActionListener(listener);
    }

    /**
     * Resets the input fields after a failed attempt.
     */
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
