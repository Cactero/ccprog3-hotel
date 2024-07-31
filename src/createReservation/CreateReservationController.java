package createReservation;

import Model.Client;
import Model.Hotel;
import Model.Room;
import Model.Utilities;
import Model.discount.Discount;
import Model.discount.IWorkHereDiscount;
import Model.discount.PaydayDiscount;
import Model.discount.Stay4Get1Discount;
import shared.AbstractController;
import Model.MainFrame;

import javax.swing.*;
import java.util.Arrays;
import java.util.Objects;

/**
 * The Controller for Create Reservation.
 * @author Angela Domingo
 */
public class CreateReservationController extends AbstractController {

    /**
     * The Constructor for Create Reservation Controller
     * @param model the Model object of Create Reservation
     * @param frame the main frame of the program
     */
    public CreateReservationController(CreateReservationModel model, MainFrame frame) {
        super(model, frame);
        this.view = new CreateReservationView(model.getSelectedHotel());

        ((CreateReservationView) view).addCreateClientButtonListener(_ -> createClient());
        ((CreateReservationView) view).addMainMenuButtonListener(_ -> cancel());
    }

    /**
     * Creates the client object to be added to the database of Hotels.
     */
    public void createClient(){

        String firstName = ((CreateReservationView) view).getFirstName();
        String lastName = ((CreateReservationView) view).getLastName();
        int checkInDay = ((CreateReservationView) view).getCheckInDay();
        int checkOutDay = ((CreateReservationView) view).getCheckOutDay();
        String bookedRoomName = ((CreateReservationView) view).getSelectedRoom();
        String discountCode = ((CreateReservationView) view).getDiscountCode();

        Hotel bookedHotel = ((CreateReservationModel) model).getSelectedHotel();
        if (bookedHotel == null) {
            JOptionPane.showMessageDialog(null, "No hotel selected", "Error", JOptionPane.ERROR_MESSAGE);
        }

        Room bookedRoom = Arrays.stream(bookedHotel.getRooms())
                .filter(room -> room != null && room.getFormattedName().equals(bookedRoomName))
                .findFirst()
                .orElse(null);

        if (firstName.isEmpty() || lastName.isEmpty()){
            JOptionPane.showMessageDialog(null, "Enter both your first and last name.", "Incomplete name", JOptionPane.PLAIN_MESSAGE);
        } else if (!Utilities.isBookedDatesValid(bookedHotel, bookedRoom, checkInDay, checkOutDay)) {
            JOptionPane.showMessageDialog(null, "Your booking dates are not valid, please try again!", "Invalid booking dates", JOptionPane.PLAIN_MESSAGE);
            ((CreateReservationView) view).resetInputFields();
        } else if (Utilities.isRoomOccupied(bookedHotel, bookedRoom, checkInDay, checkOutDay)) {
            JOptionPane.showMessageDialog(null, "Your room is occupied during these dates, please try again.", "Occupied room during selected dates", JOptionPane.PLAIN_MESSAGE);
            ((CreateReservationView) view).resetInputFields();
        } else {
            Client newClient = new Client(firstName, lastName, checkInDay, checkOutDay, bookedRoom);
            computeDiscounts(newClient, discountCode);
            ((CreateReservationModel) model).addClient(newClient);
            JOptionPane.showMessageDialog(null, "Successfully added new client!", "New client added", JOptionPane.PLAIN_MESSAGE);
            ((CreateReservationView) view).resetInputFields();
            frame.switchView(((CreateReservationModel) model).mainMenu());
        }
    }

    /**
     * Helper method to compute the discounts and final price of the new Client.
     * @param client the new Client
     * @param discountCode the entered discount code in the Create Reservation View
     */
    private void computeDiscounts(Client client, String discountCode){

        float finalPrice = client.getNormalPrice();
        Discount discount;

        Hotel selectedHotel = ((CreateReservationModel) model).getSelectedHotel();
        discount = selectedHotel.getDatePriceModifier();
        finalPrice = discount.applyDiscount(client, finalPrice);

        switch (discountCode) {
            case "STAY4_GET1" -> {
                discount = new Stay4Get1Discount();
                client.addDiscountsUsed(((Stay4Get1Discount) discount).getDiscountName());
                finalPrice = discount.applyDiscount(client, finalPrice);
            }
            case "I_WORK_HERE" -> {
                discount = new IWorkHereDiscount();
                client.addDiscountsUsed(((IWorkHereDiscount) discount).getDiscountName());
                finalPrice = discount.applyDiscount(client, finalPrice);
            }
            case "PAYDAY" -> {
                discount = new PaydayDiscount();
                client.addDiscountsUsed(((PaydayDiscount) discount).getDiscountName());
                finalPrice = discount.applyDiscount(client, finalPrice);
            }
        }

        client.setFinalPrice(finalPrice);
    }

    /**
     * Returns the user to the main menu screen
     */
    public void cancel(){
        frame.switchView(((CreateReservationModel) model).mainMenu());
    }

    /**
     * Updates the dropdown box of room names in Create Reservation View.
     */
    public void updateRoomComboBox() {
        Hotel selectedHotel = ((CreateReservationModel) model).getSelectedHotel();
        if (selectedHotel != null) {
            String[] roomNames = Arrays.stream(selectedHotel.getRooms())
                    .filter(Objects::nonNull)
                    .map(Room::getFormattedName)
                    .toArray(String[]::new);
            ((CreateReservationView) view).updateRoomList(roomNames);
        }
    }

}
