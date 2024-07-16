package createReservation;

import app.Hotel;
import app.Room;
import shared.Button;
import shared.HeaderLabel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;

public class CreateReservationView extends JFrame {
    private JPanel contentHolder;
    private Image bgImage;

    private JPanel headerHolder;
    private JLabel headerLabel;
    private ImageIcon headerImage;

    private JPanel inputHolder;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JSpinner checkInDayField;
    private JSpinner checkOutDayField;
    private JComboBox roomListField;
    private JTextField discountField;

    private JPanel buttonsHolder;
    private JButton mainMenuButton;
    private JButton createClientButton;

    public CreateReservationView(Hotel selectedHotel){
        // background image
        try {
            bgImage = ImageIO.read(this.getClass().getResource("/assets/WINDOW_BACKGROUND.png"));
            contentHolder = new JPanel(new BorderLayout()) {
                @Override public void paintComponent(Graphics g) {
                    g.drawImage(bgImage, 0, 0, this.getWidth(), this.getHeight(), this);
                }
            };
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // app name image
        headerHolder = new JPanel();
        headerHolder.setOpaque(false);
        headerImage = new ImageIcon(this.getClass().getResource("/assets/CreateReservation/CREATE_RESERVATION_NAME.png"));
        headerLabel = new HeaderLabel(headerImage);
        headerHolder.add(headerLabel);
        contentHolder.add(headerHolder, BorderLayout.NORTH);

        inputHolder = new JPanel();
        inputHolder.setOpaque(false);
        firstNameField = new JTextField(10);
        lastNameField = new JTextField(10);
        SpinnerNumberModel checkInDayOptions = new SpinnerNumberModel(1, 1, 30, 1);
        checkInDayField = new JSpinner(checkInDayOptions);
        SpinnerNumberModel checkOutDayOptions = new SpinnerNumberModel(2, 2, 31, 1);
        checkOutDayField = new JSpinner(checkOutDayOptions);
        ArrayList<String> roomNames = new ArrayList<>();
        for (Room room : selectedHotel.getRooms()){
            if (room != null)
                roomNames.add(room.getRoomFloor() + room.getRoomNumber());
        }
        roomListField = new JComboBox<>(roomNames.toArray());
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
        mainMenuButton = new Button("Cancel");
        buttonsHolder.add(mainMenuButton);
        createClientButton = new Button("Create");
        buttonsHolder.add(createClientButton);
        contentHolder.add(buttonsHolder, BorderLayout.SOUTH);

        setTitle("CCPROG3 MCO: Hotel Reservation System (S27 Group 4)");
        setContentPane(contentHolder);
        addWindowListener( new WindowAdapter()
        {
            public void windowResized(WindowEvent evt)
            {
                // add img elements here
            }
        });
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void addMainMenuButtonListener(ActionListener listener) { mainMenuButton.addActionListener(listener); }
    public String getFirstName() { return firstNameField.getText(); }
    public String getLastName() { return lastNameField.getText(); }
    public int getCheckInDay() { return (int) checkInDayField.getValue(); }
    public int getCheckOutDay() { return (int) checkOutDayField.getValue(); }
    public Room getSelectedRoom() { return (Room) roomListField.getSelectedItem(); }
    public void resetInputFields() {
        firstNameField.setText("");
        lastNameField.setText("");
        checkInDayField.setValue(1);
        checkOutDayField.setValue(2);
        roomListField.setSelectedIndex(0);
        discountField.setText("");
    }
    public void addCreateClientButtonListener(ActionListener listener) { createClientButton.addActionListener(listener); }
}
