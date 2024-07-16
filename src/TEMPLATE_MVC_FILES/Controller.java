package TEMPLATE_MVC_FILES;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    Model modelFileOfFolder;
    View viewFileOfController;

    public Controller(Model modelFileOfFolder){
        this.modelFileOfFolder = modelFileOfFolder;
        viewFileOfController = new View();

        // access methods created inside of view like this
        viewFileOfController.addMainMenuButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // dito mismo logic of what happens after you click button
            }
        });

        /**
         * example of how an implemented listener looks like
         *
         * createReservationView.addCreateClientButtonListener(new ActionListener() {
         *             @Override
         *             public void actionPerformed(ActionEvent e) {
         *                 String firstName = createReservationView.getFirstName();
         *                 String lastName = createReservationView.getLastName();
         *                 int checkInDay = createReservationView.getCheckInDay();
         *                 int checkOutDay = createReservationView.getCheckOutDay();
         *                 Room bookedRoom = createReservationView.getSelectedRoom();
         *                 Hotel bookedHotel = createReservationModel.getSelectedHotel();
         *
         *                 if (!Utilities.isBookedDatesValid(bookedHotel, bookedRoom, checkInDay, checkOutDay)) {
         *                     System.out.println("Your booking dates are not valid, please try again!");
         *                     JOptionPane.showMessageDialog(null, "Your booking dates are not valid, please try again!", "Invalid booking dates", JOptionPane.PLAIN_MESSAGE);
         *                     createReservationView.resetInputFields();
         *                 } else if (Utilities.isRoomOccupied(bookedHotel, bookedRoom, checkInDay, checkOutDay)) {
         *                     System.out.println("Your room is occupied during these dates, please try again.");
         *                     JOptionPane.showMessageDialog(null, "Your room is occupied during these dates, please try again.", "Occupied room during selected dates", JOptionPane.PLAIN_MESSAGE);
         *                     createReservationView.resetInputFields();
         *                 } else {
         *                     Client newClient = new Client(firstName, lastName, checkInDay, checkOutDay, bookedRoom);
         *                     createReservationModel.addClient(newClient);
         *                     JOptionPane.showMessageDialog(null, "Successfully added new client!", "New client added", JOptionPane.PLAIN_MESSAGE);
         *                     createReservationView.dispose();
         *                     createReservationModel.mainMenu();
         *                 }
         *             }
         *         });
         *
         * refer sa ginawa nating logic chuchu inside the orig mco1 files sa loob ng ManageHotel/DisplayManager/Utilities
         */
    }
}
