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
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        if (choice == JOptionPane.YES_OPTION){
            ((RemoveHotelModel) model).removeHotel(hotel);
            JOptionPane.showMessageDialog(null, "Successfully removed " + hotel.getName(), "Hotel removed", JOptionPane.PLAIN_MESSAGE);
            frame.switchView(((RemoveHotelModel) model).manageHotel());
        } else {
            frame.switchView(((RemoveHotelModel) model).chooseHotel());
        }
    }
}
