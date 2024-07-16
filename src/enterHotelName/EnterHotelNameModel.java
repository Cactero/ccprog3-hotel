package enterHotelName;

import app.*;
import createRoom.CreateRoomModel;
import mainMenu.MainMenuModel;

import java.util.ArrayList;

public class EnterHotelNameModel {
    private ArrayList<Hotel> hotels;

    public EnterHotelNameModel(ArrayList<Hotel> hotels, boolean fromChangeHotelName){
        this.hotels = hotels;
        new EnterHotelNameController(this, fromChangeHotelName);
    }

    public ArrayList<Hotel> getHotels(){
        return this.hotels;
    }

    public void addHotel(Hotel hotel){
        this.hotels.add(hotel);
    }

    public void mainMenu(){
        new MainMenuModel(this.hotels);
    }

    public void createRoom(Hotel hotel, boolean fromCreateHotel){
        new CreateRoomModel(this.hotels, hotel, fromCreateHotel);
    }

}
