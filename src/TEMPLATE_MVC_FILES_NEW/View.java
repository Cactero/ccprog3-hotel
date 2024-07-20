package TEMPLATE_MVC_FILES_NEW;

import shared.Button;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

// extends jpanel para pwede natin ipasa pasa yung content sa loob without the window closing and reopening ulit
public class View extends JPanel {
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
        mainMenuButton.setActionCommand("MainMenu");
        buttonsHolder.add(mainMenuButton);
        contentHolder.add(buttonsHolder, BorderLayout.SOUTH);

    }

    public JPanel getContentHolder(){
        return this.contentHolder;
    }
    // required so that buttons can actually work and have results after clicking, add more according to how many buttons are needed
    public void addMainMenuButtonListener(Runnable action) {
        mainMenuButton.addActionListener(e -> action.run());
    }


    //if input fields are required, add getters here, refer to this link for user input options: https://web.mit.edu/6.005/www/sp14/psets/ps4/java-6-tutorial/components.html
    // ex. public void getHotelName(){ return newhotelname.getText(); }
}
