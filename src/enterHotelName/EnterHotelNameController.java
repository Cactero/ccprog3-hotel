package enterHotelName;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.*;


public class EnterHotelNameController {
    private EnterHotelNameModel enterHotelNameModel;
    private EnterHotelNameView enterHotelNameView;

    public EnterHotelNameController(EnterHotelNameModel enterHotelNameModel, boolean fromChangeHotelName){
        this.enterHotelNameModel = enterHotelNameModel;
        enterHotelNameView = new EnterHotelNameView(fromChangeHotelName);

        enterHotelNameView.addCreateHotelButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean hasConflict = false;
                String hotelName = enterHotelNameView.getHotelName();

                if (hotelName.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Enter a hotel name.", "No hotel name", JOptionPane.PLAIN_MESSAGE);
                    enterHotelNameView.resetInputFields();
                } else {
                    for (Hotel hotel : enterHotelNameModel.getHotels()){
                        if (hotel.getName().equals(hotelName)){
                            hasConflict = true;
                        }
                    }

                    if (!hasConflict){
                        Hotel hotel = new Hotel(hotelName);
                        enterHotelNameModel.addHotel(hotel);
                        enterHotelNameView.dispose();
                        enterHotelNameModel.createRoom(hotel,true);
                    } else {
                        JOptionPane.showMessageDialog(null, "A hotel with the same name already exists.", "Invalid Hotel Name", JOptionPane.PLAIN_MESSAGE);
                    }
                }
            }
        });

        enterHotelNameView.addMainMenuButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enterHotelNameView.dispose();
                enterHotelNameModel.mainMenu();
            }
        });

    }


}
