package shared;

import Model.Client;

/**
 * The interface for MVCs that require a selected reservation to work.
 * @author Ryan Gemal
 */
public interface SelectableReservation {

    /**
     * Interface method for setting the selected reservation.
     * @param client the selected client
     */
    void setSelectedReservation(Client client);

    /**
     * Interface method for returning the user's selected reservation.
     * @return the reservation the user selected
     */
    Client getSelectedReservation();
}
