package createReservation;

import Model.Hotel;
import Model.Room;
import main.AbstractView;
import shared.TemplateButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Objects;

/**
 * The View for Create Reservation.
 * @author Angela Domingo
 */
public class CreateReservationView extends AbstractView {

    private JPanel inputHolder;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JSpinner checkInDayField;
    private JSpinner checkOutDayField;
    private JComboBox<String> roomListField;
    private JTextField discountField;

    private JPanel buttonsHolder;
    private JButton mainMenuButton;
    private JButton createClientButton;

    public CreateReservationView(Hotel selectedHotel){
        super("/assets/LABELS/CREATE_RESERVATION.png");

        inputHolder = new JPanel();
        inputHolder.setOpaque(false);
        firstNameField = new JTextField(10);
        lastNameField = new JTextField(10);
        SpinnerNumberModel checkInDayOptions = new SpinnerNumberModel(1, 1, 30, 1);
        checkInDayField = new JSpinner(checkInDayOptions);
        SpinnerNumberModel checkOutDayOptions = new SpinnerNumberModel(2, 2, 31, 1);
        checkOutDayField = new JSpinner(checkOutDayOptions);
        String[] roomNames = Arrays.stream(selectedHotel.getRooms())
                .filter(Objects::nonNull) // filter out null rooms
                .map(Room::getFormattedName)
                .toArray(String[]::new);

        roomListField = new JComboBox<>(roomNames);
        discountField = new JTextField(10);
        inputHolder.add(firstNameField);
        inputHolder.add(lastNameField);
        inputHolder.add(checkInDayField);
        inputHolder.add(checkOutDayField);
        inputHolder.add(roomListField);
        inputHolder.add(discountField);
        contentHolder.add(inputHolder);

        // cancel room creation and create room buttons
        buttonsHolder = new JPanel();
        buttonsHolder.setOpaque(false);
        mainMenuButton = new TemplateButton("Cancel");
        buttonsHolder.add(mainMenuButton);
        createClientButton = new TemplateButton("Create");
        buttonsHolder.add(createClientButton);
        contentHolder.add(buttonsHolder, BorderLayout.SOUTH);


    }

    /**
     * Returns the current content of firstNameField
     * @return the text currently inside firstNameField
     */
    public String getFirstName() { return firstNameField.getText(); }

    /**
     * Returns the current content of lastNameField.
     * @return the text currently inside lastNameField
     */
    public String getLastName() { return lastNameField.getText(); }

    /**
     * Returns the current content of checkInDayField.
     * @return the number currently inside checkInDayField
     */
    public int getCheckInDay() { return (int) checkInDayField.getValue(); }

    /**
     * Returns the current content of checkOutDayField
     * @return the number currently inside checkOutDayField
     */
    public int getCheckOutDay() { return (int) checkOutDayField.getValue(); }

    /**
     * Returns the current content of discountField
     * @return the text currently inside discountField
     */
    public String getDiscountCode() {
        return discountField.getText();
    }

    /**
     * Returns the current content of roomListField
     * @return the name of the Room currently inside roomListField
     */
    public String getSelectedRoom() { return (String) roomListField.getSelectedItem(); }

    /**
     * Resets the input fields after a failed attempt.
     */
    public void resetInputFields() {
        firstNameField.setText("");
        lastNameField.setText("");
        checkInDayField.setValue(1);
        checkOutDayField.setValue(2);
        roomListField.setSelectedIndex(0);
        discountField.setText("");
    }

    /**
     * Adds a listener to the Create Client button.
     * @param listener the set of actions to be done when the button is clicked
     */
    public void addCreateClientButtonListener(ActionListener listener) { createClientButton.addActionListener(listener); }

    /**
     * Adds a listener to the Main Menu button.
     * @param listener the set of actions to be done when the button is clicked
     */
    public void addMainMenuButtonListener(ActionListener listener) { mainMenuButton.addActionListener(listener); }
}
