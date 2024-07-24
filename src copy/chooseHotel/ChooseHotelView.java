package chooseHotel;

import Model.Hotel;
import main.AbstractView;
import shared.TemplateHeaderLabel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The View for Choose Hotel
 * @author Angela Domingo
 */
public class ChooseHotelView extends AbstractView {

    private Image bgImage;

    private JPanel headerHolder;
    private JLabel headerLabel;
    private ImageIcon headerImage;

    private String selectedHotelName;

    private JPanel inputHolder;
    private JComboBox hotelListField;

    private JPanel buttonsHolder;
    private JButton mainMenuButton;
    private JButton chooseHotelButton;

    public ChooseHotelView(){
        super("/assets/CHOOSE_HOTEL_NAME.png");

//        String[] hotelNames = hotels.stream()
//        .map(Hotel::getName)
//        .toArray(String[]::new);
//
//        selectedHotelName = (String) JOptionPane.showInputDialog(null, "Select a hotel", "Choose Hotel", JOptionPane.PLAIN_MESSAGE, null, hotelNames, hotelNames[0]);

//        inputHolder = new JPanel();
//        inputHolder.setOpaque(false);
//
//        String[] hotelNames = hotels.stream()
//                .map(Hotel::getName)
//                .toArray(String[]::new);
//
//        hotelListField = new JComboBox<>(hotelNames);
//        inputHolder.add(hotelListField);
//        contentHolder.add(inputHolder);

//        // cancel hotel creation and create hotel buttons
//        buttonsHolder = new JPanel();
//        buttonsHolder.setOpaque(false);
//        mainMenuButton = new Button("Cancel");
//        chooseHotelButton = new Button("Choose");
//        buttonsHolder.add(mainMenuButton);
//        buttonsHolder.add(chooseHotelButton);
//
//        setTitle("CCPROG3 MCO: Hotel Reservation System (S27 Group 5)");
//        contentHolder.add(buttonsHolder, BorderLayout.SOUTH);
//        setContentPane(contentHolder);
//        addWindowListener( new WindowAdapter()
//        {
//            public void windowResized(WindowEvent evt)
//            {
//                // add img elements here
//            }
//        });
//        setSize(600, 300);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//        setVisible(true);

    }

//    public ChooseHotelView(ArrayList<Hotel> hotels){
//        JPanel chooseHotelPanel = new JPanel();
//
//        chooseHotelPanel.add(new JLabel("Choose hotel:"));
//
//        ArrayList<String> hotelNames = new ArrayList<String>();
//
//        for(Hotel hotel : hotels){
//            hotelNames.add(hotel.getName());
//        }
//        hotelListField = new JComboBox<>(hotelNames.toArray());
//        chooseHotelPanel.add(hotelListField);
//
//        setContentPane(chooseHotelPanel);
//
//        addWindowListener( new WindowAdapter()
//        {
//            public void windowResized(WindowEvent evt)
//            {
//                // add img elements here
//            }
//        });
//
//        int result = JOptionPane.showConfirmDialog(null, chooseHotelPanel,
//                "Make a new room", JOptionPane.OK_CANCEL_OPTION);
//        if (result == JOptionPane.OK_OPTION) {
//            //System.out.println("Floor: " + roomFloorField.getText());
//            //System.out.println("Number: " + roomNumberField.getText());
//            //System.out.println("Type: ", (String) roomTypeField.getItemAt(roomTypeField.getSelectedIndex()));
//        }
//
//        //setTitle("CCPROG3 MCO: Hotel Reservation System (S27 Group 5)");
//    }

    /**
     * Returns the content currently selected inside the JOptionPane.showInputDialog.
     * @return the name of the current item shown in JOptionPane.showInputDialog
     */
    public String getHotelName() { return selectedHotelName; }
}
