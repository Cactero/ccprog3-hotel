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

    }
}
