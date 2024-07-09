package mainMenu;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
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
    
    public MainMenuView(){

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

        leftSide = new JPanel();
        leftSide.setOpaque(false);
        rightSide = new JPanel(new BorderLayout());
        rightSide.setOpaque(false);

        // hotel image
        hotelImage = new ImageIcon(this.getClass().getResource("/assets/MainMenu/HOTEL_GRAPHIC.png"));
        hotelLabel = new JLabel("", hotelImage, JLabel.LEFT);
        hotelLabel.setVisible(true);
        hotelLabel.setOpaque(false);
        leftSide.add(hotelLabel, BorderLayout.CENTER);

        // app name image
        logoImage = new ImageIcon(this.getClass().getResource("/assets/MainMenu/HOTEL_NAME.png"));
        logoLabel = new JLabel("", logoImage, JLabel.RIGHT);
        logoLabel.setVisible(true);
        logoLabel.setOpaque(false);
        rightSide.add(logoLabel);

        // buttons
        buttonImage = new ImageIcon(this.getClass().getResource("/assets/MainMenu/BUTTON.png"));
        createHotelButton = new Button();
        manageHotelButton = new Button();
        createReservationButton = new Button();
        rightSide.add(createHotelButton, BorderLayout.CENTER);
        rightSide.add(manageHotelButton, BorderLayout.CENTER);
        rightSide.add(createReservationButton, BorderLayout.CENTER);
        
        
        setTitle("CCPROG3 MCO: Hotel Reservation System (S27 Group 4)");
        contentHolder.add(leftSide, BorderLayout.WEST);
        contentHolder.add(rightSide, BorderLayout.EAST);
        setContentPane(contentHolder);
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);


    }

    public void addCreateHotelButtonListener(ActionListener listener) {createHotelButton.addActionListener(listener);}


    public static void main(String[] args) {
        new MainMenuView();
    }
}