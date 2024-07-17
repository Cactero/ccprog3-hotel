package enterHotelName;

import shared.Button;
import shared.HeaderLabel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

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

        setTitle("CCPROG3 MCO: Hotel Reservation System (S27 Group 4)");
        contentHolder.add(buttonsHolder, BorderLayout.SOUTH);
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
    public void addCreateHotelButtonListener(ActionListener listener) { createHotelButton.addActionListener(listener); }
    public String getHotelName() { return hotelNameField.getText(); }
    public void resetInputFields(){ hotelNameField.setText("");}
}
