package createRoom;

import app.Room;
import mainMenu.Button;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class CreateRoomView extends JFrame{

    private JPanel contentHolder;
    private Image bgImage;

    private JPanel roomInfoHolder;
    private JTextField roomFloorField;
    private JTextField roomNumberField;
    private JComboBox roomTypeField;

    private JPanel buttonsHolder;
    private JButton mainMenuButton;
    private JButton createRoomButton;

    public CreateRoomView(boolean fromCreateHotel){
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

        roomInfoHolder = new JPanel(new FlowLayout());
        roomFloorField = new JTextField(10);
        roomNumberField = new JTextField(10);
        String[] roomTypes = new String[] {"Standard", "Deluxe", "Executive"};
        roomTypeField = new JComboBox(roomTypes);
        roomInfoHolder.add(roomFloorField);
        roomInfoHolder.add(roomNumberField);
        roomInfoHolder.add(roomTypeField);
        contentHolder.add(roomInfoHolder, BorderLayout.CENTER);

        // cancel room creation and create room buttons
        buttonsHolder = new JPanel();
        buttonsHolder.setOpaque(false);
        mainMenuButton = new Button("Cancel");
        if (!fromCreateHotel){
            buttonsHolder.add(mainMenuButton);
        }
        createRoomButton = new Button("Create");
        buttonsHolder.add(createRoomButton);
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
    public void addCreateRoomButtonListener (ActionListener listener) {createRoomButton.addActionListener(listener);}
    public void addMainMenuButtonListener (ActionListener listener) {mainMenuButton.addActionListener(listener);}
    public String getRoomFloor() {return roomFloorField.getText();}
    public String getRoomNumber() {return roomNumberField.getText();}
    public String getRoomType() {return (String) roomTypeField.getItemAt(roomTypeField.getSelectedIndex());}
    public void resetInputFields() {
        roomFloorField.setText("");
        roomNumberField.setText("");
        roomTypeField.setSelectedIndex(0);
    }
}