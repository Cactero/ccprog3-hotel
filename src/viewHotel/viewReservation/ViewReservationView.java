package viewHotel.viewReservation;

import shared.AbstractView;
import shared.TemplateButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 */
public class ViewReservationView extends AbstractView {

    private JButton viewReservationButton;
    private JButton mainMenuButton;

    private JLabel firstNameLabel;
    private JLabel firstNameText;
    private JLabel lastNameLabel;
    private JLabel lastNameText;
    private JLabel checkInDayLabel;
    private JLabel checkInDayText;
    private JLabel checkOutDayLabel;
    private JLabel checkOutDayText;
    private JLabel roomLabel;
    private JLabel roomText;
    private JLabel roomTypeLabel;
    private JLabel roomTypeText;
    private JLabel normalPriceLabel;
    private JLabel normalPriceText;
    private JLabel finalPriceLabel;
    private JLabel finalPriceText;
    private JLabel discountCodeLabel;
    private JComboBox<String> discountCodes;

    public ViewReservationView(){
        super("/assets/LABELS/VIEW_HOTEL.png");

        JPanel viewRoomPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        viewRoomPanel.add(new JLabel("Hotel name: "));
        JLabel hotelName = new JLabel();
        viewRoomPanel.add(hotelName);

        JPanel overallPanel = new JPanel(new GridLayout(4, 2));

        firstNameLabel = new JLabel("First Name");
        firstNameText = new JLabel();
        overallPanel.add(firstNameLabel);
        overallPanel.add(firstNameText);

        lastNameLabel = new JLabel("Last Name");
        lastNameText = new JLabel();
        overallPanel.add(lastNameLabel);
        overallPanel.add(lastNameText);

        checkInDayLabel = new JLabel("Check in Day");
        checkInDayText = new JLabel();
        overallPanel.add(checkInDayLabel);
        overallPanel.add(checkInDayText);

        checkOutDayLabel = new JLabel("Check Out Day");
        checkOutDayText = new JLabel();
        overallPanel.add(checkOutDayLabel);
        overallPanel.add(checkOutDayText);

        roomLabel = new JLabel("Room");
        roomText = new JLabel();
        overallPanel.add(roomLabel);
        overallPanel.add(roomText);

        roomTypeLabel = new JLabel("Room Type");
        roomTypeText = new JLabel();
        overallPanel.add(roomTypeLabel);
        overallPanel.add(roomTypeText);

        normalPriceLabel = new JLabel("Normal Price");
        normalPriceText = new JLabel();
        overallPanel.add(normalPriceLabel);
        overallPanel.add(normalPriceText);

        finalPriceLabel = new JLabel("Final Price");
        finalPriceText = new JLabel();
        overallPanel.add(finalPriceLabel);
        overallPanel.add(finalPriceText);

        discountCodeLabel = new JLabel("Discount Code");

        // cancel room creation and create room buttons
        JPanel buttonsHolder = new JPanel();
        buttonsHolder.setOpaque(false);
        mainMenuButton = new TemplateButton("Cancel");
        viewReservationButton = new TemplateButton("View Reservation");
        buttonsHolder.add(mainMenuButton);
        contentHolder.add(overallPanel);
        contentHolder.add(buttonsHolder, BorderLayout.SOUTH);
    }

    public void addViewReservationButtonListener(ActionListener listener) { viewReservationButton.addActionListener(listener); }

    public void addMainMenuButtonListener(ActionListener listener) { mainMenuButton.addActionListener(listener); }

    public void updateText(String firstName, String lastName, int checkIn, int checkOut, String roomName, String roomType, float normalPrice, float finalPrice, ArrayList<String> discountCodes) {
        firstNameText.setText(firstName);
        lastNameText.setText(lastName);
        checkInDayText.setText(String.valueOf(checkIn));
        checkOutDayText.setText(String.valueOf(checkOut));
        roomText.setText(roomName);
        roomTypeText.setText(roomType);
        normalPriceText.setText(String.valueOf(normalPrice));
        finalPriceText.setText(String.valueOf(finalPrice));
    }
}
