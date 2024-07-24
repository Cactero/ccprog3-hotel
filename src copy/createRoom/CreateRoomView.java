package createRoom;

import main.AbstractView;
import shared.TemplateButton;
import shared.TemplateHeaderLabel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * The View of Create Room.
 * @author Angela Domingo
 */
public class CreateRoomView extends AbstractView {

    private Image bgImage;

    private JPanel headerHolder;
    private JLabel headerLabel;
    private ImageIcon headerImage;

    private JPanel roomInfoHolder;
    private JTextField roomFloorField;
    private JTextField roomNumberField;
    private JComboBox<String> roomTypeField;

    private JPanel buttonsHolder;
    private JButton mainMenuButton;
    private JButton createRoomButton;

    public CreateRoomView(boolean fromCreateHotel) {
        // background image
        try {
            bgImage = ImageIO.read(this.getClass().getResource("/assets/WINDOW_BACKGROUND.png"));
            contentHolder = new JPanel(new BorderLayout()) {
                @Override
                public void paintComponent(Graphics g) {
                    g.drawImage(bgImage, 0, 0, this.getWidth(), this.getHeight(), this);
                }
            };
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // app name image
        headerHolder = new JPanel();
        headerHolder.setOpaque(false);
        headerImage = new ImageIcon(this.getClass().getResource("/assets/CREATE_ROOM.png"));
        headerLabel = new TemplateHeaderLabel(headerImage, headerHolder);
        headerHolder.add(headerLabel);
        contentHolder.add(headerHolder, BorderLayout.NORTH);

        roomInfoHolder = new JPanel(new FlowLayout());
        roomInfoHolder.setOpaque(false);
        roomFloorField = new JTextField(10);
        roomNumberField = new JTextField(10);
        String[] roomTypes = new String[]{"Standard", "Deluxe", "Executive"};
        roomTypeField = new JComboBox<>(roomTypes);

        roomInfoHolder.add(roomFloorField);
        roomInfoHolder.add(roomNumberField);
        roomInfoHolder.add(roomTypeField);
        contentHolder.add(roomInfoHolder, BorderLayout.CENTER);

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

    public void addMainMenuButtonListener(ActionListener listener) {
        if (mainMenuButton != null) {
            mainMenuButton.addActionListener(listener);
        }
    }

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
        return (String) roomTypeField.getItemAt(roomTypeField.getSelectedIndex());
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
