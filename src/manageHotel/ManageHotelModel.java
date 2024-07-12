package manageHotel;

import app.Hotel;
import createHotel.CreateHotelModel;
import createReservation.CreateReservationModel;
import mainMenu.MainMenuController;

import java.util.ArrayList;

public class ManageHotelModel {
    private static ArrayList<Hotel> hotels;

    public ManageHotelModel(ArrayList<Hotel> hotels){
        this.hotels = hotels;
        new ManageHotelController(this);
    }
}
