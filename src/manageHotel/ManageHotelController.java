package manageHotel;

import app.Hotel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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


    }



}
