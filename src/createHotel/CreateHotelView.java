package createHotel;

import mainMenu.Button;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class CreateHotelView extends JFrame {

    private JPanel contentHolder;
    private Image bgImage;

    private JTextField hotelNameInput;

    private JPanel buttonsHolder;
    private JButton mainMenuButton;
    private JButton createHotelButton;

    public CreateHotelView(){
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

        // text field for hotel name input
        hotelNameInput = new JTextField("Enter hotel name...");
        hotelNameInput.setOpaque(false);

        // cancel hotel creation and create hotel buttons
        buttonsHolder = new JPanel();
        buttonsHolder.setOpaque(false);
        mainMenuButton = new Button("Cancel");
        createHotelButton = new Button("Create");
        buttonsHolder.add(mainMenuButton);
        buttonsHolder.add(createHotelButton);

        setTitle("CCPROG3 MCO: Hotel Reservation System (S27 Group 4)");
        contentHolder.add(hotelNameInput, BorderLayout.CENTER);
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
    public String getHotelNameInput() { return hotelNameInput.getText(); }

}
