package mainMenu;

import Model.CentralModel;
import chooseHotel.ChooseHotelModel;
import enterHotelName.EnterHotelNameModel;
import main.AbstractModel;
import main.MainFrame;

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
     * @return the Model of Enter Hotel Name
     */
    public AbstractModel createHotel(){
        EnterHotelNameModel CHModel = (EnterHotelNameModel) centralModel.getModel(CentralModel.CREATE_HOTEL);
        CHModel.setFromCreateHotel(true);
        return CHModel;
    }

    /**
     * The Model of Choose Hotel that is created when the user clicks the View Hotel button
     * @return the Model of Choose Hotel
     */
    public AbstractModel viewHotel(){
        ChooseHotelModel model = (ChooseHotelModel) centralModel.getModel(CentralModel.CHOOSE_HOTEL);
        model.setSource(ChooseHotelModel.VIEW_HOTEL);
        return model;
    }

    /**
     * The Model of Manage Hotel that is created when the user clicks the Manage Hotel button
     * @return the Model of Manage Hotel
     */
    public AbstractModel manageHotel(){
        return centralModel.getModel(CentralModel.MANAGE_HOTEL);
    }

    /**
     * The Model of Choose Hotel that is created when the user clicks the Create Reservation button
     * @return the Model of Choose Hotel
     */
    public AbstractModel createReservation(){
        ChooseHotelModel model = (ChooseHotelModel) centralModel.getModel(CentralModel.CHOOSE_HOTEL);
        model.setSource(ChooseHotelModel.CREATE_RESERVATION);
        return model;
    }

}
