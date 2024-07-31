package removeHotel;

import Model.Hotel;
import shared.AbstractController;
import shared.AbstractModel;
import Model.MainFrame;
import shared.PopupScreen;

import javax.swing.*;

/**
 * The Controller for Remove Room
 * @author Angela Domingo
 */
public class RemoveHotelController extends AbstractController implements PopupScreen {

    /**
     * The Constructor for Remove Hotel Controller
     * @param model the Model object of Remove Hotel
     * @param frame the main frame of the program
     */
    public RemoveHotelController(AbstractModel model, MainFrame frame) {
        super(model, frame);
        this.view = new RemoveHotelView();
    }

    /**
     * The implementation of promptUser in PopupScreen for Remove Reservation.
     */
    @Override
    public void promptUser() {
        Hotel hotel = ((RemoveHotelModel) model).getSelectedHotel();
        int choice = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to delete " + hotel.getName() + "?",
                "Deleting " + hotel.getName(),
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        if (choice == JOptionPane.YES_OPTION){
            ((RemoveHotelModel) model).removeHotel();
            JOptionPane.showMessageDialog(null, "Successfully removed " + hotel.getName(), "Hotel removed", JOptionPane.PLAIN_MESSAGE);
            if (model.getHotels().isEmpty())
                frame.switchView(((RemoveHotelModel) model).mainMenu());
            else
                frame.switchView(((RemoveHotelModel) model).manageHotel());
        } else if (choice == JOptionPane.CANCEL_OPTION){
            frame.switchView(((RemoveHotelModel) model).manageHotel());
        } else {
            frame.switchView(((RemoveHotelModel) model).chooseHotel());
        }
    }
}
