package manageHotel;

import app.Hotel;
import createHotel.CreateHotelModel;
import createReservation.CreateReservationModel;
import mainMenu.MainMenuController;
import mainMenu.MainMenuModel;

import java.util.ArrayList;

public class ManageHotelModel {
    private ArrayList<Hotel> hotels;

    public ManageHotelModel(ArrayList<Hotel> hotels){
        this.hotels = hotels;
        new ManageHotelController(this);
    }

    public ArrayList<Hotel> getHotels(){
        return this.hotels;
    }

    public void mainMenu(){
        new MainMenuModel(hotels);
    }
}
