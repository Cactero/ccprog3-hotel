package createReservation;

import app.Hotel;
import mainMenu.MainMenuModel;
import manageHotel.ManageHotelModel;

import java.util.ArrayList;

public class CreateReservationModel {
    private ArrayList<Hotel> hotels;

    public CreateReservationModel(ArrayList<Hotel> hotels){
        this.hotels = hotels;
        new CreateReservationController(this);
    }

    public void manageHotel(){
        new ManageHotelModel(hotels);
    }

}
