package manageHotel;

import Model.CentralModel;
import chooseHotel.ChooseHotelModel;
import main.AbstractModel;
import main.MainFrame;

/**
 * The Model for Manage Hotel
 * @author Angela Domingo
 */
public class ManageHotelModel extends AbstractModel {

    public ManageHotelModel(CentralModel centralModel, MainFrame frame){
        super(centralModel);
        new ManageHotelController(this, frame);
    }

    /**
     * The Model of Main Menu that is retrieved when the user clicks the Cancel button
     * @return the Model of Main Menu
     */
    public AbstractModel mainMenu(){
        return centralModel.getModel(CentralModel.MAIN_MENU);
    }

    /**
     * The desired Choose Hotel Model object that is retrieved when the user clicks one of the buttons.
     * @param source where Choose Hotel will lead to once the Choose Hotel View is passed
     * @return the desired Choose Hotel Model object with the appropriate source
     */
    public AbstractModel chooseHotel(String source){
        ChooseHotelModel model = (ChooseHotelModel) centralModel.getModel(CentralModel.CHOOSE_HOTEL);
        model.setSource(source);
        return model;
    }
}
