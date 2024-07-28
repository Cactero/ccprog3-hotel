package shared;

import Model.Hotel;

/**
 * The interface for MVCs that require a selected hotel to work.
 * @author Angela Domingo
 */
public interface SelectableHotel {

    /**
     * Interface method for setting the selected hotel.
     * @param hotel the selected Hotel
     */
    void setSelectedHotel(Hotel hotel);

    /**
     * Interface method for returning the user's selected Hotel.
     * @return the Hotel the user selected
     */
    Hotel getSelectedHotel();
}
