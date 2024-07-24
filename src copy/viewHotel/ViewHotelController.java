package viewHotel;

import Model.Room;
import Model.Utilities;
import main.AbstractController;
import main.MainFrame;
import mainMenu.MainMenuModel;
import mainMenu.MainMenuView;

import javax.swing.*;

/**
 * The Controller for View Hotel
 * @author Angela Domingo
 * @author Ryan Gemal
 */
public class ViewHotelController extends AbstractController {

    public ViewHotelController(ViewHotelModel model, MainFrame frame) {
        super(model, frame);
        this.view = new ViewHotelView();
        ((ViewHotelView) view).addMainMenuButtonListener(_ -> mainMenu());
        ((ViewHotelView) view).addLowLevelButtonListener(_ -> viewLowLevelInformation());
    }

    public void mainMenu(){

    }

    public void viewLowLevelInformation(){

    }
}
