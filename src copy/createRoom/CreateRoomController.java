package createRoom;

import Model.Room;
import Model.Utilities;
import main.AbstractController;
import main.MainFrame;
import mainMenu.MainMenuModel;
import mainMenu.MainMenuView;

import javax.swing.*;

/**
 * The Controller for Create Room
 * @author Angela Domingo
 */
public class CreateRoomController extends AbstractController {

    public CreateRoomController(CreateRoomModel model, MainFrame frame) {
        super(model, frame);
        this.view = new CreateRoomView(model.isFromCreateHotel());

        ((CreateRoomView) view).addMainMenuButtonListener(_ -> mainMenu());
        ((CreateRoomView) view).addCreateRoomButtonListener(_ -> createRoom());
    }

    private void mainMenu(){
        frame.switchView(((CreateRoomModel) model).mainMenu());
    }

    private void createRoom(){
        boolean hasConflict = false;

        try {
            String newRoomFloor = ((CreateRoomView) view).getRoomFloor();
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
                Room newRoom = new Room(newRoomFloor, newRoomNumber, ((CreateRoomModel) model).getSelectedHotel().getBasePrice());
                newRoom.setRoomType(newRoomType);
                ((CreateRoomModel) model).addRoom(newRoom);
                JOptionPane.showMessageDialog(null, "Successfully added new room!", "New room added", JOptionPane.PLAIN_MESSAGE);

                if (((CreateRoomModel) model).isFromCreateHotel() == 1)
                    frame.switchView(((CreateRoomModel) model).mainMenu());
                else
                    ((CreateRoomView) view).resetInputFields();
            } else {
                JOptionPane.showMessageDialog(null, "A room with the same name was found.", "Duplicate room name found", JOptionPane.PLAIN_MESSAGE);
                ((CreateRoomView) view).resetInputFields();
            }

        } catch (NumberFormatException _){
            JOptionPane.showMessageDialog(null, "Room number is not a number.", "Incorrect room number input", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
