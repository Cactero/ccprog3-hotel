package enterHotelName;

import javax.swing.*;

import Model.*;
import main.AbstractController;
import main.MainFrame;
import mainMenu.MainMenuModel;
import mainMenu.MainMenuView;

/**
 * The Controller for Enter Hotel Name
 * @author Angela Domingo
 */
public class EnterHotelNameController extends AbstractController {

    public EnterHotelNameController(EnterHotelNameModel model, MainFrame frame) {
        super(model, frame);
        this.view = new EnterHotelNameView();
        enterHotelName();

        /*
        enterHotelNameView.addCreateHotelButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*
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
        */
    }

    public void enterHotelName(){
//        boolean hasConflict = false;
//        String hotelName = ((EnterHotelNameView) view).getHotelName();
//
//        if (hotelName.isEmpty()){
//            JOptionPane.showMessageDialog(null, "Enter a hotel name.", "No hotel name", JOptionPane.PLAIN_MESSAGE);
//        } else {
//            for (Hotel hotel : model.getHotels()){
//                if (hotel.getName().equals(hotelName)){
//                    hasConflict = true;
//                }
//            }
//
//            if (!hasConflict){
//                Hotel hotel = new Hotel(hotelName);
//                ((EnterHotelNameModel) model).addHotel(hotel);
//                frame.switchView(((EnterHotelNameModel) model).createRoom(hotel));
//            } else {
//                JOptionPane.showMessageDialog(null, "A hotel with the same name already exists.", "Invalid Hotel Name", JOptionPane.PLAIN_MESSAGE);
//            }
//        }
    }


}
