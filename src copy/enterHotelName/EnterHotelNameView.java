package enterHotelName;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The View for Enter Hotel Name.
 * @author Angela Domingo
 */
public class EnterHotelNameView extends JFrame {

    private JPanel contentHolder;
    private Image bgImage;

    private JPanel headerHolder;
    private JLabel headerLabel;
    private ImageIcon headerImage;

    private JPanel inputHolder;
    private JTextField hotelNameField;

    private JPanel buttonsHolder;
    private JButton mainMenuButton;
    private JButton createHotelButton;

    /*
    public EnterHotelNameView(){
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
        headerImage = new ImageIcon(this.getClass().getResource("/assets/ENTER_HOTEL_NAME.png"));
        headerLabel = new HeaderLabel(headerImage, headerHolder);
        headerHolder.add(headerLabel);
        contentHolder.add(headerHolder, BorderLayout.NORTH);

        // text field for hotel name input
        inputHolder = new JPanel();
        inputHolder.setOpaque(false);
        hotelNameField = new JTextField(25);
        hotelNameField.setOpaque(false);
        inputHolder.add(hotelNameField);
        contentHolder.add(inputHolder);

        // cancel hotel creation and create hotel buttons
        buttonsHolder = new JPanel();
        buttonsHolder.setOpaque(false);
        mainMenuButton = new Button("Cancel");
        createHotelButton = new Button("Create");
        buttonsHolder.add(mainMenuButton);
        buttonsHolder.add(createHotelButton);

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

    /**
     * Adds a listener to the Main Menu button.
     * @param listener the set of actions to be done when the button is clicked
     */
    public void addMainMenuButtonListener(ActionListener listener) { mainMenuButton.addActionListener(listener); }

    /**
     * Adds a listener to the Create Hotel button.
     * @param listener the set of actions to be done when the button is clicked
     */
    public void addCreateHotelButtonListener(ActionListener listener) { createHotelButton.addActionListener(listener); }

    /**
     * Returns the current content inside hotelNameField.
     * @return the String currently inside hotelNameField
     */
    public String getHotelName() {
        String hotelName = JOptionPane.showInputDialog("Enter your hotel name:");
        JOptionPane.showMessageDialog(null, "Hotel " + hotelName + " made!");
        return hotelName;
    }

    /**
     * Resets the input fields after a failed attempt.
     */
    public void resetInputFields(){ hotelNameField.setText("");}
}
