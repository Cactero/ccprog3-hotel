package manageHotel;

import main.AbstractView;
import shared.TemplateButton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The View for Manage Hotel.
 * @author Angela Domingo
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

    /**
     * Adds a listener to the Add Rooms button.
     * @param listener the set of actions to be done when the button is clicked
     */
    public void addAddRoomsButtonListener(ActionListener listener) { addRooms.addActionListener(listener); }

    /**
     * Adds a listener to the Remove Rooms button.
     * @param listener the set of actions to be done when the button is clicked
     */
    public void addRemoveRoomsButtonListener(ActionListener listener) { removeRooms.addActionListener(listener); }

    /**
     * Adds a listener to the Change Hotel Name button.
     * @param listener the set of actions to be done when the button is clicked
     */
    public void addChangeHotelNameButtonListener(ActionListener listener) { changeHotelName.addActionListener(listener); }

    /**
     * Adds a listener to the Update Base Price button.
     * @param listener the set of actions to be done when the button is clicked
     */
    public void addUpdateBasePriceButtonListener(ActionListener listener) { updateBasePrice.addActionListener(listener); }

    /**
     * Adds a listener to the Remove Reservation button.
     * @param listener the set of actions to be done when the button is clicked
     */
    public void addRemoveReservationButtonListener(ActionListener listener) { removeReservation.addActionListener(listener); }

    /**
     * Adds a listener to the Remove Hotel button.
     * @param listener the set of actions to be done when the button is clicked
     */
    public void addRemoveHotelButtonListener(ActionListener listener) { removeHotel.addActionListener(listener); }

    /**
     * Adds a listener to the Change Room Type button.
     * @param listener the set of actions to be done when the button is clicked
     */
    public void addChangeRoomTypeButtonListener(ActionListener listener) { changeRoomType.addActionListener(listener); }

    /**
     * Adds a listener to the Date Price Modifier button.
     * @param listener the set of actions to be done when the button is clicked
     */
    public void addDPMButtonListener(ActionListener listener) { datePriceModifier.addActionListener(listener); }

    /**
     * Adds a listener to the Main Menu button.
     * @param listener the set of actions to be done when the button is clicked
     */
    public void addMainMenuButtonListener(ActionListener listener) { mainMenuButton.addActionListener(listener); }

}
