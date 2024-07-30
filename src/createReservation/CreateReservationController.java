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

/**
 * The Controller for Create Reservation.
 * @author Angela Domingo
 */
public class CreateReservationController extends AbstractController {

    public CreateReservationController(CreateReservationModel model, MainFrame frame) {
        super(model, frame);
        this.view = new CreateReservationView(model.getSelectedHotel());

        ((CreateReservationView) view).addCreateClientButtonListener(_ -> createClient());

        ((CreateReservationView) view).addMainMenuButtonListener(_ -> cancel());

    }

    //TODO: implement discounts
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

        if (!Utilities.isBookedDatesValid(bookedHotel, bookedRoom, checkInDay, checkOutDay)) {
            System.out.println("Your booking dates are not valid, please try again!");
            JOptionPane.showMessageDialog(null, "Your booking dates are not valid, please try again!", "Invalid booking dates", JOptionPane.PLAIN_MESSAGE);
            ((CreateReservationView) view).resetInputFields();
        } else if (Utilities.isRoomOccupied(bookedHotel, bookedRoom, checkInDay, checkOutDay)) {
            System.out.println("Your room is occupied during these dates, please try again.");
            JOptionPane.showMessageDialog(null, "Your room is occupied during these dates, please try again.", "Occupied room during selected dates", JOptionPane.PLAIN_MESSAGE);
            ((CreateReservationView) view).resetInputFields();
        } else {
            Client newClient = new Client(firstName, lastName, checkInDay, checkOutDay, bookedRoom);
            computeDiscounts(newClient, discountCode);
            ((CreateReservationModel) model).addClient(newClient);
            JOptionPane.showMessageDialog(null, "Successfully added new client!", "New client added", JOptionPane.PLAIN_MESSAGE);
            frame.switchView(((CreateReservationModel) model).mainMenu());
        }
    }
    
    private void computeDiscounts(Client client, String discountCode){

        float finalPrice = client.getNormalPrice();
        Discount discount;

        if (discountCode.equals("STAY4_GET1")){
            discount = new Stay4Get1Discount();
            client.addDiscountsUsed(((Stay4Get1Discount) discount).getDiscountName());
            finalPrice = discount.applyDiscount(client, finalPrice);
        }

        Hotel selectedHotel = ((CreateReservationModel) model).getSelectedHotel();
        discount = selectedHotel.getDatePriceModifier();
        finalPrice = discount.applyDiscount(client, finalPrice);

        if (discountCode.equals("I_WORK_HERE")){
            discount = new IWorkHereDiscount();
            client.addDiscountsUsed(((IWorkHereDiscount) discount).getDiscountName());
            finalPrice = discount.applyDiscount(client, finalPrice);
        } else if (discountCode.equals("PAYDAY")) {
            discount = new PaydayDiscount();
            client.addDiscountsUsed(((PaydayDiscount) discount).getDiscountName());
            finalPrice = discount.applyDiscount(client, finalPrice);
        }

        client.setFinalPrice(finalPrice);
    }

    public void cancel(){
        frame.switchView(((CreateReservationModel) model).mainMenu());
    }

}
