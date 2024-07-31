package manageHotel;

import Model.CentralModel;
import chooseHotel.ChooseHotelModel;
import mainMenu.MainMenuModel;
import shared.AbstractModel;
import Model.MainFrame;

/**
 * The Model for Manage Hotel
 * @author Angela Domingo
 */
public class ManageHotelModel extends AbstractModel {

    /**
     * The Constructor for Manage Hotel Model
     * @param centralModel the object of the Central Model
     * @param frame the main frame of the program
     */
    public ManageHotelModel(CentralModel centralModel, MainFrame frame){
        super(centralModel);
        controller = new ManageHotelController(this, frame);
    }

    /**
     * The Model of Main Menu that is retrieved when the user clicks the Cancel button
     * @return the Model of Main Menu
     */
    public MainMenuModel mainMenu(){
        return (MainMenuModel) centralModel.getModel(CentralModel.MAIN_MENU);
    }

    /**
     * The Model of Choose Hotel that is retrieved when the user clicks one of the buttons
     * @param source the source of where Choose Hotel was called from
     * @return a Choose Hotel Model instance with the given source
     */
    public AbstractModel chooseHotel(String source){
        ChooseHotelModel model = (ChooseHotelModel) centralModel.getModel(CentralModel.CHOOSE_HOTEL);
        model.setSource(source);
        return model;
    }
}
