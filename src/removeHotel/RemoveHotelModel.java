package removeHotel;

import Model.CentralModel;
import Model.Hotel;
import chooseHotel.ChooseHotelModel;
import shared.AbstractModel;
import Model.MainFrame;
import shared.SelectableHotel;

/**
 * The Model for Remove Room.
 * @author Angela Domingo
 */
public class RemoveHotelModel extends AbstractModel implements SelectableHotel {

    private Hotel selectedHotel;

    public RemoveHotelModel(CentralModel centralModel, MainFrame frame) {
        super(centralModel);
        controller = new RemoveHotelController(this, frame);
    }

    public void removeHotel(){
        centralModel.removeHotel(selectedHotel);
    }

    public AbstractModel manageHotel(){
        return centralModel.getModel(CentralModel.MANAGE_HOTEL);
    }

    public AbstractModel mainMenu(){
            return centralModel.getModel(CentralModel.MAIN_MENU);
        }

    public AbstractModel chooseHotel(){
        ChooseHotelModel CHmodel = (ChooseHotelModel) centralModel.getModel(CentralModel.CHOOSE_HOTEL);
        CHmodel.setSource(ChooseHotelModel.REMOVE_HOTEL);
        return CHmodel;
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
}
