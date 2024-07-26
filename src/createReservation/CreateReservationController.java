package createReservation;

import Model.Client;
import Model.Hotel;
import Model.Room;
import Model.Utilities;
import main.AbstractController;
import main.MainFrame;

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

    // TODO: add discount code implementation
    // TODO: add date price modifier implementation
    /**
     * The logic behind clicking the Create Client button
     */
    public void createClient(){
        String firstName = ((CreateReservationView) view).getFirstName();
        String lastName = ((CreateReservationView) view).getLastName();
        int checkInDay = ((CreateReservationView) view).getCheckInDay();
        int checkOutDay = ((CreateReservationView) view).getCheckOutDay();
        String bookedRoomName = ((CreateReservationView) view).getSelectedRoom();
        String discountCode = ((CreateReservationView) view).getDiscountCode();

        Hotel bookedHotel = ((CreateReservationModel) model).getSelectedHotel();
        Room bookedRoom = Arrays.stream(bookedHotel.getRooms())
                .filter(room -> room.getFormattedName().equals(bookedRoomName))
                .findFirst()
                .orElseThrow(); // Throws NoSuchElementException if not found

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
            ((CreateReservationModel) model).addClient(newClient);
            JOptionPane.showMessageDialog(null, "Successfully added new client!", "New client added", JOptionPane.PLAIN_MESSAGE);
            frame.switchView(((CreateReservationModel) model).mainMenu());
        }
    }

    /**
     * Brings the user back to the Main Menu screen when the Cancel button is clicked.
     */
    public void cancel(){
        frame.switchView(((CreateReservationModel) model).mainMenu());
    }

}
