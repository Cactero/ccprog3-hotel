package manageHotel;

import Model.CentralModel;
import chooseHotel.ChooseHotelModel;
import shared.AbstractModel;
import Model.MainFrame;

/**
 * The Model for Manage Hotel
 * @author Angela Domingo
 */
public class ManageHotelModel extends AbstractModel {

    public ManageHotelModel(CentralModel centralModel, MainFrame frame){
        super(centralModel);
        controller = new ManageHotelController(this, frame);
    }

    /**
     * The Model of Main Menu that is retrieved when the user clicks the Cancel button
     */
    public AbstractModel mainMenu(){
        return centralModel.getModel(CentralModel.MAIN_MENU);
    }

    /**
     * The Model of Choose Hotel that is retrieved when the user clicks one of the buttons
     */
    public AbstractModel chooseHotel(String source){
        ChooseHotelModel model = (ChooseHotelModel) centralModel.getModel(CentralModel.CHOOSE_HOTEL);
        model.setSource(source);
        return model;
    }

    public AbstractModel removeHotel(){
        return centralModel.getModel(CentralModel.REMOVE_HOTEL);
    }
}
