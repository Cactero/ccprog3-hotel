package viewHotel;

import main.AbstractView;
import shared.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * The View of Create Room.
 * @author Angela Domingo
 */
public class ViewHotelView extends AbstractView {

    private Image bgImage;

    private JPanel headerHolder;
    private JLabel headerLabel;
    private ImageIcon headerImage;

    private JPanel centerHolder;
    private JLabel textDisplay;

    private JPanel buttonsHolder;
    private JButton mainMenuButton;
    private JButton lowLevelOptionsButton;


    public ViewHotelView(){
        super("/assets/CHOOSE_HOTEL_NAME.png");

        // cancel hotel creation and create hotel buttons
        buttonsHolder = new JPanel();
        buttonsHolder.setOpaque(false);
        mainMenuButton = new TemplateButton("Exit");
        lowLevelOptionsButton = new TemplateButton("Show Low Level");
        buttonsHolder.add(mainMenuButton);
        buttonsHolder.add(lowLevelOptionsButton);
        contentHolder.add(buttonsHolder, BorderLayout.SOUTH);

    }

    public void addLowLevelButtonListener(ActionListener listener) { lowLevelOptionsButton.addActionListener(listener); }
    public void addMainMenuButtonListener(ActionListener listener) { mainMenuButton.addActionListener(listener); }
}
