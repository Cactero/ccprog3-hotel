package removeRoom;

import Model.Hotel;
import Model.Room;
import main.AbstractController;
import main.AbstractModel;
import main.MainFrame;
import shared.PopupScreen;

import javax.swing.*;
import java.util.Arrays;
import java.util.HashMap;

/**
 * The Controller for Remove Room
 * @author Angela Domingo
 */
public class RemoveRoomController extends AbstractController implements PopupScreen {
    public RemoveRoomController(AbstractModel model, MainFrame frame) {
        super(model, frame);
        view = new RemoveRoomView();
    }

    /**
     * The implementation of promptUser in PopupScreen for Remove Room.
     */
    @Override
    public void promptUser() {
        String selectedRoomName;
        Hotel hotel = ((RemoveRoomModel) model).getSelectedHotel();
        HashMap<String, Room> roomHashMap = new HashMap<>();

        String[] roomNames = Arrays.stream(hotel.getRooms())
                .map(Room::getFormattedName)
                .toArray(String[]::new);

        for (Room room : hotel.getRooms()){
            if (room != null){
                roomHashMap.put(room.getFormattedName(), room);
            }
        }

        selectedRoomName = (String) JOptionPane.showInputDialog(null, "Select a hotel", "Choose Hotel", JOptionPane.PLAIN_MESSAGE, null, roomNames, roomNames[0]);
        Room selectedRoom = roomHashMap.get(selectedRoomName);
        ((RemoveRoomModel) model).removeRoom(selectedRoom);
        JOptionPane.showMessageDialog(null, "Successfully removed " + selectedRoomName, "Room removed", JOptionPane.PLAIN_MESSAGE);
        frame.switchView(((RemoveRoomModel) model).manageHotel());
    }
}
