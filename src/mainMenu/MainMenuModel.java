package mainMenu;

import Model.CentralModel;
import Model.Hotel;
import chooseHotel.ChooseHotelModel;
import enterHotelName.EnterHotelNameModel;
import main.AbstractModel;
import main.MainFrame;
import manageHotel.ManageHotelModel;

import javax.swing.*;
import java.util.ArrayList;

/**
 * The Model for Main Menu.
 * @author Angela Domingo
 * @author Ryan Gemal
 */
public class MainMenuModel extends AbstractModel {

    public MainMenuModel(CentralModel centralModel, MainFrame frame){
        super(centralModel);
        controller = new MainMenuController(this, frame);
    }

    /**
     * The Model of Enter Hotel Name that is created when the user clicks the Create Hotel button
     */
    public AbstractModel createHotel(){
        return centralModel.getModel(CentralModel.CREATE_HOTEL);
    }

    /**
     * The Model of Choose Hotel that is created when the user clicks the View Hotel button
     */
    public AbstractModel viewHotel(){
        ChooseHotelModel model = (ChooseHotelModel) centralModel.getModel(CentralModel.CHOOSE_HOTEL);
        model.setSource(ChooseHotelModel.VIEW_HOTEL);
        return model;
    }

    /**
     * The Model of Manage Hotel that is created when the user clicks the Manage Hotel button
     */
    public AbstractModel manageHotel(){
        return centralModel.getModel(CentralModel.MANAGE_HOTEL);
    }

    /**
     * The Model of Choose Hotel that is created when the user clicks the Create Reservation button
     */
    public AbstractModel createReservation(){
        ChooseHotelModel model = (ChooseHotelModel) centralModel.getModel(CentralModel.CHOOSE_HOTEL);
        model.setSource(ChooseHotelModel.CREATE_RESERVATION);
        return model;
    }

}
