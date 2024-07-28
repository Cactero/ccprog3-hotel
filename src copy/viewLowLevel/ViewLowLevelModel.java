package viewLowLevel;

import Model.CentralModel;
import Model.Hotel;
import chooseHotel.ChooseHotelModel;
import main.AbstractModel;
import main.MainFrame;

/**
 * The Model for View Room Availability
 * @author Ryan Gemal
 */
public class ViewLowLevelModel extends AbstractModel {

    private Hotel selectedHotel;

    public ViewLowLevelModel(CentralModel centralModel, MainFrame frame){
        super(centralModel);
        controller = new ViewLowLevelController(this, frame);
    }

    public AbstractModel mainMenu() {
        return centralModel.getModel(CentralModel.MAIN_MENU);
    }

    /**
     * The Model of View Hotel that is retrieved when the user clicks the Cancel button
     */
    public AbstractModel viewHotel(){
        return centralModel.getModel(CentralModel.VIEW_HOTEL);
    }

    /**
     * The Model of Choose Hotel that is retrieved when the user clicks one of the buttons
     */
    public AbstractModel chooseHotel(String source){
        ChooseHotelModel model = (ChooseHotelModel) centralModel.getModel(CentralModel.CHOOSE_HOTEL);
        model.setSource(source);
        return model;
    }


    /**
     * Sets the selected hotel the user chose previously in the Choose Hotel screen
     * @param hotel the selected Hotel
     */
    public void setSelectedHotel(Hotel hotel) {
        this.selectedHotel = hotel;
    }

    /**
     * Gets the selected hotel the user chose previously in the Choose Hotel screen
     * @return the selected Hotel
     */
    public Hotel getSelectedHotel() {
        return selectedHotel;
    }}
