package viewLowLevel;

import main.AbstractView;
import shared.TemplateButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 *
 */
public class ViewLowLevelView extends AbstractView {

    private JButton viewDate;
    private JButton viewRoom;
    private JButton viewReservation;

    private JButton mainMenuButton;
    private JLabel hotelName = new JLabel();

    public ViewLowLevelView(){
        super("/assets/LABELS/VIEW_HOTEL.png");

        JPanel viewRoomPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        viewRoomPanel.add(new JLabel("Hotel name: "));
        viewRoomPanel.add(hotelName);

        JPanel optionsHolder = new JPanel();
        optionsHolder.setOpaque(false);
        viewDate = new TemplateButton("View Date");
        viewRoom = new TemplateButton("View Room");
        viewReservation = new TemplateButton("View Reservation");
        optionsHolder.add(viewDate);
        optionsHolder.add(viewRoom);
        optionsHolder.add(viewReservation);
        contentHolder.add(optionsHolder);

        // cancel room creation and create room buttons
        JPanel buttonsHolder = new JPanel();
        buttonsHolder.setOpaque(false);
        mainMenuButton = new TemplateButton("Cancel");
        buttonsHolder.add(mainMenuButton);
        contentHolder.add(buttonsHolder, BorderLayout.SOUTH);


    }

    public void addViewReservationListener(ActionListener listener) { viewReservation.addActionListener(listener); }
    public void addViewDateButtonListener(ActionListener listener) { viewDate.addActionListener(listener); }
    public void addViewRoomButtonListener(ActionListener listener) { viewRoom.addActionListener(listener); }
    public void addMainMenuButtonListener(ActionListener listener) { mainMenuButton.addActionListener(listener); }
}
