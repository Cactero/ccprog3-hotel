package createRoom;

import shared.AbstractView;
import shared.TemplateButton;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The View of Create Room.
 * @author Angela Domingo
 */
public class CreateRoomView extends AbstractView {

    private JPanel roomInfoHolder;
    private JTextField roomFloorField;
    private JTextField roomNumberField;
    private JComboBox<String> roomTypeField;

    private JPanel buttonsHolder;
    private JButton mainMenuButton;
    private JButton createRoomButton;

    public CreateRoomView(boolean fromCreateHotel) {
        super("/assets/LABELS/CREATE_ROOM.png");

        roomInfoHolder = new JPanel(new GridLayout(0, 2));
        roomInfoHolder.setBackground(new Color(255, 242, 217));
        roomInfoHolder.setBorder(new CompoundBorder(
                new LineBorder(new Color(234, 183, 55), 10),
                new EmptyBorder(20, 20, 20, 20)
        ));

        // Create and add components for roomFloorField
        JLabel roomFloorLabel = new JLabel("Room Floor");
        roomFloorField = new JTextField(10);
        roomInfoHolder.add(roomFloorLabel);
        roomInfoHolder.add(roomFloorField);

        // Create and add components for roomNumberField
        JLabel roomNumberLabel = new JLabel("Room Number");
        roomNumberField = new JTextField(10);
        roomInfoHolder.add(roomNumberLabel);
        roomInfoHolder.add(roomNumberField);

        // Create and add components for roomTypeField
        JLabel roomTypeLabel = new JLabel("Room Type");
        String[] roomTypes = new String[]{"Standard", "Deluxe", "Executive"};
        roomTypeField = new JComboBox<>(roomTypes);
        roomInfoHolder.add(roomTypeLabel);
        roomInfoHolder.add(roomTypeField);

        JPanel centerHolder = new JPanel(new BorderLayout());
        centerHolder.setOpaque(false);
        centerHolder.add(roomInfoHolder, BorderLayout.CENTER);
        centerHolder.setBorder(new EmptyBorder(125, 400, 200, 400));

        contentHolder.add(centerHolder, BorderLayout.CENTER);

        // cancel room creation and create room buttons
        buttonsHolder = new JPanel();
        buttonsHolder.setOpaque(false);

        // Only add mainMenuButton if fromCreateHotel is false
        if (!fromCreateHotel) {
            mainMenuButton = new TemplateButton("Cancel");
            buttonsHolder.add(mainMenuButton);
        }

        createRoomButton = new TemplateButton("Create");
        buttonsHolder.add(createRoomButton);
        contentHolder.add(buttonsHolder, BorderLayout.SOUTH);
    }

    /**
     * Adds a listener to the Cancel button.
     * @param listener the set of actions to be done when the button is clicked
     */
    public void addMainMenuButtonListener(ActionListener listener) {
        if (mainMenuButton != null) {
            mainMenuButton.addActionListener(listener);
        }
    }

    /**
     * Adds a listener to the Create Room button.
     * @param listener the set of actions to be done when the button is clicked
     */
    public void addCreateRoomButtonListener(ActionListener listener) {
        createRoomButton.addActionListener(listener);
    }

    /**
     * Returns the current content in roomFloorField
     * @return the string currently inside roomFloorField
     */
    public String getRoomFloor() {
        return roomFloorField.getText();
    }

    /**
     * Returns the current content in roomNumberField
     * @return the number currently inside roomNumberField
     */
    public String getRoomNumber() {
        return roomNumberField.getText();
    }

    /**
     * Returns the current content in roomTypeField
     * @return the string currently inside roomTypeField
     */
    public String getRoomType() {
        return roomTypeField.getItemAt(roomTypeField.getSelectedIndex());
    }

    /**
     * Resets the input fields after a failed attempt.
     */
    public void resetInputFields() {
        roomFloorField.setText("");
        roomNumberField.setText("");
        roomTypeField.setSelectedIndex(0);
    }
}
