package mainMenu;

import shared.AbstractView;
import shared.TemplateButton;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.io.IOException;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;

/**
 * The View of Main Menu.
 * @author Angela Domingo
 */
public class MainMenuView extends AbstractView {

    private JPanel rightSide;

    private Image bgImage;
    private JButton createHotelButton;
    private JButton viewHotelButton;
    private JButton manageHotelButton;
    private JButton createReservationButton;
    private JButton exitButton;

    private ImageIcon hotelImage;
    private JLabel hotelLabel;

    private ImageIcon logoImage;
    private JLabel logoLabel;

    public MainMenuView(){
        super(null);

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

        // hotel image
        hotelImage = new ImageIcon(this.getClass().getResource("/assets/HOTEL_GRAPHIC.png"));
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

        rightSide = new JPanel();
        rightSide.setOpaque(false);

        // app name image
        logoImage = new ImageIcon(this.getClass().getResource("/assets/LABELS/MAIN_MENU.png"));
        logoLabel = new JLabel(logoImage) {
            @Override
            protected void paintComponent(Graphics g) {
                Image image = logoImage.getImage();
                int panelWidth = getWidth();
                int panelHeight = getHeight();
                int imageWidth = image.getWidth(rightSide);
                int imageHeight = image.getHeight(rightSide);
                double scalingFactor = 0.90;

                // Calculate the new dimensions of the image to maintain aspect ratio
                double aspectRatio = (double) imageHeight / imageWidth;
                int newHeight = (int) (panelHeight * scalingFactor);
                int newWidth = (int) (newHeight / aspectRatio);

                if (newWidth > panelWidth * scalingFactor) {
                    newWidth = (int) (panelWidth * scalingFactor);
                    newHeight = (int) (newWidth * aspectRatio);
                }

                // Center the image
                int x = (panelWidth - newWidth) / 2;
                int y = (panelHeight - newHeight);

                // Draw the scaled image
                g.drawImage(image, x, y, newWidth, newHeight, this);
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(rightSide.getWidth(), 250);  // Set a default size for layout purposes
            }
        };
        logoLabel.setVisible(true);
        rightSide.add(logoLabel);

        // buttons
        createHotelButton = new TemplateButton("Create Hotel");
        viewHotelButton = new TemplateButton("View Hotel");
        manageHotelButton = new TemplateButton("Manage Hotel");
        createReservationButton = new TemplateButton("Make Reservation");
        exitButton = new TemplateButton("Exit Program");
        JPanel buttonsHolder = new JPanel();
        buttonsHolder.setOpaque(false);
        buttonsHolder.setLayout(new BoxLayout(buttonsHolder, BoxLayout.Y_AXIS));
        buttonsHolder.add(createHotelButton);
        buttonsHolder.add(viewHotelButton);
        buttonsHolder.add(manageHotelButton);
        buttonsHolder.add(createReservationButton);
        buttonsHolder.add(exitButton);
        rightSide.add(Box.createVerticalStrut(450));
        rightSide.add(buttonsHolder);

        addWindowListener( new WindowAdapter()
        {
        });

        contentHolder.add(hotelLabel);
        contentHolder.add(rightSide);

    }

    /**
     * Adds a listener to the Create Hotel button.
     * @param listener the set of actions to be done when the button is clicked
     */
    public void addCreateHotelButtonListener(ActionListener listener) {createHotelButton.addActionListener(listener);}

    /**
     * Adds a listener to the View Hotel button.
     * @param listener the set of actions to be done when the button is clicked
     */
    public void addViewHotelButtonListener(ActionListener listener) { viewHotelButton.addActionListener(listener); }

    /**
     * Adds a listener to the Manage Hotel button.
     * @param listener the set of actions to be done when the button is clicked
     */
    public void addManageHotelButtonListener(ActionListener listener) {manageHotelButton.addActionListener(listener);}

    /**
     * Adds a listener to the Create Reservation button.
     * @param listener the set of actions to be done when the button is clicked
     */
    public void addCreateReservationButtonListener(ActionListener listener) {createReservationButton.addActionListener(listener);}

    /**
     * Adds a listener to the Exit Button button.
     * @param listener the set of actions to be done when the button is clicked
     */
    public void addExitButtonListener(ActionListener listener) {exitButton.addActionListener(listener);}


}