package viewHotel;

import Model.CentralModel;
import Model.Hotel;
import main.AbstractModel;
import main.MainFrame;
import mainMenu.MainMenuController;
import mainMenu.MainMenuModel;
import manageHotel.ManageHotelModel;

import javax.swing.*;
import java.util.ArrayList;

/**
 * The Model for View Hotel
 * @author Angela Domingo
 * @author Ryan Gemal
 */
public class ViewHotelModel extends AbstractModel {

    public ViewHotelModel(CentralModel centralModel, MainFrame frame){
        super(centralModel);
        new ViewHotelController(this, frame);
    }

    /**
     * Return the user's selected Hotel.
     * @return the Hotel the user selected
     */
    public Hotel getSelectedHotel(){
        return selectedHotel;
    }

    /**
     * The Model of Main Menu that is created when the user clicks the Cancel button
     */
    public void mainMenu(){
        new MainMenuModel(this.hotels);
    }

    /**
     * The Model of Manage Hotel that is created when the user clicks the Cancel button
     */
    public void manageHotel(){
        new ManageHotelModel(hotels);
    }

}
