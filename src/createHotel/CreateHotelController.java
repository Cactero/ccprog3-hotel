package createHotel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import app.*;
import createRoom.CreateRoomModel;


public class CreateHotelController {
    private CreateHotelModel createHotelModel;
    private CreateHotelView createHotelView;

    public CreateHotelController(CreateHotelModel createHotelModel){
        this.createHotelModel = createHotelModel;
        createHotelView = new CreateHotelView();

        createHotelView.addCreateHotelButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean hasConflict = false;
                String hotelName = createHotelView.getHotelNameInput();
                for (Hotel hotel : createHotelModel.getHotels()){
                    if (hotel.getName().equals(hotelName)){
                        hasConflict = true;
                    }
                }

                if (!hasConflict){
                    Hotel hotel = new Hotel(hotelName);
                    createHotelModel.addHotel(hotel);
                    createHotelView.dispose();
                    createHotelModel.createRoom(hotel,true);
                } else {
                    JOptionPane.showMessageDialog(null, "A hotel with the same name already exists.", "Invalid Hotel Name", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });

        createHotelView.addMainMenuButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createHotelView.dispose();
                createHotelModel.mainMenu();
            }
        });

    }


}
