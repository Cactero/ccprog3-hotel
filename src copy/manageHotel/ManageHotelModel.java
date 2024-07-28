package manageHotel;

import Model.CentralModel;
import Model.Hotel;
import chooseHotel.ChooseHotelModel;
import enterHotelName.EnterHotelNameModel;
import main.AbstractModel;
import main.MainFrame;
import mainMenu.MainMenuController;
import mainMenu.MainMenuModel;

import javax.swing.*;
import java.util.ArrayList;

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
        EnterHotelNameModel model = (EnterHotelNameModel) centralModel.getModel(CentralModel.REMOVE_HOTEL);
        model.setFromCreateHotel(2);
        return model;
    }
}
