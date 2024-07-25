package manageHotel;

import main.AbstractView;
import shared.TemplateButton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 *
 */
public class ManageHotelView extends AbstractView {

    private JButton changeHotelName;
    private JButton addRooms;
    private JButton removeRooms;
    private JButton updateBasePrice;
    private JButton removeReservation;
    private JButton removeHotel;
    private JButton changeRoomType;
    private JButton datePriceModifier;

    private JButton mainMenuButton;

    public ManageHotelView(){
        super("/assets/LABELS/MANAGE_HOTEL.png");

        JPanel optionsHolder = new JPanel();
        optionsHolder.setOpaque(false);
        changeHotelName = new TemplateButton("Change Hotel Name");
        addRooms = new TemplateButton("Add Rooms");
        removeRooms = new TemplateButton("Remove Rooms");
        updateBasePrice = new TemplateButton("Update Base Price");
        removeReservation = new TemplateButton("Remove Reservation");
        removeHotel = new TemplateButton("Remove Hotel");
        changeRoomType = new TemplateButton("Change Room Type");
        datePriceModifier = new TemplateButton("Add Date Price Modifier");
        optionsHolder.add(changeHotelName);
        optionsHolder.add(addRooms);
        optionsHolder.add(removeRooms);
        optionsHolder.add(updateBasePrice);
        optionsHolder.add(removeReservation);
        optionsHolder.add(removeHotel);
        optionsHolder.add(changeRoomType);
        optionsHolder.add(datePriceModifier);
        contentHolder.add(optionsHolder);


        // cancel room creation and create room buttons
        JPanel buttonsHolder = new JPanel();
        buttonsHolder.setOpaque(false);
        mainMenuButton = new TemplateButton("Cancel");
        buttonsHolder.add(mainMenuButton);
        contentHolder.add(buttonsHolder, BorderLayout.SOUTH);


    }

    public void addAddRoomsButtonListener(ActionListener listener) { addRooms.addActionListener(listener); }
    public void addRemoveRoomsButtonListener(ActionListener listener) { removeRooms.addActionListener(listener); }
    public void addChangeHotelNameButtonListener(ActionListener listener) { changeHotelName.addActionListener(listener); }
    public void addUpdateBasePriceButtonListener(ActionListener listener) { updateBasePrice.addActionListener(listener); }
    public void addRemoveReservationButtonListener(ActionListener listener) { removeReservation.addActionListener(listener); }
    public void addRemoveHotelButtonListener(ActionListener listener) { removeReservation.addActionListener(listener); }
    public void addChangeRoomTypeButtonListener(ActionListener listener) { changeRoomType.addActionListener(listener); }
    public void addDPMButtonListener(ActionListener listener) { datePriceModifier.addActionListener(listener); }
    public void addMainMenuButtonListener(ActionListener listener) { mainMenuButton.addActionListener(listener); }
}
