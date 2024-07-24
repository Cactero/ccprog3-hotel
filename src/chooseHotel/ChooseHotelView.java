package chooseHotel;

import Model.Hotel;
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

/**
 * The View for Choose Hotel
 * @author Angela Domingo
 */
public class ChooseHotelView extends JFrame {

    private JPanel contentHolder;
    private Image bgImage;

    private JPanel headerHolder;
    private JLabel headerLabel;
    private ImageIcon headerImage;

    private JPanel inputHolder;
    private JComboBox hotelListField;

    private JPanel buttonsHolder;
    private JButton mainMenuButton;
    private JButton chooseHotelButton;

    /*
    public ChooseHotelView(ArrayList<Hotel> hotels){
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

    public ChooseHotelView(ArrayList<Hotel> hotels){
        JPanel chooseHotelPanel = new JPanel();

        chooseHotelPanel.add(new JLabel("Choose hotel:"));

        ArrayList<String> hotelNames = new ArrayList<String>();

        for(Hotel hotel : hotels){
            hotelNames.add(hotel.getName());
        }
        hotelListField = new JComboBox<>(hotelNames.toArray());
        chooseHotelPanel.add(hotelListField);

        setContentPane(chooseHotelPanel);

        addWindowListener( new WindowAdapter()
        {
            public void windowResized(WindowEvent evt)
            {
                // add img elements here
            }
        });

        int result = JOptionPane.showConfirmDialog(null, chooseHotelPanel,
                "Make a new room", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            //System.out.println("Floor: " + roomFloorField.getText());
            //System.out.println("Number: " + roomNumberField.getText());
            //System.out.println("Type: ", (String) roomTypeField.getItemAt(roomTypeField.getSelectedIndex()));
        }

        //setTitle("CCPROG3 MCO: Hotel Reservation System (S27 Group 5)");
    }
    /**
     * Adds a listener to the Main Menu button.
     * @param listener the set of actions to be done when the button is clicked
     */
    public void addMainMenuButtonListener(ActionListener listener) { mainMenuButton.addActionListener(listener); }

    /**
     * Adds a listener to the Choose Hotel button.
     * @param listener the set of actions to be done when the button is clicked
     */
    public void addChooseHotelButtonListener(ActionListener listener) { chooseHotelButton.addActionListener(listener); }

    /**
     * Returns the content currently selected inside Hotel List Field.
     * @return the name of the current item shown in Hotel List Field
     */
    public String getHotelName() { return (String) hotelListField.getItemAt(hotelListField.getSelectedIndex()); }
}
