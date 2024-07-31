package updateBasePrice;

import Model.CentralModel;
import Model.Hotel;
import manageHotel.ManageHotelModel;
import shared.AbstractModel;
import Model.MainFrame;
import shared.SelectableHotel;

/**
 * The Model for Update Base Price
 * @author Ryan Gemal
 */
public class UpdateBasePriceModel extends AbstractModel implements SelectableHotel {

    private Hotel selectedHotel;

    /**
     * The Constructor for Update Base Price Model
     * @param centralModel the object of the Central Model
     * @param frame the main frame of the program
     */
    public UpdateBasePriceModel(CentralModel centralModel, MainFrame frame){
        super(centralModel);
        controller = new UpdateBasePriceController(this, frame);
    }

    /**
     * Retrieves the model associated with the key for managing hotels.
     * @return the Model for Manage Hotel.
     */
    public ManageHotelModel manageHotel() {
        return (ManageHotelModel) centralModel.getModel(CentralModel.MANAGE_HOTEL);
    }

    /**
     * Sets the selected hotel the user chose previously in the Choose Hotel screen
     * @param hotel the selected Hotel
     */
    @Override
    public void setSelectedHotel(Hotel hotel) {
        this.selectedHotel = hotel;
    }

    /**
     * Gets the selected hotel the user chose previously in the Choose Hotel screen
     * @return the selected Hotel
     */
    @Override
    public Hotel getSelectedHotel() {
        return selectedHotel;
    }

    /**
     * Sets a new base price in the Hotel.
     * @param basePrice the new base price of the Hotel.
     */
    public void setBasePrice(float basePrice) {
        int index = getHotels().indexOf(selectedHotel);
        getHotels().get(index).setBasePrice(basePrice);
    }
}
