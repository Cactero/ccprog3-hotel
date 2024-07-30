package updateBasePrice;

import Model.CentralModel;
import Model.Hotel;
import shared.AbstractModel;
import Model.MainFrame;
import shared.SelectableHotel;

/**
 * The Model for Update Base Price
 * @author Ryan Gemal
 */
public class UpdateBasePriceModel extends AbstractModel implements SelectableHotel {

    private Hotel selectedHotel;

    public UpdateBasePriceModel(CentralModel centralModel, MainFrame frame){
        super(centralModel);
        controller = new UpdateBasePriceController(this, frame);
    }

    /**
     * The Model of Main Menu that is created when the user clicks the Cancel button
     */
    public AbstractModel manageHotel(){
        return centralModel.getModel(CentralModel.MANAGE_HOTEL);
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

    public Float getBasePrice() { return selectedHotel.getBasePrice(); }

    public void setBasePrice(float basePrice) { selectedHotel.setBasePrice(basePrice); }
}
