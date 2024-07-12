package mainMenu;

import app.Hotel;
import createHotel.CreateHotelModel;
import createReservation.CreateReservationModel;
import manageHotel.ManageHotelModel;

import java.util.ArrayList;

public class MainMenuModel {
    private ArrayList<Hotel> hotels;

    public MainMenuModel(ArrayList<Hotel> hotels){
        this.hotels = hotels;
        new MainMenuController(this);
    }

    public void createHotel(){
        new CreateHotelModel(hotels);
    }

    public void manageHotel(){
        new ManageHotelModel(hotels);
    }

    public void createReservation(){
        new CreateReservationModel(hotels);
    }

}
