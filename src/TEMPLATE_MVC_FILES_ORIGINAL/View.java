package TEMPLATE_MVC_FILES_ORIGINAL;

import shared.Button;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

// extends jframe since we're making this view the frame na mismo
public class View extends JFrame {
    private JPanel contentHolder;
    private Image bgImage;

    private JPanel buttonsHolder;
    private JButton mainMenuButton;

    public View(){

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

        /**
         *
         * INPUT FIELDS AND WHATNOT GO INSIDE HERE
         * ex. JTextField newhotelname = new JTextField(10);
         * JPanel container = new JPanel();
         * container.setOpaque(false); (required setopaque para kita background)
         * container.add(newhotelname); (add newhotelname into container)
         * contentHolder.add(container) (add container into frame content holder)
         *
         * all new variables to be set OUTSIDE the constructor so getters and action listeners can interact with them
         *
         * DO NOT DO add(); TO ADD THINGS INTO THE FRAME.
         *
         */


        // cancel and create buttons go here if ever
        buttonsHolder = new JPanel();
        buttonsHolder.setOpaque(false);
        mainMenuButton = new Button("Cancel");
        buttonsHolder.add(mainMenuButton);
        contentHolder.add(buttonsHolder, BorderLayout.SOUTH);

        setTitle("CCPROG3 MCO: Hotel Reservation System (S27 Group 4)");
        setContentPane(contentHolder);
        addWindowListener( new WindowAdapter()
        {
            public void windowResized(WindowEvent evt)
            {
                // add img elements here, sunny touches only
            }
        });
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    // required so that buttons can actually work and have results after clicking, add more according to how many buttons are needed
    public void addMainMenuButtonListener(ActionListener listener) {mainMenuButton.addActionListener(listener);}

    //if input fields are required, add getters here, refer to this link for user input options: https://web.mit.edu/6.005/www/sp14/psets/ps4/java-6-tutorial/components.html
    // ex. public void getHotelName(){ return newhotelname.getText(); }
}
