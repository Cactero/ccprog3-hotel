package createReservation;

import app.Client;
import app.Hotel;
import app.Room;
import app.Utilities;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateReservationController {
    private CreateReservationModel createReservationModel;
    private CreateReservationView createReservationView;

    public CreateReservationController(CreateReservationModel createReservationModel){
        this.createReservationModel = createReservationModel;
        this.createReservationView = new CreateReservationView(createReservationModel.getSelectedHotel());

        createReservationView.addCreateClientButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = createReservationView.getFirstName();
                String lastName = createReservationView.getLastName();
                int checkInDay = createReservationView.getCheckInDay();
                int checkOutDay = createReservationView.getCheckOutDay();
                Room bookedRoom = createReservationView.getSelectedRoom();
                Hotel bookedHotel = createReservationModel.getSelectedHotel();

                if (!Utilities.isBookedDatesValid(bookedHotel, bookedRoom, checkInDay, checkOutDay)) {
                    System.out.println("Your booking dates are not valid, please try again!");
                    JOptionPane.showMessageDialog(null, "Your booking dates are not valid, please try again!", "Invalid booking dates", JOptionPane.PLAIN_MESSAGE);
                    createReservationView.resetInputFields();
                } else if (Utilities.isRoomOccupied(bookedHotel, bookedRoom, checkInDay, checkOutDay)) {
                    System.out.println("Your room is occupied during these dates, please try again.");
                    JOptionPane.showMessageDialog(null, "Your room is occupied during these dates, please try again.", "Occupied room during selected dates", JOptionPane.PLAIN_MESSAGE);
                    createReservationView.resetInputFields();
                } else {
                    Client newClient = new Client(firstName, lastName, checkInDay, checkOutDay, bookedRoom);
                    createReservationModel.addClient(newClient);
                    JOptionPane.showMessageDialog(null, "Successfully added new client!", "New client added", JOptionPane.PLAIN_MESSAGE);
                    createReservationView.dispose();
                    createReservationModel.mainMenu();
                }
            }
        });

        createReservationView.addMainMenuButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createReservationView.dispose();
                createReservationModel.mainMenu();
            }
        });

    }

}
