package mainMenu;

import Model.CentralModel;
import chooseHotel.ChooseHotelModel;
import enterHotelName.EnterHotelNameModel;
import manageHotel.ManageHotelModel;
import shared.AbstractModel;
import Model.MainFrame;

/**
 * The Model for Main Menu.
 * @author Angela Domingo
 * @author Ryan Gemal
 */
public class MainMenuModel extends AbstractModel {

    /**
     * The Constructor for Main Menu Model
     * @param centralModel the object of the Central Model
     * @param frame the main frame of the program
     */
    public MainMenuModel(CentralModel centralModel, MainFrame frame){
        super(centralModel);
        controller = new MainMenuController(this, frame);
    }

    /**
     * The Model of Enter Hotel Name that is created when the user clicks the Create Hotel button
     * @return the Model of Enter Hotel Name
     */
    public EnterHotelNameModel createHotel(){
        return (EnterHotelNameModel) centralModel.getModel(CentralModel.CREATE_HOTEL);
    }

    /**
     * The Model of Choose Hotel that is created when the user clicks the View Hotel button
     * @return a Choose Hotel model with the View Hotel source
     */
    public ChooseHotelModel viewHotel(){
        ChooseHotelModel model = (ChooseHotelModel) centralModel.getModel(CentralModel.CHOOSE_HOTEL);
        model.setSource(ChooseHotelModel.VIEW_HOTEL);
        return model;
    }

    /**
     * The Model of Manage Hotel that is created when the user clicks the Choose Hotel button
     * @return the Model of Manage Hotel
     */
    public ManageHotelModel manageHotel(){
        return (ManageHotelModel) centralModel.getModel(CentralModel.MANAGE_HOTEL);
    }

    /**
     * The Model of Choose Hotel that is created when the user clicks the Create Reservation button
     * @return a Choose Hotel model with the Create Reservation source
     */
    public ChooseHotelModel createReservation(){
        ChooseHotelModel model = (ChooseHotelModel) centralModel.getModel(CentralModel.CHOOSE_HOTEL);
        model.setSource(ChooseHotelModel.CREATE_RESERVATION);
        return model;
    }

}
