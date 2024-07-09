package mainMenu;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.IOException;

public class MainMenuView extends JFrame{

    private JPanel contentHolder;
    private JPanel leftSide;
    private JPanel rightSide;

    private Image bgImage;
    private JLabel bgLabel;

    private ImageIcon buttonImage;
    private JButton createHotelButton;
    private JButton manageHotelButton;
    private JButton createReservationButton;

    private ImageIcon hotelImage;
    private JLabel hotelLabel;

    private ImageIcon logoImage;
    private JLabel logoLabel;
    private JPanel hello;
    private JButton button1;
    private JButton button2;
    private JButton button3;

    public MainMenuView(){

        // background image
        try {
            bgImage = ImageIO.read(this.getClass().getResource("/assets/WINDOW_BACKGROUND.png"));
            contentHolder = new JPanel(new GridLayout(0, 2)) {
                @Override public void paintComponent(Graphics g) {
                    g.drawImage(bgImage, 0, 0, this.getWidth(), this.getHeight(), this);
                }
            };
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        rightSide = new JPanel(new GridLayout(4, 0));
        rightSide.setOpaque(false);

        // hotel image
        hotelImage = new ImageIcon(new ImageIcon(this.getClass().getResource("/assets/MainMenu/HOTEL_GRAPHIC.png")).getImage().getScaledInstance((int) (452), (int) (971), Image.SCALE_DEFAULT));
        hotelLabel = new JLabel(hotelImage);
        hotelLabel.setVerticalAlignment(JLabel.BOTTOM);
        hotelLabel.setVisible(true);
        hotelLabel.setOpaque(false);

        // app name image
        logoImage = new ImageIcon(this.getClass().getResource("/assets/MainMenu/HOTEL_NAME.png"));
        logoLabel = new JLabel(logoImage);
        logoLabel.setVisible(true);
        rightSide.add(logoLabel);

        // buttons
        createHotelButton = new Button("Create Hotel");
        manageHotelButton = new Button("Manage Hotel");
        createReservationButton = new Button("Make Reservation");
        rightSide.add(createHotelButton);
        rightSide.add(manageHotelButton);
        rightSide.add(createReservationButton);


        setTitle("CCPROG3 MCO: Hotel Reservation System (S27 Group 4)");
        contentHolder.add(hotelLabel);
        contentHolder.add(rightSide);
        setContentPane(contentHolder);
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);


    }

    public void addCreateHotelButtonListener(ActionListener listener) {createHotelButton.addActionListener(listener);}


}