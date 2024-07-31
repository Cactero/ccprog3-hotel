package createRoom;

import Model.Room;
import Model.Utilities;
import shared.AbstractController;
import Model.MainFrame;

import javax.swing.*;

/**
 * The Controller for Create Room
 * @author Angela Domingo
 */
public class CreateRoomController extends AbstractController {

    /**
     * The Constructor for Create Room Controller
     * @param model the Model object of Create Room
     * @param frame the main frame of the program
     */
    public CreateRoomController(CreateRoomModel model, MainFrame frame) {
        super(model, frame);
        this.view = new CreateRoomView(model.isFromCreateHotel());

        ((CreateRoomView) view).addMainMenuButtonListener(_ -> cancel());
        ((CreateRoomView) view).addCreateRoomButtonListener(_ -> createRoom());
    }

    /**
     * The logic behind clicking the Create Room button.
     */
    private void createRoom(){
        boolean hasConflict = false;

        try {
            String newRoomFloor = ((CreateRoomView) view).getRoomFloor().toUpperCase();
            int newRoomNumber = Integer.parseInt(((CreateRoomView) view).getRoomNumber());
            String newRoomType = ((CreateRoomView) view).getRoomType();

            for (Room room : ((CreateRoomModel) model).getSelectedHotel().getRooms()){
                if (room != null){
                    if (Utilities.roomsMatch(room.getRoomFloor(), room.getRoomNumber(), newRoomFloor, newRoomNumber)){
                        hasConflict = true;
                    }
                }
            }

            if (!hasConflict){
                Room newRoom = new Room(newRoomFloor, newRoomNumber, ((CreateRoomModel) model).getSelectedHotel().getBasePrice(), newRoomType);
                ((CreateRoomModel) model).addRoom(newRoom);
                JOptionPane.showMessageDialog(null, "Successfully added new room!", "New room added", JOptionPane.PLAIN_MESSAGE);
                ((CreateRoomView) view).resetInputFields();
                if (((CreateRoomModel) model).isFromCreateHotel())
                    frame.switchView(((CreateRoomModel) model).mainMenu());
                else
                    ((CreateRoomView) view).resetInputFields();
            } else {
                JOptionPane.showMessageDialog(null, "A room with the same name was found.", "Duplicate room name found", JOptionPane.PLAIN_MESSAGE);
                ((CreateRoomView) view).resetInputFields();
            }

        } catch (NumberFormatException _){
            JOptionPane.showMessageDialog(null, "Room number is not a number.", "Incorrect room number input", JOptionPane.PLAIN_MESSAGE, null);
        }
    }

    /**
     * Brings the user back to the Manage Hotel screen when the Cancel button is clicked.
     */
    public void cancel(){
        frame.switchView(((CreateRoomModel) model).manageHotel());
    }
}
