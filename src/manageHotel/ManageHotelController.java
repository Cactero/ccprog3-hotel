package manageHotel;

import app.Hotel;

import java.util.ArrayList;

public class ManageHotelController {

    private ManageHotelView manageHotelView;
    private ManageHotelModel manageHotelModel;

    public ManageHotelController(ManageHotelModel manageHotelModel){
        this.manageHotelModel = manageHotelModel;
        manageHotelView = new ManageHotelView();
    }



}
