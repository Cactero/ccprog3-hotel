package createReservation;

import Model.Hotel;
import Model.Room;
import shared.AbstractView;
import shared.TemplateButton;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Objects;

public class CreateReservationView extends AbstractView {


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

        JPanel inputHolder = new JPanel(new GridLayout(0, 2));
        inputHolder.setBackground(new Color(255, 242, 217));
        inputHolder.setBorder(new CompoundBorder(
                new LineBorder(new Color(234, 183, 55), 10),
                new EmptyBorder(20, 20, 20, 20)
        ));

        JLabel firstNameLabel = new JLabel("First Name");
        firstNameField = new JTextField(10);
        inputHolder.add(firstNameLabel);
        inputHolder.add(firstNameField);


        JLabel lastNameLabel = new JLabel("Last Name");
        lastNameField = new JTextField(10);
        inputHolder.add(lastNameLabel);
        inputHolder.add(lastNameField);


        JLabel checkInDayLabel = new JLabel("Check-In Day");
        checkInDayField = new JSpinner(new SpinnerNumberModel(1, 1, 30, 1));
        inputHolder.add(checkInDayLabel);
        inputHolder.add(checkInDayField);


        JLabel checkOutDayLabel = new JLabel("Check-Out Day");
        checkOutDayField = new JSpinner(new SpinnerNumberModel(2, 2, 31, 1));
        inputHolder.add(checkOutDayLabel);
        inputHolder.add(checkOutDayField);


        String[] roomNames = {};
        if (selectedHotel != null && selectedHotel.getRooms() != null) {
            roomNames = Arrays.stream(selectedHotel.getRooms())
                    .filter(Objects::nonNull) // Filter out null rooms
                    .map(Room::getFormattedName)
                    .toArray(String[]::new);
        }


        JLabel roomListLabel = new JLabel("Desired Room");
        roomListField = new JComboBox<>(roomNames);
        inputHolder.add(roomListLabel);
        inputHolder.add(roomListField);


        JLabel discountLabel = new JLabel("Discount Code (optional)");
        discountField = new JTextField(10);
        inputHolder.add(discountLabel);
        inputHolder.add(discountField);

        JPanel centerHolder = new JPanel(new BorderLayout());
        centerHolder.setOpaque(false);
        centerHolder.add(inputHolder, BorderLayout.CENTER);
        centerHolder.setBorder(new EmptyBorder(50, 200, 100, 200));

        contentHolder.add(centerHolder, BorderLayout.CENTER);

        buttonsHolder = new JPanel();
        buttonsHolder.setOpaque(false);
        mainMenuButton = new TemplateButton("Cancel");
        buttonsHolder.add(mainMenuButton);
        createClientButton = new TemplateButton("Create");
        buttonsHolder.add(createClientButton);
        contentHolder.add(buttonsHolder, BorderLayout.SOUTH);
    }

    /**
     * Adds a listener to the Main Menu button.
     * @param listener the set of actions to be done when the button is clicked
     */
    public void addMainMenuButtonListener(ActionListener listener) { mainMenuButton.addActionListener(listener); }

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
     * Updates the list of rooms in the view.
     * @param roomNames an array of room names in the selected Hotel
     */
    public void updateRoomList(String[] roomNames) {
        roomListField.removeAllItems(); // Clear existing items
        for (String roomName : roomNames) {
            roomListField.addItem(roomName); // Add new items
        }
    }
}
