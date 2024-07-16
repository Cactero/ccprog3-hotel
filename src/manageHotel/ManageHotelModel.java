package manageHotel;

import app.Hotel;
import chooseHotel.ChooseHotelModel;
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

    public void chooseHotel(){
        new ChooseHotelModel(hotels, false);
    }
}
