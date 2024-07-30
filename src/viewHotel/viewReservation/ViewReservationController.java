package viewHotel.viewReservation;

import Model.*;
import createReservation.CreateReservationModel;
import createReservation.CreateReservationView;
import shared.AbstractController;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * The Controller for View Reservation.
 * @author Ryan Gemal
 */
public class ViewReservationController extends AbstractController {

    public ViewReservationController(ViewReservationModel model, MainFrame frame) {
        super(model, frame);
        this.view = new ViewReservationView();

        ((ViewReservationView) view).addMainMenuButtonListener(_ -> mainMenu());
    }

    public void mainMenu() {
        frame.switchView(((ViewReservationModel) model).mainMenu());
    }

    public void updateText(Client client) {
        if (client != null) {
            ((ViewReservationView) view).updateText(client.getFirstName(), client.getLastName(), client.getCheckInDay(), client.getCheckOutDay(), client.getBookedRoom().getFormattedName(),
                                                    client.getBookedRoom().getType(), client.getNormalPrice(), client.getFinalPrice(), client.getDiscountsUsed());
        }
    }
}
