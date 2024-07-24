package viewHotel;

import Model.Room;

import javax.swing.*;

/**
 * The Controller for Create Room
 * @author Angela Domingo
 */
public class ViewHotelController {

    private VIewHotelModel viewHotelModel;
    private ViewHotelView viewHotelView;

    public ViewHotelController(VIewHotelModel viewHotelModel) {
        this.viewHotelModel = viewHotelModel;
        this.viewHotelView = new ViewHotelView();

        viewHotel();
    }

    public void viewHotel(){
        boolean hasConflict = false;

        try {
            String newRoomFloor = viewHotelView.getRoomFloor();
            int newRoomNumber = Integer.parseInt(viewHotelView.getRoomNumber());
            String newRoomType = viewHotelView.getRoomType();

            for (Room room : viewHotelModel.getSelectedHotel().getRooms()){
                if (room != null){
                    if (ManageHotel.roomsMatch(room.getRoomFloor(), room.getRoomNumber(), newRoomFloor, newRoomNumber)){
                        hasConflict = true;
                    }
                }
            }

            if (!hasConflict){
                Room newRoom = new Room(newRoomFloor, newRoomNumber, viewHotelModel.getSelectedHotel().getBasePrice());
                newRoom.setRoomType(newRoomType);
                //viewHotelModel.addRoom(newRoom);
                JOptionPane.showMessageDialog(null, "Successfully added new room!", "New room added", JOptionPane.PLAIN_MESSAGE);
                viewHotelView.resetInputFields();
            } else {
                JOptionPane.showMessageDialog(null, "A room with the same name was found.", "Duplicate room name found", JOptionPane.PLAIN_MESSAGE);
                viewHotelView.resetInputFields();
            }

        } catch (NumberFormatException _){
            JOptionPane.showMessageDialog(null, "Room number is not a number.", "Incorrect room number input", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
