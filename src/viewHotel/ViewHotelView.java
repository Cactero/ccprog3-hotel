package viewHotel;

import Model.Hotel;
import shared.AbstractView;
import shared.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The View of Create Room.
 * @author Angela Domingo
 */
public class ViewHotelView extends AbstractView {

    private JPanel lowLevelOptionsHolder;
    private JPanel buttonsHolder;
    private JButton mainMenuButton;

    private JButton highLevelButton;
    private JButton lowLevelOptionsButton;

    private JButton viewDate;
    private JButton viewRoom;
    private JButton viewReservation;

    public ViewHotelView(){
        super("/assets/LABELS/VIEW_HOTEL.png");

        lowLevelOptionsHolder = new JPanel();
        lowLevelOptionsHolder.setOpaque(false);
        lowLevelOptionsHolder.setVisible(false);
        viewDate = new TemplateButton("View Date");
        viewRoom = new TemplateButton("View Room");
        viewReservation = new TemplateButton("View Reservation");
        lowLevelOptionsHolder.add(viewDate);
        lowLevelOptionsHolder.add(viewRoom);
        lowLevelOptionsHolder.add(viewReservation);

        // high level, low level, cancel buttons
        buttonsHolder = new JPanel();
        buttonsHolder.setOpaque(false);
        mainMenuButton = new TemplateButton("Exit");
        highLevelButton = new TemplateButton("Show High Level");
        lowLevelOptionsButton = new TemplateButton("Show Low Level");
        buttonsHolder.add(mainMenuButton);
        buttonsHolder.add(highLevelButton);
        buttonsHolder.add(lowLevelOptionsButton);

        contentHolder.add(lowLevelOptionsHolder, BorderLayout.CENTER);
        contentHolder.add(buttonsHolder, BorderLayout.SOUTH);

    }

    public void removeLowLevelOptions(){
        contentHolder.remove(lowLevelOptionsHolder);
        contentHolder.revalidate();
        contentHolder.repaint();
    }

    public void showLowLevelOptions(){
        contentHolder.add(lowLevelOptionsHolder, BorderLayout.CENTER);
        lowLevelOptionsHolder.setVisible(true);
        contentHolder.revalidate();
        contentHolder.repaint();
    }

    public void addHighLevelButtonListener(ActionListener listener) { highLevelButton.addActionListener(listener); }
    public void addLowLevelButtonListener(ActionListener listener) { lowLevelOptionsButton.addActionListener(listener); }

    public void addViewReservationListener(ActionListener listener) { viewReservation.addActionListener(listener); }
    public void addViewDateButtonListener(ActionListener listener) { viewDate.addActionListener(listener); }
    public void addViewRoomButtonListener(ActionListener listener) { viewRoom.addActionListener(listener); }

    public void addMainMenuButtonListener(ActionListener listener) { mainMenuButton.addActionListener(listener); }
}
