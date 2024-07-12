package mainMenu;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

public class MainMenuView extends JFrame{

    private JPanel contentHolder;
    private JPanel rightSide;

    private Image bgImage;
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
            contentHolder = new JPanel(new GridLayout(0, 2)) {
                @Override public void paintComponent(Graphics g) {
                    g.drawImage(bgImage, 0, 0, this.getWidth(), this.getHeight(), this);
                }
            };
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        rightSide = new JPanel();
        rightSide.setOpaque(false);

        // hotel image
        hotelImage = new ImageIcon(this.getClass().getResource("/assets/MainMenu/HOTEL_GRAPHIC.png"));
        hotelLabel = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image image = hotelImage.getImage();
                int panelWidth = getWidth();
                int panelHeight = getHeight();
                int imageWidth = image.getWidth(null);
                int imageHeight = image.getHeight(null);
                double scalingFactor = 0.87;

                // Calculate the new dimensions of the image to maintain aspect ratio
                double aspectRatio = (double) imageWidth / imageHeight;
                int newWidth = (int) (panelWidth * scalingFactor);
                int newHeight = (int) (newWidth / aspectRatio);

                if (newHeight > panelHeight * scalingFactor) {
                    newHeight = (int) (panelHeight * scalingFactor);
                    newWidth = (int) (newHeight * aspectRatio);
                }

                // Center the image
                int x = (panelWidth - newWidth) / 2;
                int y = (panelHeight - newHeight);

                // Draw the scaled image
                g.drawImage(image, x, y, newWidth, newHeight, this);
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(800, 600);  // Set a default size for layout purposes
            }
        };
        hotelLabel.setVerticalAlignment(JLabel.BOTTOM);
        hotelLabel.setVisible(true);
        hotelLabel.setOpaque(false);

        // app name image
        logoImage = new ImageIcon(this.getClass().getResource("/assets/MainMenu/HOTEL_NAME.png"));
        logoLabel = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image image = logoImage.getImage();
                int panelWidth = getWidth();
                int panelHeight = getHeight();
                int imageWidth = image.getWidth(null);
                int imageHeight = image.getHeight(null);
                double scalingFactor = 0.80;

                // Calculate the new dimensions of the image to maintain aspect ratio
                double aspectRatio = (double) imageWidth / imageHeight;
                int newWidth = (int) (panelWidth * scalingFactor);
                int newHeight = (int) (newWidth / aspectRatio);

                if (newHeight > panelHeight * scalingFactor) {
                    newHeight = (int) (panelHeight * scalingFactor);
                    newWidth = (int) (newHeight * aspectRatio);
                }

                // Center the image
                int x = (panelWidth - newWidth) / 2;
                int y = (panelHeight - newHeight);

                // Draw the scaled image
                g.drawImage(image, x, y, newWidth, newHeight, this);
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(800, 600);  // Set a default size for layout purposes
            }
        };
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
        setLayout(new GridLayout());
        contentHolder.add(hotelLabel);
        contentHolder.add(rightSide);
        setContentPane(contentHolder);
        addWindowListener( new WindowAdapter()
        {
            public void windowResized(WindowEvent evt)
            {
                hotelLabel.repaint();
                logoLabel.repaint();
            }
        });
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        hotelLabel.repaint();
        logoLabel.repaint();

    }

    public void addCreateHotelButtonListener(ActionListener listener) {createHotelButton.addActionListener(listener);}


}