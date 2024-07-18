package manageHotel;

import shared.Button;
import shared.HeaderLabel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

/**
 *
 */
public class ManageHotelView extends JFrame {

    private JPanel contentHolder;
    private Image bgImage;

    private JPanel headerHolder;
    private JLabel headerLabel;
    private ImageIcon headerImage;

    private JPanel optionsHolder;
    private JButton changeHotelName;
    private JButton addRooms;
    private JButton removeRooms;
    private JButton updateBasePrice;
    private JButton removeReservation;
    private JButton removeHotel;
    private JButton changeRoomType;

    private JPanel buttonsHolder;
    private JButton mainMenuButton;

    public ManageHotelView(){
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
        headerImage = new ImageIcon(this.getClass().getResource("/assets/MANAGE_HOTEL_NAME.png"));
        headerLabel = new HeaderLabel(headerImage, headerHolder);
        headerHolder.add(headerLabel, BorderLayout.CENTER);
        contentHolder.add(headerHolder, BorderLayout.NORTH);

        optionsHolder = new JPanel();
        optionsHolder.setOpaque(false);
        changeHotelName = new Button("Change Hotel Name");
        addRooms = new Button("Add Rooms");
        removeRooms = new Button("Remove Rooms");
        updateBasePrice = new Button("Update Base Price");
        removeReservation = new Button("Remove Reservation");
        removeHotel = new Button("Remove Hotel");
        changeRoomType = new Button("Change Room Type");
        optionsHolder.add(changeHotelName);
        optionsHolder.add(addRooms);
        optionsHolder.add(removeRooms);
        optionsHolder.add(updateBasePrice);
        optionsHolder.add(removeReservation);
        optionsHolder.add(removeHotel);
        optionsHolder.add(changeRoomType);
        contentHolder.add(optionsHolder);


        // cancel room creation and create room buttons
        buttonsHolder = new JPanel();
        buttonsHolder.setOpaque(false);
        mainMenuButton = new Button("Cancel");
        buttonsHolder.add(mainMenuButton);
        contentHolder.add(buttonsHolder, BorderLayout.SOUTH);

        setTitle("CCPROG3 MCO: Hotel Reservation System (S27 Group 5)");
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

    public void addAddRoomsButtonListener(ActionListener listener) { addRooms.addActionListener(listener); }
    public void addRemoveRoomsButtonListener(ActionListener listener) { removeRooms.addActionListener(listener); }
    public void addChangeHotelNameButtonListener(ActionListener listener) { changeHotelName.addActionListener(listener); }
    public void addUpdateBasePriceButtonListener(ActionListener listener) { updateBasePrice.addActionListener(listener); }
    public void addRemoveReservationButtonListener(ActionListener listener) { removeReservation.addActionListener(listener); }
    public void addRemoveHotelButtonListener(ActionListener listener) { removeReservation.addActionListener(listener); }
    public void addChangeRoomTypeButtonListener(ActionListener listener) { changeRoomType.addActionListener(listener); }
    public void addMainMenuButtonListener(ActionListener listener) { mainMenuButton.addActionListener(listener); }
}
