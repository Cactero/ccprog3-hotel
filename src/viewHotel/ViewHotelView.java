package viewHotel;

import Model.Hotel;
import main.AbstractView;
import shared.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The View of Create Room.
 * @author Angela Domingo
 */
public class ViewHotelView extends AbstractView {

    private JPanel buttonsHolder;
    private JButton mainMenuButton;
    private JButton highLevelButton;
    private JButton lowLevelOptionsButton;

    public ViewHotelView(){
        super("/assets/LABELS/VIEW_HOTEL.png");

        // cancel hotel creation and create hotel buttons
        buttonsHolder = new JPanel();
        buttonsHolder.setOpaque(false);

        highLevelButton = new TemplateButton("Show High Level");
        lowLevelOptionsButton = new TemplateButton("Show Low Level");
        mainMenuButton = new TemplateButton("Exit");

        buttonsHolder.add(highLevelButton);
        buttonsHolder.add(lowLevelOptionsButton);
        buttonsHolder.add(mainMenuButton);
        contentHolder.add(buttonsHolder, BorderLayout.SOUTH);

    }

    public void addHighLevelButtonListener(ActionListener listener) { highLevelButton.addActionListener(listener); }
    public void addLowLevelButtonListener(ActionListener listener) { lowLevelOptionsButton.addActionListener(listener); }
    public void addMainMenuButtonListener(ActionListener listener) { mainMenuButton.addActionListener(listener); }
}
