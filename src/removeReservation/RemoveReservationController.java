package removeReservation;

import Model.Client;
import Model.Hotel;
import shared.AbstractController;
import shared.AbstractModel;
import Model.MainFrame;
import shared.PopupScreen;

import javax.swing.*;
import java.util.ArrayList;

/**
 * The Controller for Remove Room
 * @author Angela Domingo
 */
public class RemoveReservationController extends AbstractController implements PopupScreen {
    public RemoveReservationController(AbstractModel model, MainFrame frame) {
        super(model, frame);
        this.view = new RemoveReservationView();
    }

    /**
     * The implementation of promptUser in PopupScreen for Remove Reservation.
     */
    @Override
    public void promptUser() {
        String selectedClientName;
        Hotel hotel = ((RemoveReservationModel) model).getSelectedHotel();

        ArrayList<Client> clients = hotel.getClients();
        if (clients.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No clients available", "Error", JOptionPane.ERROR_MESSAGE);
            frame.switchView(((RemoveReservationModel) model).manageHotel());
        }

        String[] clientNames = clients.stream()
                .map(client -> client.getLastName() + ", " + client.getFirstName())
                .toArray(String[]::new);

        selectedClientName = (String) JOptionPane.showInputDialog(null, "Select a reservation", "Choose Reservation", JOptionPane.PLAIN_MESSAGE, null, clientNames, clientNames[0]);

        if (selectedClientName == null) {
            // User canceled the input dialog
            frame.switchView(((RemoveReservationModel) model).manageHotel());
        }

        Client selectedClient = clients.stream()
                .filter(client -> (client.getLastName() + ", " + client.getFirstName()).equals(selectedClientName))
                .findFirst()
                .orElse(null);

        ((RemoveReservationModel) model).removeReservation(selectedClient);
        JOptionPane.showMessageDialog(null, "Successfully removed " + selectedClientName, "Client removed", JOptionPane.PLAIN_MESSAGE);
        frame.switchView(((RemoveReservationModel) model).manageHotel());
    }
}
