package datePriceModifier;

import Model.CentralModel;
import Model.Hotel;
import Model.discount.DatePriceModifier;
import shared.AbstractModel;
import Model.MainFrame;
import shared.SelectableHotel;

import java.util.ArrayList;

public class DPMModel extends AbstractModel implements SelectableHotel {

    private Hotel selectedHotel;

    public DPMModel(CentralModel centralModel, MainFrame frame) {
        super(centralModel);
        controller = new DPMController(this, frame);
    }

    public AbstractModel manageHotel(){
        return centralModel.getModel(CentralModel.MANAGE_HOTEL);
    }

    /**
     * Interface method for setting the selected hotel.
     * @param hotel the selected Hotel
     */
    @Override
    public void setSelectedHotel(Hotel hotel) {
        this.selectedHotel = hotel;
    }

    /**
     * Interface method for returning the user's selected Hotel.
     * @return the Hotel the user selected
     */
    @Override
    public Hotel getSelectedHotel() {
        return selectedHotel;
    }

    public void addDPM(String discountName, ArrayList<Integer> affectedDates, float modifiedRate){
        int index = getHotels().indexOf(selectedHotel);
        centralModel.getHotel(index).addDPMAffectedDates(discountName, affectedDates, modifiedRate);
    }
}