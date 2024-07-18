package manageHotel;

import app.Hotel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The Controller for Manage Hotel.
 * @author Angela Domingo
 */
public class ManageHotelController {

    private ManageHotelView manageHotelView;
    private ManageHotelModel manageHotelModel;

    public ManageHotelController(ManageHotelModel manageHotelModel){
        this.manageHotelModel = manageHotelModel;
        manageHotelView = new ManageHotelView();

        manageHotelView.addMainMenuButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manageHotelView.dispose();
                manageHotelModel.mainMenu();
            }
        });

        manageHotelView.addAddRoomsButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manageHotelView.dispose();
                manageHotelModel.chooseHotel();
            }
        });

        manageHotelView.addRemoveRoomsButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manageHotelView.dispose();
                manageHotelModel.chooseHotel();
            }
        });

        manageHotelView.addChangeHotelNameButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manageHotelView.dispose();
                manageHotelModel.chooseHotel();
            }
        });

        manageHotelView.addUpdateBasePriceButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manageHotelView.dispose();
                manageHotelModel.chooseHotel();
            }
        });

        manageHotelView.addRemoveReservationButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manageHotelView.dispose();
                manageHotelModel.chooseHotel();
            }
        });

        manageHotelView.addRemoveHotelButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manageHotelView.dispose();
                manageHotelModel.chooseHotel();
            }
        });

        manageHotelView.addChangeRoomTypeButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manageHotelView.dispose();
                manageHotelModel.chooseHotel();
            }
        });

    }



}
