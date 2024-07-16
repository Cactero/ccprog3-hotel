package mainMenu;

import app.Hotel;
import chooseHotel.ChooseHotelModel;
import enterHotelName.EnterHotelNameModel;
import manageHotel.ManageHotelModel;

import java.util.ArrayList;

public class MainMenuModel {
    private ArrayList<Hotel> hotels;

    public MainMenuModel(ArrayList<Hotel> hotels){
        this.hotels = hotels;
        new MainMenuController(this);
    }

    public ArrayList<Hotel> getHotels() {
        return hotels;
    }

    public void createHotel(){
        new EnterHotelNameModel(hotels, false);
    }

    public void manageHotel(){
        new ManageHotelModel(hotels);
    }

    public void createReservation(){
        // add select hotel screen first
         new ChooseHotelModel(hotels, true);
    }

}
