package mainMenu;

import shared.AbstractController;
import Model.MainFrame;

import javax.swing.*;

/**
 * The Controller for Main Menu
 * @author Angela Domingo
 * @author Ryan Gemal
 */
public class MainMenuController extends AbstractController {

    /**
     * The Constructor for Main Menu Controller
     * @param model the Model object of Main Menu
     * @param frame the main frame of the program
     */
    public MainMenuController(MainMenuModel model, MainFrame frame) {
        super(model, frame);
        this.view = new MainMenuView();

        ((MainMenuView) view).addCreateHotelButtonListener(_ -> createHotel());
        ((MainMenuView) view).addViewHotelButtonListener(_ -> viewHotel());
        ((MainMenuView) view).addManageHotelButtonListener(_ -> manageHotel());
        ((MainMenuView) view).addCreateReservationButtonListener(_ -> createReservation());
        ((MainMenuView) view).addExitButtonListener(_ -> exit());
    }

    /**
     * Switches to the Create Hotel view.
     */
    public void createHotel(){
        frame.switchView(((MainMenuModel) this.model).createHotel());
    }

    /**
     * Switches to the View Hotel view.
     */
    public void viewHotel(){
        boolean hotelListEmpty = model.getHotels().isEmpty();

        if (!hotelListEmpty){
            frame.switchView(((MainMenuModel) model).viewHotel());
        }
        else {
            JOptionPane.showMessageDialog(null, "No hotel exists in the system, please make a new one first.", "No hotels found", JOptionPane.PLAIN_MESSAGE);
        }
    }

    /**
     * Switches to the Manage Hotel view.
     */
    public void manageHotel(){
        boolean hotelListEmpty = model.getHotels().isEmpty();

        if (!hotelListEmpty){
            frame.switchView(((MainMenuModel) model).manageHotel());
        }
        else {
            JOptionPane.showMessageDialog(null, "No hotel exists in the system, please make a new one first.", "No hotels found", JOptionPane.PLAIN_MESSAGE);
        }
    }

    /**
     * Switches to the Create Reservation view.
     */
    public void createReservation(){
        boolean hotelListEmpty = model.getHotels().isEmpty();

        if (!hotelListEmpty){
            frame.switchView(((MainMenuModel) model).createReservation());
        }
        else {
            JOptionPane.showMessageDialog(null, "No hotel exists in the system, please make a new one first.", "No hotels found", JOptionPane.PLAIN_MESSAGE);
        }
    }

    /**
     * Exits the program through the exit program button.
     */
    public void exit(){
        System.exit(0);
    }

}
