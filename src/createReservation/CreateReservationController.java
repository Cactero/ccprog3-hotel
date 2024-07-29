package createReservation;

import Model.Client;
import Model.Hotel;
import Model.Room;
import Model.Utilities;
import shared.AbstractController;
import Model.MainFrame;

import javax.swing.*;

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
            return;
        }

        Room bookedRoom = null;
        for (Room room : bookedHotel.getRooms()){
            if (room != null){
                String roomName = String.format("%s%d", room.getRoomFloor(), room.getRoomNumber());
                if (roomName.equals(bookedRoomName))
                    bookedRoom = room;
            }
        }


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

    public void cancel(){
        frame.switchView(((CreateReservationModel) model).mainMenu());
    }

}
