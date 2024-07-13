package createRoom;

import app.Hotel;
import app.ManageHotel;
import app.Room;
import createHotel.CreateHotelModel;
import createHotel.CreateHotelView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CreateRoomController {

    private CreateRoomModel createRoomModel;
    private CreateRoomView createRoomView;

    public CreateRoomController(CreateRoomModel createRoomModel, boolean fromCreateHotel) {
        this.createRoomModel = createRoomModel;
        this.createRoomView = new CreateRoomView(fromCreateHotel);

        createRoomView.addCreateRoomButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean hasConflict = false;

                try {
                    String newRoomFloor = createRoomView.getRoomFloor();
                    int newRoomNumber = Integer.parseInt(createRoomView.getRoomNumber());
                    String newRoomType = createRoomView.getRoomType();

                    for (Room room : createRoomModel.getSelectedHotel().getRooms()){
                        if (room != null){
                            if (ManageHotel.roomsMatch(room.getRoomFloor(), room.getRoomNumber(), newRoomFloor, newRoomNumber)){
                                hasConflict = true;
                            }
                        }
                    }

                    if (!hasConflict){
                        Room newRoom = new Room(newRoomFloor, newRoomNumber, createRoomModel.getSelectedHotel().getBasePrice());
                        newRoom.setRoomType(newRoomType);
                        createRoomModel.addRoom(newRoom);
                        JOptionPane.showMessageDialog(null, "Successfully added new room!", "New room added", JOptionPane.PLAIN_MESSAGE);
                        createRoomView.resetInputFields();
                    } else {
                        JOptionPane.showMessageDialog(null, "A room with the same name was found.", "Duplicate room name found", JOptionPane.PLAIN_MESSAGE);
                    }

                    if (fromCreateHotel){
                        createRoomView.dispose();
                        new CreateRoomModel(createRoomModel.getHotels(), createRoomModel.getSelectedHotel(), false);
                    }
                } catch (NumberFormatException _){
                    JOptionPane.showMessageDialog(null, "Room number is not a number.", "Incorrect room number input", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });

        createRoomView.addMainMenuButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createRoomView.dispose();
                if (fromCreateHotel)
                    createRoomModel.mainMenu();
                else
                    createRoomModel.manageHotel();
            }
        });
    }
}
