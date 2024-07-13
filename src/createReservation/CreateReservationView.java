package createReservation;

import mainMenu.Button;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class CreateReservationView extends JFrame {
    private JPanel contentHolder;
    private Image bgImage;

    private JPanel buttonsHolder;
    private JButton manageHotelButton;
    private JButton createClientButton;

    public CreateReservationView(){
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

        // cancel room creation and create room buttons
        buttonsHolder = new JPanel();
        buttonsHolder.setOpaque(false);
        manageHotelButton = new mainMenu.Button("Cancel");
        buttonsHolder.add(manageHotelButton);
        createClientButton = new Button("Create");
        buttonsHolder.add(createClientButton);
        contentHolder.add(buttonsHolder, BorderLayout.SOUTH);

        setTitle("CCPROG3 MCO: Hotel Reservation System (S27 Group 4)");
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

    public void addManageHotelButtonListener(ActionListener listener) { manageHotelButton.addActionListener(listener); }
    public void addCreateClientButtonListener(ActionListener listener) { createClientButton.addActionListener(listener); }
}
