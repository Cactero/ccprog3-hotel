package viewHotel;

import app.Hotel;
import shared.HeaderLabel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The View of Create Room.
 * @author Angela Domingo
 */
public class ViewHotelView extends JFrame{

    private JPanel contentHolder;
    private Image bgImage;

    private JPanel headerHolder;
    private JLabel headerLabel;
    private ImageIcon headerImage;

    private JPanel roomInfoHolder;
    private JTextField roomFloorField;
    private JTextField roomNumberField;
    private JComboBox roomTypeField;

    private JPanel buttonsHolder;
    private JButton mainMenuButton;
    private JButton createRoomButton;

    /*
    public ViewHotelView(){
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

        headerHolder = new JPanel();
        headerHolder.setOpaque(false);
        headerImage = new ImageIcon(this.getClass().getResource("/assets/CHOOSE_HOTEL_NAME.png"));
        headerLabel = new HeaderLabel(headerImage, headerHolder);
        headerHolder.add(headerLabel);
        contentHolder.add(headerHolder, BorderLayout.NORTH);

        inputHolder = new JPanel();
        inputHolder.setOpaque(false);
        ArrayList<String> hotelNames = new ArrayList<>();
        for (Hotel hotel : hotels){
            hotelNames.add(hotel.getName());
        }
        hotelListField = new JComboBox<>(hotelNames.toArray());
        inputHolder.add(hotelListField);
        contentHolder.add(inputHolder);

        // cancel hotel creation and create hotel buttons
        buttonsHolder = new JPanel();
        buttonsHolder.setOpaque(false);
        mainMenuButton = new Button("Cancel");
        chooseHotelButton = new Button("Choose");
        buttonsHolder.add(mainMenuButton);
        buttonsHolder.add(chooseHotelButton);

        setTitle("CCPROG3 MCO: Hotel Reservation System (S27 Group 5)");
        contentHolder.add(buttonsHolder, BorderLayout.SOUTH);
        setContentPane(contentHolder);
        addWindowListener( new WindowAdapter()
        {
            public void windowResized(WindowEvent evt)
            {
                // add img elements here
            }
        });
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }

     */

    public void promptUser(){

    }

    /**
     * Returns the current content in roomFloorField
     * @return the string currently inside roomFloorField
     */
    public String getRoomFloor() {return roomFloorField.getText();}

    /**
     * Returns the current content in roomNumberField
     * @return the number currently inside roomNumberField
     */
    public String getRoomNumber() {return roomNumberField.getText();}

    /**
     * Returns the current content in roomTypeField
     * @return the string currently inside roomTypeField
     */
    public String getRoomType() {return (String) roomTypeField.getItemAt(roomTypeField.getSelectedIndex());}

    /**
     * Resets the input fields after a failed attempt.
     */
    public void resetInputFields() {
        roomFloorField.setText("");
        roomNumberField.setText("");
        roomTypeField.setSelectedIndex(0);
    }
}
