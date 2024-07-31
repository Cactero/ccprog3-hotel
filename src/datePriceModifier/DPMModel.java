package datePriceModifier;

import Model.CentralModel;
import Model.Hotel;
import manageHotel.ManageHotelModel;
import shared.AbstractModel;
import Model.MainFrame;
import shared.SelectableHotel;

import java.util.ArrayList;

/**
 * The Model for Date Price Modifier.
 * @author Angela Domingo
 */
public class DPMModel extends AbstractModel implements SelectableHotel {

    private Hotel selectedHotel;

    /**
     * The Constructor for DPM Model
     * @param centralModel the object of the Central Model
     * @param frame the main frame of the program
     */
    public DPMModel(CentralModel centralModel, MainFrame frame) {
        super(centralModel);
        controller = new DPMController(this, frame);
    }

    /**
     * The Model of Manage Hotel that is created when the user clicks the Choose Hotel button
     * @return the Model of Manage Hotel
     */
    public ManageHotelModel manageHotel(){
        return (ManageHotelModel) centralModel.getModel(CentralModel.MANAGE_HOTEL);
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

    /**
     * Adds the DPM to the selected Hotel
     * @param discountName the name of this set of date price modifiers
     * @param affectedDates the range of dates affected by the modified rate
     * @param modifiedRate the rate that the base price would be modified to
     */
    public void addDPM(String discountName, ArrayList<Integer> affectedDates, float modifiedRate){
        int index = getHotels().indexOf(selectedHotel);
        centralModel.getHotel(index).addDPMAffectedDates(discountName, affectedDates, modifiedRate);
    }
}
