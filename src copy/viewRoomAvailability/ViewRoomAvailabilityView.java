package viewRoomAvailability;

import main.AbstractView;
import shared.TemplateButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 *
 */
public class ViewRoomAvailabilityView extends AbstractView {

    private JButton viewCalendar;

    private JButton mainMenuButton;

    public ViewRoomAvailabilityView(){
        super("/assets/LABELS/VIEW_HOTEL.png");

        JPanel optionsHolder = new JPanel();
        optionsHolder.setOpaque(false);
        viewCalendar = new TemplateButton("View Calendar");
        optionsHolder.add(viewCalendar);
        contentHolder.add(optionsHolder);

        // cancel room creation and create room buttons
        JPanel buttonsHolder = new JPanel();
        buttonsHolder.setOpaque(false);
        mainMenuButton = new TemplateButton("Cancel");
        buttonsHolder.add(mainMenuButton);
        contentHolder.add(buttonsHolder, BorderLayout.SOUTH);


    }

    public void addViewCalendarButtonListener(ActionListener listener) { viewCalendar.addActionListener(listener); }
    public void addMainMenuButtonListener(ActionListener listener) { mainMenuButton.addActionListener(listener); }
}
