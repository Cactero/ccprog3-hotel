package TEMPLATE_MVC_FILES_NEW;

import app.Hotel;
import main.MainFrame;

import javax.swing.*;
import java.util.ArrayList;

public class Controller2 {
    Model2 modelFileOfFolder;
    View2 viewFileOfController;

    private MainFrame frame;

    public Controller2(ArrayList<Hotel> hotels, MainFrame frame){
        this.modelFileOfFolder = new Model2(hotels);
        this.viewFileOfController = new View2();
        this.frame = frame;

        viewFileOfController.addMainMenuButtonListener(this::mainMenuListener);

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

    // deconstruct the method so that it is its entire function
    private void mainMenuListener() {
        System.out.printf("hallo");
        frame.switchToModel1();
    }

    public JPanel getContentHolder(){
        return viewFileOfController.getContentHolder();
    }
}
